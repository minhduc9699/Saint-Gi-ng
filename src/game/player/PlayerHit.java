package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.arrow.EnemyArrow;
import game.weapons.Bow;
import game.weapons.Melee;
import input.KeyboardInput;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import renderer.Renderer;

public class PlayerHit {

    public FrameCounter frameCounter;
    public AnimationRenderer animationRenderer;
    public AnimationRenderer shootingLeft;
    public AnimationRenderer shootingRight;



    public PlayerHit() {
        this.animationRenderer = new AnimationRenderer(false,
                2,
                "resources/Saint Giong images/Saint/attack/saint_attack1.png",
                "resources/Saint Giong images/Saint/attack/saint_attack2.png",
                "resources/Saint Giong images/Saint/attack/saint_attack3.png",
                "resources/Saint Giong images/Saint/attack/saint_attack4.png");
        this.shootingLeft = new AnimationRenderer(true,
                6,
                "resources/Saint/attack/shoot arrow left/saint_attack_arrow_left1.png",
                "resources/Saint/attack/shoot arrow left/saint_attack_arrow_left2.png",
                "resources/Saint/attack/shoot arrow left/saint_attack_arrow_left3.png",
                "resources/Saint/attack/shoot arrow left/saint_attack_arrow_left4.png"
                );
        this.shootingRight = new AnimationRenderer(true,
                6,
                "resources/Saint/attack/shoot arrow right/saint_attack_arrow_right1.png",
                "resources/Saint/attack/shoot arrow right/saint_attack_arrow_right2.png",
                "resources/Saint/attack/shoot arrow right/saint_attack_arrow_right3.png",
                "resources/Saint/attack/shoot arrow right/saint_attack_arrow_right4.png");
    }

    public void run(Player player){
        this.frameCounter = new FrameCounter(3   );
        if(KeyboardInput.instance.spacePressed){
            player.renderer = this.animationRenderer;
            Melee melee = new Melee();
            melee.position.set(player.position.x + 22, player.position.y - 30);
            GameObjectManager.instance.add(melee);


        }

//                player.renderer = new ImageRenderer("resources/Saint Giong images/Saint/standing/saint_standing.png",64,64);
//
//        }



            if(KeyboardInput.instance.zPressed) {
                Bow bow = new Bow();
                player.renderer = this.shootingLeft;
                //bow.renderer = new ImageRenderer("resources/download - Copy.jpg",200,100);


                bow.position.set(player.position.x - 22, player.position.y - 30);
                GameObjectManager.instance.add(bow);
            }
            if(KeyboardInput.instance.zReleased) {

                EnemyArrow arrow = GameObjectManager.instance.recycle(EnemyArrow.class);
                arrow.velocity = new Vector2D(-8, 0);
                arrow.position.set(player.position.x-30, player.position.y);
                player.renderer = new ImageRenderer("resources/Saint/standing/saint_standing.png",64,64);



            }

        if (KeyboardInput.instance.xPressed){
            player.renderer = this.shootingRight;
            Bow bow = new Bow();
            bow.position.set(player.position.x+22,player.position.y-30);
            GameObjectManager.instance.add(bow);

        }
        if(KeyboardInput.instance.xReleased) {
            EnemyArrow arrow = GameObjectManager.instance.recycle(EnemyArrow.class);
            arrow.velocity = new Vector2D(8, 0);
            arrow.position.set(player.position.x+30,player.position.y);
            frameCounter.reset();
            player.renderer = new ImageRenderer("resources/Saint/standing/saint_standing.png",64,64);
        }

    }
}
