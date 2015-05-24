/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts;

import components.BoxColliderComponent;
import components.Transform;
import components.defaultComponent.Script;
import components.defaultComponent.SpriteRenderer;
import java.awt.image.BufferedImage;
import java.util.Random;
import objects.Tile;

/**
 *
 * @author Honza
 */
public class MapLoaderScript extends Script
{

    private BufferedImage[] images;
    private int mapW = 10;
    private int mapH = 10;

    public MapLoaderScript(BufferedImage[] images)
    {
        this.images = images;
    }

    private void loadRandom()
    {
        Random r = new Random();

        for (int x = 0; x < mapW; x++)
        {
            for (int y = 0; y < mapH; y++)
            {
                int v = r.nextInt(images.length);
                Tile tile = new Tile(70, 70);
                tile.create();
                Transform t = tile.getTransform();

                t.setX(x * tile.getW());
                t.setY(y * tile.getH());
                t.setW(tile.getW());
                t.setH(tile.getH());

                tile.addComponent(new SpriteRenderer(images[1]));
                tile.addComponent(new BoxColliderComponent());

            }
        }
    }

    @Override
    public void start()
    {
        loadRandom();
    }

}
