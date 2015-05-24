/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.defaultComponent;

import components.Transform;
import java.awt.Graphics;

/**
 *
 * @author Honza
 */
public interface IRender
{

    public void render(Graphics g);

    public boolean isVisible();

    public Transform getTransform();

}
