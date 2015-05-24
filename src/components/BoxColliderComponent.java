/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import components.defaultComponent.ComponentManager;
import components.defaultComponent.Component;
import components.defaultComponent.CollisionEvent;
import java.awt.Rectangle;

/**
 *
 * @author Honza
 */
public class BoxColliderComponent extends Component
{

    private Rectangle rectangle;

    public BoxColliderComponent()
    {
    }

    @Override
    public void start()
    {
        ComponentManager.getInstance().registerCollider(this);
        Transform transform = object.getTransform();
        rectangle = new Rectangle(transform.getX(), transform.getY(), transform.getW(), transform.getH());
    }

    @Override
    public void update()
    {
        rectangle.setBounds(object.getTransform().getX(),
                object.getTransform().getY(),
                object.getTransform().getW(),
                object.getTransform().getH());

    }

    public void OnCollide(CollisionEvent collisionEvent)
    {
        System.err.println("collide" + object.toString());
    }

    public boolean isColliding(BoxColliderComponent collider)
    {
        return collider.getRectangle().intersects(getRectangle());
    }

    public Rectangle getRectangle()
    {
        return rectangle;
    }

}
