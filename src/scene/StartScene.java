package scene;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.background.Background;
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
        Player player1 =  GameObjectManager.instance.recycle(Player.class);
        player1.position.set(500,300);
        player1.renderer = this.animationRenderer;
        Player player2 = GameObjectManager.instance.recycle(Player.class);
        player2.position.set(450,300);
        player2.renderer = this.hitRenderer;
        Player player3 = GameObjectManager.instance.recycle(Player.class);
        player3.position.set(550,300);
        player3.renderer = this.hitRenderer;
        Player player4 =  GameObjectManager.instance.recycle(Player.class);
        player4.position.set(400,300);
        player4.renderer = this.animationRenderer;
        Player player5 = GameObjectManager.instance.recycle(Player.class);
        player5.position.set(600,300);
        player5.renderer = this.animationRenderer;
        Player player6 = GameObjectManager.instance.recycle(Player.class);
        player6.position.set(350,300);
        player6.renderer = this.hitRenderer;
        Player player7 = GameObjectManager.instance.recycle(Player.class);
        player7.position.set(650,300);
        player7.renderer = this.hitRenderer;
        GameObjectManager.instance.add(new TextStart());
//        if(KeyboardInput.instance.enterPress){
//            SceneManager.instance.changeScene(new GamePlayScene());
//            System.out.println("Enter pressed");
//
//        }



    }


    @Override
    public void deinit() {
        GameObjectManager.instance.clear();


    }
//    public void setupPlayer(){
//        Player player = new Player();
//        this.player.position.set(500,300);
//        GameObjectManager.instance.add(this.player);
//
//    }
}
