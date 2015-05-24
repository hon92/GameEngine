/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import components.defaultComponent.InputComponent;
import core.Input;
import core.Time;
import java.awt.event.KeyEvent;

/**
 *
 * @author Honza
 */
public class PlayerInputComponent extends InputComponent
{

    public PlayerInputComponent(Input input)
    {
        super(input);
    }

    @Override
    public void update()
    {

        if (input.isPressed(KeyEvent.VK_A))
        {
            int oldX = object.getTransform().getX();
            oldX -= Math.floor(100 * Time.deltaTime);
            object.getTransform().setX(oldX);
        }
        if (input.isPressed(KeyEvent.VK_W))
        {
            int oldY = object.getTransform().getY();
            oldY -= Math.floor(100 * Time.deltaTime);
            object.getTransform().setY(oldY);
        }

        if (input.isPressed(KeyEvent.VK_D))
        {
            int oldX = object.getTransform().getX();
            oldX += Math.floor(100 * Time.deltaTime);
            object.getTransform().setX(oldX);
        }
        if (input.isPressed(KeyEvent.VK_S))
        {
            int oldY = object.getTransform().getY();
            oldY += Math.floor(100 * Time.deltaTime);
            object.getTransform().setY(oldY);
        }

        if (input.isPressed(KeyEvent.VK_SPACE))
        {

        }
    }
}
