/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.defaultComponent;

import components.BoxColliderComponent;
import components.CameraComponent;
import components.Transform;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public class ComponentManager
{

    private static ComponentManager instance = null;

    private List<Component> components;
    private List<IRender> renderComponents;
    private List<BoxColliderComponent> colliderObjects;
    private CameraComponent cameraComponent;

    public static ComponentManager getInstance()
    {
        if (instance == null)
        {
            instance = new ComponentManager();
        }
        return instance;
    }

    private ComponentManager()
    {
        components = new ArrayList<>();
        renderComponents = new ArrayList<>();
        colliderObjects = new ArrayList<>();
    }

    public Component addComponent(Component component)
    {
        if (component instanceof IRender)
        {
            renderComponents.add((IRender) component);
        }
        else if (component instanceof CameraComponent)
        {
            cameraComponent = (CameraComponent) component;
        }
        components.add(component);
        return component;
    }

    public boolean removeComponent(Component component)
    {
        return components.remove(component);
    }

    public void removeWithGameObject(GameObject gameObject)
    {
        List<Component> componentsToRemove = new ArrayList<>();
        for (int i = 0; i < components.size(); i++)
        {
            Component c = components.get(i);
            if (c.object.equals(gameObject))
            {
                componentsToRemove.add(c);
            }
        }

        for (int i = 0; i < componentsToRemove.size(); i++)
        {
            Component c = componentsToRemove.get(i);
            removeWithGameObject(c.object);
        }

    }

    public void update()
    {
        for (int i = 0; i < colliderObjects.size(); i++)
        {
            for (int j = i + 1; j < colliderObjects.size(); j++)
            {
                BoxColliderComponent c1 = colliderObjects.get(i);
                BoxColliderComponent c2 = colliderObjects.get(j);

                if (c1.isColliding(c2))
                {
                    c1.object.onCollide(new CollisionEvent(c1.object, c2.object, c1.getRectangle(), c2.getRectangle()));
                    c2.object.onCollide(new CollisionEvent(c2.object, c1.object, c2.getRectangle(), c1.getRectangle()));
                }
            }

        }

        for (int i = 0; i < components.size(); i++)
        {
            Component c = components.get(i);
            if (c.enabled)
            {
                c.update();
            }
        }
    }

    public void render(Graphics g)
    {
        if (cameraComponent == null)
        {
            return;
        }

        for (int i = 0; i < renderComponents.size(); i++)
        {
            IRender r = renderComponents.get(i);
            if (r.isVisible())
            {
                Transform transform = r.getTransform();

                if (cameraComponent.object.getTransform() != null && cameraComponent.object.getTransform().isInside(transform))
                {
                    System.out.println(transform.toString() + " camera: " + cameraComponent.object.getTransform().toString());

                    r.render(g);
                }
//                else
//                {
//                    System.out.println("cant render");
//                }
//
//                if (transform.object instanceof Player)
//                {
//                    System.out.println("player");
//                }

            }
        }
    }

    public void create()
    {

    }

    public void destroy()
    {

    }

    public void registerCollider(BoxColliderComponent collider)
    {
        colliderObjects.add(collider);
    }

}
