package core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import tiled.io.TMXMapReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Honza
 */
public class Art
{

    private static Art instance;
    private HashMap<String, BufferedImage> images;

    private Art()
    {
        images = new HashMap<>();

        try
        {
            loadImages();
            loadTMX();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (SAXException ex)
        {
            Logger.getLogger(Art.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(Art.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadImages() throws IOException
    {
        File files = new File("src\\Resources");
        for (File listFile : files.listFiles(new FilenameFilter()
        {

            @Override
            public boolean accept(File dir, String name)
            {
                boolean imageFiles = name.endsWith(".jpg") || name.endsWith(".png");
                return imageFiles;
            }
        }))
        {
            String name = getNameWithoutExtension(listFile.getName());
            BufferedImage image = ImageIO.read(listFile);
            images.put(name, image);
        }
    }

    private void loadTMX() throws SAXException, ParserConfigurationException, IOException
    {
        File files = new File("src\\Resources");
        for (File listFile : files.listFiles(new FilenameFilter()
        {

            @Override
            public boolean accept(File dir, String name)
            {
                boolean tmxFile = name.endsWith(".tmx");
                return tmxFile;
            }
        }))
        {
            String name = getNameWithoutExtension(listFile.getName());

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(listFile);

            TMXMapReader reader = new TMXMapReader();
            reader.accept(listFile);

//            try
//            {
//                Map map = reader.readMap("mapa");
//                map.getWidth();
//            }
//            catch (Exception ex)
//            {
//                Logger.getLogger(Art.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

    private String getNameWithoutExtension(String fullName)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fullName.length(); i++)
        {
            if (fullName.charAt(i) == '.')
            {
                break;
            }
            sb.append(fullName.charAt(i));
        }
        return sb.toString();

    }

    public static Art getInstance()
    {
        if (instance == null)
        {
            instance = new Art();
        }
        return instance;
    }

    public BufferedImage getImage(String name)
    {
        if (images.containsKey(name))
        {
            return images.get(name);
        }
        return null;
    }

    public BufferedImage getSubImage(String name, int x, int y, int w, int h)
    {
        BufferedImage bi = getImage(name);
        if (bi == null)
        {
            return null;
        }

        return bi.getSubimage(x, y, w, h);

    }

    public BufferedImage[] getSubImages(String name, int x, int y, int w, int h)
    {
        BufferedImage bi = getImage(name);
        if (bi == null)
        {
            return null;
        }

        int imageW = bi.getWidth();
        int imageH = bi.getHeight();

        int imagesCount = ((imageH - y) / h) * ((imageW - x) / w);

        BufferedImage[] images = new BufferedImage[imagesCount];

        int cx = x;
        int cy = y;

        int xoff = 1;
        int yoff = 1;

        for (int i = 0; i < imagesCount; i++)
        {

            if (cx + w >= imageW)
            {
                cx = 0;
                cy += h;
            }

            images[i] = bi.getSubimage(cx, cy, w, h);

            cx += w;
        }
        return images;
    }

}
