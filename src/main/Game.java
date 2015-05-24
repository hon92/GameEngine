/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import core.Display;
import core.Input;
import core.Time;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import world.World;

/**
 *
 * @author Honza
 */
public class Game implements Runnable
{

    private final Display display;
    private boolean running = false;
    private boolean paused = false;
    private World world;
    private Input input;

    public Game(Display display)
    {
        this.display = display;
        input = new Input(display);
        world = new World(this);

    }

    @Override
    public void run()
    {
        running = true;
        System.out.println("game running");
        final double FPS = Time.FPS;
        final double UPS = Time.UPS;
        final int skipFramesCount = 5;

        final double nsPerFrame = 1000000000 / FPS;
        final double nsPerUpdate = 1000000000 / UPS;

        double lastUpdate = System.nanoTime();
        double lastRender = System.nanoTime();

        int lastSecondTime = (int) (lastUpdate / 1000000000);
        int frameCount = 0;

        while (running)
        {
            double now = System.nanoTime();
            Time.elapsedTime += now - lastUpdate;
            int updateCount = 0;

            if (!paused)
            {
                while (now - lastUpdate > nsPerUpdate && updateCount < skipFramesCount)
                {
                    double deltaTime = (now - lastUpdate) / 1e9;

                    Time.deltaTime = deltaTime;
                    update();
                    lastUpdate += nsPerFrame;
                    updateCount++;
                }

                if (now - lastUpdate > nsPerUpdate)
                {
                    lastUpdate = now - nsPerUpdate;
                }

                render();
                frameCount++;
                lastRender = now;

                int thisSecond = (int) (lastUpdate / 1000000000);
                if (thisSecond > lastSecondTime)
                {
                    display.getWindow().setTitle("FPS: " + frameCount);
                    lastSecondTime = thisSecond;
                    frameCount = 0;

                }

                while (now - lastRender < nsPerFrame && now - lastUpdate < nsPerUpdate)
                {
                    Thread.yield();
                    try
                    {
                        Thread.sleep(1);
                    }
                    catch (InterruptedException ex)
                    {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    now = System.nanoTime();
                }

            }
        }

        //game end
    }

    public void update()
    {
        world.update();
    }

    public void render()
    {
        BufferStrategy bs = display.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, display.getWidth(), display.getHeight());
        world.render(g);
        g.dispose();
        bs.show();

        Toolkit.getDefaultToolkit().sync();
    }

    public Input getInput()
    {
        return input;
    }

    public World getWorld()
    {
        return world;
    }

    public Display getDisplay()
    {
        return display;
    }

}
