/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.defaultComponent;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public class SceneGraph
{

    private List<GameObject> childrens;
    private GameObject root;

    public SceneGraph()
    {
        childrens = new ArrayList<>();
        root = null;
    }

    public void addGameObject(GameObject gameObject)
    {
        if (childrens.size() == 0)
        {
            root = gameObject;
        }
        childrens.add(gameObject);
    }

    public List<GameObject> getSceneObjects()
    {
        return childrens;
    }

}
