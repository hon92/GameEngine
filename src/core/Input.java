/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Honza
 */
public class Input
{

    private final Set<Integer> pressedKeys = new HashSet<>();
    private static InputHandler handler;
    private final Display display;

    public Input(Display display)
    {
        this.display = display;
        handler = new InputHandler();
        display.addKeyListener(handler);
        display.addMouseListener(handler);
        display.setFocusable(true);
        display.requestFocus();
    }

    public boolean isPressed(int key)
    {
        return pressedKeys.contains(key);
    }

    private class InputHandler implements KeyListener, MouseListener
    {

        @Override
        public void keyTyped(KeyEvent e)
        {
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            pressedKeys.add(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            pressedKeys.remove(e.getKeyCode());
        }

        @Override
        public void mouseClicked(MouseEvent e)
        {

        }

        @Override
        public void mousePressed(MouseEvent e)
        {
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
        }

    }

}
