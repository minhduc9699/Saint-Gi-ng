package game.arrow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import game.enemy.ShootingEnemy;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

import java.awt.*;

public class EnemyArrow extends GameObject implements PhysicBody {



    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;


    //constructor
    public EnemyArrow(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/enemies/range enemy/arrow/enemy_arrow.png",40,25);
        this.boxCollider = new BoxCollider(20,20);

    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        this.runHitObject = new RunHitObject(Enemy.class, ShootingEnemy.class);
        this.runHitObject.run(this);
        GameObjectManager.instance.killObject(this);

    }

//    public void render(Graphics graphics){
//        graphics.setColor(Color.RED);
//        graphics.drawRect((int)this.boxCollider.position.x,(int)this.boxCollider.position.y,20,20);
//
//    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;

    }
}
