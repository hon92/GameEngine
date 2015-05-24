/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import components.defaultComponent.Component;
import java.awt.Rectangle;

/**
 *
 * @author Honza
 */
public class Transform extends Component
{

    protected int x, y, w, h;
    protected double scaleX, scaleY;
    protected double rotation;
    protected int direction;

    public boolean isInside(Transform t)
    {
//        if (t.getX() + t.getW() <= w && t.getX() >= 0 && t.getY() + t.getH() <= h && t.getY() >= 0)
//        {
//            return true;
//        }
//        return false;
        if (t.getRect().intersects(getRect()))
        {
            return true;
        }
        return false;
    }

    public Rectangle getRect()
    {
        return new Rectangle(x, y, w, h);
    }

    @Override
    public void awake()
    {
        x = 0;
        y = 0;
        scaleX = 1;
        scaleY = 1;
        rotation = 0.0;
        w = 1;
        h = 1;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getW()
    {
        return w;
    }

    public void setW(int w)
    {
        this.w = w;
    }

    public int getH()
    {
        return h;
    }

    public void setH(int h)
    {
        this.h = h;
    }

    public double getScaleX()
    {
        return scaleX;
    }

    public void setScaleX(double scaleX)
    {
        this.scaleX = scaleX;
    }

    public double getScaleY()
    {
        return scaleY;
    }

    public void setScaleY(double scaleY)
    {
        this.scaleY = scaleY;
    }

    public double getRotation()
    {
        return rotation;
    }

    public void setRotation(double rotation)
    {
        this.rotation = rotation;
    }

    public int getDirection()
    {
        return direction;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    @Override
    public String toString()
    {
        return "x: " + x + " y: " + y + " w: " + w + " h: " + h;
    }

}
