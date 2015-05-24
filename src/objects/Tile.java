/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import components.defaultComponent.GameObject;

/**
 *
 * @author Honza
 */
public class Tile extends GameObject
{

    private int w, h;

    public Tile(int w, int h)
    {
        this.w = w;
        this.h = h;
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

}
