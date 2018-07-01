package game.gate;

import base.GameObject;
import game.arrow.EnemyArrow;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class Gate extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    public static int life;


    public Gate() {
        this.position.set(400, 515);
        this.renderer = new ImageRenderer("resources/background/gate.png", 800, 150);
        this.boxCollider = new BoxCollider(600, 150);
        this.runHitObject = new RunHitObject(
                Enemy.class,

                EnemyArrow.class);
        this.life = 15;
    }

    @Override
    public void run() {
        super.run();
        runHitObject.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Enemy || gameObject instanceof EnemyArrow) {
            this.life --;
            System.out.println("hit");
        }

    }
}