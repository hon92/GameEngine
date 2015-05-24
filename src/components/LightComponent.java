/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import components.defaultComponent.Component;
import components.defaultComponent.IRender;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Honza
 */
public class LightComponent extends Component implements IRender
{

    private Color color = new Color(1f, 1f, 0.95f, 0.1f);
    private double radius;

    public LightComponent(double radius, Color color)
    {
        this.radius = radius;
        this.color = color;
    }

    public LightComponent(double radius)
    {
        this.radius = radius;
    }

    @Override
    public void render(Graphics gg)
    {
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = object.getTransform().getX();
        int y = object.getTransform().getY();
        g.setColor(color);

        //draw light
        for (int i = 0; i < radius * 2; i++)
        {
            int cx = (int) (x + radius / 2);
            int cy = (int) (y + radius / 2);
            g.fillRoundRect(cx - i / 2, cy - i / 2, i, i, i, i);
        }
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
