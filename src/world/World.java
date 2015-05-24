package world;

import components.BackgroundColorComponent;
import components.BoxColliderComponent;
import components.CameraComponent;
import components.ImageChanger;
import components.LightComponent;
import components.PlayerInputComponent;
import components.defaultComponent.ComponentManager;
import components.defaultComponent.SceneGraph;
import components.defaultComponent.SpriteRenderer;
import core.Art;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Game;
import objects.Camera;
import objects.Player;
import scripts.MapLoaderScript;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Honza
 */
public class World
{

    private SceneGraph sceneGraph;
    private Game game;

    public World(Game game)
    {
        this.game = game;
        sceneGraph = new SceneGraph();

        load();
    }

    private void load()
    {
        Art art = Art.getInstance();
        BufferedImage bi = art.getSubImage("mario", 0, 0, 20, 36);

        BufferedImage[] tilesImages = art.getSubImages("tiles", 0, 0, 70, 70);

        Camera mainCamera = new Camera();
        mainCamera.create();
        mainCamera.addComponent(new CameraComponent(0, 0, game.getDisplay().getWidth(), game.getDisplay().getHeight()));
        mainCamera.addComponent(new BackgroundColorComponent());
        MapLoaderScript mls = new MapLoaderScript(tilesImages);
        mainCamera.addComponent(mls);
        Player player = new Player();
        player.create();
        player.getTransform().setX(200);
        player.getTransform().setY(200);
        player.getTransform().setW(bi.getWidth());
        player.getTransform().setH(bi.getHeight());
        player.addComponent(new SpriteRenderer(bi));
        player.addComponent(new LightComponent(bi.getWidth()));
        player.addComponent(new PlayerInputComponent(game.getInput()));
        player.addComponent(new ImageChanger(tilesImages));
        player.addComponent(new BoxColliderComponent());

        //player.addChild(mainCamera);
        //player.addChild(mainCamera);
//        Enemy enemy = new Enemy();
//        enemy.create();
//        enemy.getTransform().setX(150);
//        enemy.getTransform().setY(150);
//        enemy.getTransform().setW(bi.getWidth());
//        enemy.getTransform().setH(bi.getHeight());
//        enemy.addComponent(new LightComponent(50.0, Color.gray));
    }

    public void update()
    {
        ComponentManager.getInstance().update();
    }

    public void render(Graphics g)
    {
        ComponentManager.getInstance().render(g);
    }

}
