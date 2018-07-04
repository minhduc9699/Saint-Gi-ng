package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.arrow.EnemyArrow;
import game.arrow.PlayerArrow;
import game.weapons.Bow;
import game.weapons.Melee;
import input.KeyboardInput;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import renderer.Renderer;
import utils.Sound;

import javax.sound.sampled.Clip;

public class PlayerHit {

    public FrameCounter frameCounter;
    public AnimationRenderer animationRenderer;
    public AnimationRenderer shootingLeft;
    public AnimationRenderer shootingRight;
    private Clip clipmelee;
    private Clip clipshoot;



    public PlayerHit() {
        this.clipmelee = Sound.loadAudio("resources/Sound/Saint_attack_spear.wav");
        this.clipshoot = Sound.loadAudio("resources/Sound/Saint_attack_arrow.wav");
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
                "resources/Saint/attack/shoot arrow left/saint_attack_arrow_left3.png",
                "resources/Saint/attack/shoot arrow left/saint_attack_arrow_left3.png",
                "resources/Saint/attack/shoot arrow left/saint_attack_arrow_left3.png",
                "resources/Saint/attack/shoot arrow left/saint_attack_arrow_left4.png"
                );
        this.shootingRight = new AnimationRenderer(true,
                6,
                "resources/Saint/attack/shoot arrow right/saint_attack_arrow_right1.png",
                "resources/Saint/attack/shoot arrow right/saint_attack_arrow_right2.png",
                "resources/Saint/attack/shoot arrow right/saint_attack_arrow_right3.png",
                "resources/Saint/attack/shoot arrow right/saint_attack_arrow_right3.png",
                "resources/Saint/attack/shoot arrow right/saint_attack_arrow_right3.png",
                "resources/Saint/attack/shoot arrow right/saint_attack_arrow_right3.png",
                "resources/Saint/attack/shoot arrow right/saint_attack_arrow_right4.png");
    }

    public void run(Player player){
        this.frameCounter = new FrameCounter(3   );
        if(KeyboardInput.instance.spacePressed){
            player.renderer = this.animationRenderer;
            Melee melee = GameObjectManager.instance.recycle(Melee.class);
            melee.position.set(player.position.x + 22, player.position.y - 30);
            this.clipmelee.loop(1);
            this.clipmelee.start();


        }

//                player.renderer = new ImageRenderer("resources/Saint Giong images/Saint/standing/saint_standing.png",64,64);
//
//        }



            if(KeyboardInput.instance.zPressed) {
                Bow bow = GameObjectManager.instance.recycle(Bow.class);
                player.renderer = this.shootingLeft;
                //bow.renderer = new ImageRenderer("resources/download - Copy.jpg",200,100);


                bow.position.set(player.position.x - 22, player.position.y - 30);
            }
            if(KeyboardInput.instance.zReleased) {

                PlayerArrow arrow = GameObjectManager.instance.recycle(PlayerArrow.class);
                arrow.velocity = new Vector2D(-8, 0);
                arrow.position.set(player.position.x-30, player.position.y);
                arrow.renderer  = new ImageRenderer("resources/Saint/enemy_arrow1.png",45,25);
                player.renderer = new ImageRenderer("resources/Saint/standing/saint_standing.png",64,64);
                this.clipshoot.loop(1);
                this.clipshoot.start();



            }

        if (KeyboardInput.instance.xPressed){
            player.renderer = this.shootingRight;
            Bow bow = new Bow();
            bow.position.set(player.position.x+22,player.position.y-30);
            GameObjectManager.instance.add(bow);

        }
        if(KeyboardInput.instance.xReleased) {
            PlayerArrow arrow2 = GameObjectManager.instance.recycle(PlayerArrow.class);
            arrow2.velocity = new Vector2D(8, 0);
            arrow2.position.set(player.position.x+30,player.position.y);
            arrow2.renderer  = new ImageRenderer("resources/Saint/enemy_arrow2.png",45,25);

            frameCounter.reset();
            player.renderer = new ImageRenderer("resources/Saint/standing/saint_standing.png",64,64);
            this.clipshoot.loop(1);
            this.clipshoot.start();
        }


        if(Player.powCount == 10){
            Aura aura = GameObjectManager.instance.recycle(Aura.class);
            aura.position = player.position;
            if(KeyboardInput.instance.cPressed){
                Pow pow = GameObjectManager.instance.recycle(Pow.class);

                pow.position.set(player.position.x,player.position.y-100);
                player.powCount = 0;
                aura.isAlive = false;

            }


        }

    }
}
