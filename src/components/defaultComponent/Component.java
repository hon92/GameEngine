/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.defaultComponent;

/**
 *
 * @author Honza
 */
public abstract class Component
{

    protected String componentName;
    protected GameObject object;
    protected boolean enabled;

    public Component(String name)
    {
        this.componentName = name;
        this.object = null;
        this.enabled = true;
        awake();
    }

    public Component()
    {
        this("component");
    }

    public void awake()
    {

    }

    public void update()
    {

    }

    public void start()
    {

    }

    public void destroy()
    {

    }

    public String getComponentName()
    {
        return componentName;
    }
}
