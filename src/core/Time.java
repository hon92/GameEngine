/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Honza
 */
public final class Time
{

    public static final double FPS = 60.0;
    public static final double UPS = 60.0;
    public static final double fixedDeltaTime = 1 / FPS;
    public static double deltaTime = fixedDeltaTime;
    public static long elapsedTime = 0;

    public static int getElapsedSecond()
    {
        return (int) (Time.elapsedTime / 1e9);
    }

}
