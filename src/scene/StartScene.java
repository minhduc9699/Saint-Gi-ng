package scene;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.background.Background;
import game.background.StartBackground;
import game.enemy.Enemy;
import game.player.Player;
import game.text.TextStart;
import input.KeyboardInput;
import renderer.AnimationRenderer;
import renderer.TextRenderer;

import javax.swing.text.TabExpander;
import java.awt.*;
import java.awt.image.BufferedImage;

public class StartScene implements Scene {


    public AnimationRenderer animationRenderer = new AnimationRenderer(3,
            "resources/Saint Giong images/Saint/moving/saint_moving1.png",
            "resources/Saint Giong images/Saint/moving/saint_moving2.png",
            "resources/Saint Giong images/Saint/moving/saint_moving3.png",
            "resources/Saint Giong images/Saint/moving/saint_moving4.png",
            "resources/Saint Giong images/Saint/moving/saint_moving5.png",
            "resources/Saint Giong images/Saint/moving/saint_moving6.png",
            "resources/Saint Giong images/Saint/moving/saint_moving7.png",
            "resources/Saint Giong images/Saint/moving/saint_moving8.png");
    public AnimationRenderer hitRenderer = new AnimationRenderer(true,
            6,
            "resources/Saint Giong images/Saint/attack/saint_attack1.png",
            "resources/Saint Giong images/Saint/attack/saint_attack2.png",
            "resources/Saint Giong images/Saint/attack/saint_attack3.png",
            "resources/Saint Giong images/Saint/attack/saint_attack4.png");

    public TextRenderer textRenderer = new TextRenderer("Press ENTER to play",Color.BLUE,"resources/FiraMono-Bold.ttf",100);

    @Override
    public void init() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new StartBackground());


    }


    @Override
    public void deinit() {
        GameObjectManager.instance.clear();

    }

}
