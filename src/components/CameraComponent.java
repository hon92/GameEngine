/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import components.defaultComponent.Component;

/**
 *
 * @author Honza
 */
public class CameraComponent extends Component
{

    private int x, y, maxX, maxY;

    public CameraComponent(int x, int y, int maxX, int maxY)
    {
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public void start()
    {
        object.getTransform().setX(x);
        object.getTransform().setY(y);
        object.getTransform().setW(maxX);
        object.getTransform().setH(maxY);
    }

    @Override
    public void update()
    {
        if (object.getParent() != null)
        {
            int cx = object.getParent().getTransform().getX();
            int cy = object.getParent().getTransform().getY();
            object.getTransform().setX(cx);
            object.getTransform().setY(cy);

        }
    }

}
