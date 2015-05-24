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

/**
 *
 * @author Honza
 */
public class BackgroundColorComponent extends Component implements IRender
{

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.red);
        if (object.getTransform() != null)
        {
            Transform t = object.getTransform();

            g.drawRect(t.x, t.y, t.w, t.h);
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
