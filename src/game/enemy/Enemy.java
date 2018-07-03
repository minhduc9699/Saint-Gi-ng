package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.arrow.EnemyArrow;
import game.arrow.PlayerArrow;
import game.gate.Gate;
import game.player.Player;
import game.player.Pow;
import game.score.Score;
import game.weapons.Melee;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import utils.Sound;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.util.Random;

public class Enemy extends GameObject implements PhysicBody {



    public Vector2D velocity;
    public BoxCollider boxCollider;
    public Random random;
    private RunHitObject runHitObject;
    public AnimationRenderer animationRenderer = new AnimationRenderer(
            true,3,
            "resources/enemies/melee enemy/running/melee-enemy-running1.png",
            "resources/enemies/melee enemy/running/melee-enemy-running2.png",
            "resources/enemies/melee enemy/running/melee-enemy-running3.png",
            "resources/enemies/melee enemy/running/melee-enemy-running4.png",
            "resources/enemies/melee enemy/running/melee-enemy-running5.png",
            "resources/enemies/melee enemy/running/melee-enemy-running6.png"
    );
    private Clip clip;


    public Enemy() {
        this.clip = Sound.loadAudio("resources/Sound/enemy_die.wav");
        this.velocity = new Vector2D(0,3);
        this.boxCollider = new BoxCollider(64, 64);
        GameObjectManager.instance.killObject(this);
        this.runHitObject = new RunHitObject(
                Player.class,
                EnemyArrow.class,
                Melee.class,
                Pow.class
        );
        this.renderer = animationRenderer;




    }


    @Override
    public void run() {
    super.run();
    this.position.addUp(this.velocity);
    this.boxCollider.position.set(this.position.x - 32, this.position.y - 32);
    this.runHitObject.run(this);


}

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof  Melee || gameObject instanceof PlayerArrow) {
            this.isAlive = false;
            Player.powCount+= 1;
            Score.score +=5;


            this.clip.loop(1);
            this.clip.start();
        }
        if(gameObject instanceof Pow || gameObject instanceof Gate){
            this.isAlive = false;
        }
        if(gameObject instanceof  Player){
            this.position.y -= 40;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

}
