/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import components.defaultComponent.CollisionEvent;
import components.defaultComponent.GameObject;

/**
 *
 * @author Honza
 */
public class Player extends GameObject
{

    public Player()
    {

    }

    @Override
    public void onCollide(CollisionEvent collisionEvent)
    {
        if (collisionEvent.target instanceof Enemy)
        {
            System.out.println("col");
        }
    }

}
