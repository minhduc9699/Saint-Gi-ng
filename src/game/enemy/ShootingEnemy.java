package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

import java.util.Random;

public class ShootingEnemy extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    public Random random;
    public EnemyShoot enemyShoot;

    public ShootingEnemy() {
        this.velocity = new Vector2D(0,3);
        this.renderer = new ImageRenderer("resources/35305528_1618520951579725_8665048622204715008_n.png", 80,80);
        this.boxCollider = new BoxCollider(64, 64);
        this.enemyShoot = new EnemyShoot();

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        if(position.y >= 250 && position.y <=600){
            this.velocity.set(0,0);
            enemyShoot.run(this);
        }

        this.boxCollider.position.set(this.position.x - 32, this.position.y - 32);

    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

}
