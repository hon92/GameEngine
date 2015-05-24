/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import components.defaultComponent.Script;
import components.defaultComponent.SpriteRenderer;
import core.Time;
import java.awt.image.BufferedImage;

/**
 *
 * @author Honza
 */
public class ImageChanger extends Script
{

    private BufferedImage[] images;
    private int c = 0;
    private SpriteRenderer spriteRenderer;
    private int old;

    public ImageChanger(BufferedImage[] images)
    {
        this.images = images;
    }

    @Override
    public void start()
    {
        spriteRenderer = (SpriteRenderer) object.findComponentByName("spriterenderer");
        old = Time.getElapsedSecond();
    }

    @Override
    public void update()
    {
        System.out.println(Time.getElapsedSecond());
        if (Time.getElapsedSecond() - 1 > old)
        {
            spriteRenderer.setImage(images[c]);
            c = (c + 1) % images.length;
            old = Time.getElapsedSecond();
        }

    }

}
