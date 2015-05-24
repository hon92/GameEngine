/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.defaultComponent;

import java.awt.Rectangle;

/**
 *
 * @author Honza
 */
public class CollisionEvent
{

    public GameObject source;
    public GameObject target;
    public Rectangle sRect;
    public Rectangle tRect;

    public CollisionEvent(GameObject source, GameObject target, Rectangle sRect, Rectangle tRect)
    {
        this.source = source;
        this.target = target;
        this.sRect = sRect;
        this.tRect = tRect;
    }

}
