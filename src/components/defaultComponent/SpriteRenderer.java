/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.defaultComponent;

import components.Transform;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Honza
 */
public class SpriteRenderer extends Component implements IRender
{

    private BufferedImage image;

    public SpriteRenderer(BufferedImage bi)
    {
        super("spriterenderer");
        this.image = bi;
    }

    public void setImage(BufferedImage image)
    {
        this.image = image;
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(image, object.transform.getX(), object.transform.getY(), null);
    }

    @Override
    public boolean isVisible()
    {
        return enabled;
    }

    @Override
    public Transform getTransform()
    {
        return object.getTransform();
    }
}
