package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;

import java.util.Random;

public class ShootingEnemy extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    public Random random;
    public EnemyShoot enemyShoot;

    public ShootingEnemy() {
        this.velocity = new Vector2D(0,3);
        this.renderer = new AnimationRenderer(true,
                4,
                "resources/enemies/range enemy/idle/range-enemy-idle1.png",
                "resources/enemies/range enemy/idle/range-enemy-idle2.png",
                "resources/enemies/range enemy/idle/range-enemy-idle3.png",
                "resources/enemies/range enemy/idle/range-enemy-idle4.png",
                "resources/enemies/range enemy/idle/range-enemy-idle5.png",
                "resources/enemies/range enemy/idle/range-enemy-idle6.png"
                );
        this.boxCollider = new BoxCollider(64, 64);
        this.enemyShoot = new EnemyShoot();

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        if(position.y >= 250 && position.y <=600){
            this.velocity.set(0,0);
            this.renderer = new AnimationRenderer(true, 3,
                    "resources/enemies/range enemy/shoot/range-enemy-shoot1.png",
                    "resources/enemies/range enemy/shoot/range-enemy-shoot2.png",
                    "resources/enemies/range enemy/shoot/range-enemy-shoot3.png",
                    "resources/enemies/range enemy/shoot/range-enemy-shoot4.png",
                    "resources/enemies/range enemy/shoot/range-enemy-shoot5.png",
                    "resources/enemies/range enemy/shoot/range-enemy-shoot6.png");
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
