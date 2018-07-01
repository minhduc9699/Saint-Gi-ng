package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.arrow.EnemyArrow;
import game.player.Player;
import game.weapons.Melee;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;

import javax.swing.*;
import java.util.Random;

public class Enemy extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    public Random random;
    private RunHitObject runHitObject;


    public Enemy() {
        this.velocity = new Vector2D();
        this.renderer = new AnimationRenderer(
                true,4,
                "resources/enemies/melee enemy/running/melee-enemy-running1.png",
                "resources/enemies/melee enemy/running/melee-enemy-running1.png",
                "resources/enemies/melee enemy/running/melee-enemy-running1.png",
                "resources/enemies/melee enemy/running/melee-enemy-running1.png",
                "resources/enemies/melee enemy/running/melee-enemy-running1.png",
                "resources/enemies/melee enemy/running/melee-enemy-running1.png"
        );
        this.boxCollider = new BoxCollider(64, 64);
        GameObjectManager.instance.killObject(this);
        this.runHitObject = new RunHitObject(
                Player.class,
                EnemyArrow.class,
                Melee.class
        );



    }


    @Override
    public void run() {
    super.run();
    this.position.addUp(0, 3);
    this.boxCollider.position.set(this.position.x - 32, this.position.y - 32);
    this.runHitObject.run(this);


}

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof  Melee || gameObject instanceof  EnemyArrow) {
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
