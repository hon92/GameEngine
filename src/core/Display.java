package core;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import main.Game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Honza
 */
public class Display extends Canvas
{

    private final JFrame window;
    private final Game game;

    public Display(String title, int width, int height) throws HeadlessException
    {
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = new Dimension(width, height);
        window.setPreferredSize(dim);
        window.setMinimumSize(dim);
        window.setMaximumSize(dim);

        setMinimumSize(dim);
        setMaximumSize(dim);
        setPreferredSize(dim);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setIgnoreRepaint(true);
        setIgnoreRepaint(true);
        createBufferStrategy(2);
        game = new Game(this);
    }

    public JFrame getWindow()
    {
        return window;
    }

    public void showDisplay()
    {
        window.setVisible(true);
    }

    public void gameStart()
    {
        Thread gameThread = new Thread(game, "gameThread");
        gameThread.start();
    }

}
