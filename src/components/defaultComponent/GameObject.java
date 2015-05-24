/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.defaultComponent;

import components.Transform;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public abstract class GameObject
{

    private String name;
    private String tag;
    protected GameObject parent;

    protected List<GameObject> childrens;
    protected List<Component> components;

    protected Transform transform;

    public GameObject(String name)
    {
        this.name = name;
        tag = "";
        parent = null;
        transform = null;
        childrens = new ArrayList<>();
        components = new ArrayList<>();
    }

    public GameObject()
    {
        this("gameobject");
    }

    public void create()
    {
        transform = new Transform();
        transform.object = this;

        addComponent(transform);
    }

    public void destroy()
    {
        ComponentManager.getInstance().removeWithGameObject(this);

        for (int i = 0; i < childrens.size(); i++)
        {
            childrens.get(i).destroy();
        }

        childrens.clear();
        components.clear();
    }

    public void addComponent(Component component)
    {
        component.object = this;
        components.add(component);
        component.start();
        ComponentManager.getInstance().addComponent(component);
    }

    public Component findComponentByName(String name)
    {
        for (Component component : components)
        {
            if (component.getComponentName().equalsIgnoreCase(name))
            {
                return component;
            }
        }
        return null;
    }

    public void addChild(GameObject gameObject)
    {
        gameObject.parent = this;
        //gameObject.create();
        childrens.add(gameObject);
    }

    public GameObject findChildByName(String name)
    {
        return null;
    }

    public Transform getTransform()
    {
        return transform;
    }

    public void onCollide(CollisionEvent collisionEvent)
    {

    }

    public GameObject getParent()
    {
        return parent;
    }

}
