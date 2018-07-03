package game.arrow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import game.enemy.ShootingEnemy;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;

public class PlayerArrow extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public PlayerArrow(){
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20,20);

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        this.runHitObject = new RunHitObject(Enemy.class, ShootingEnemy.class);
        this.runHitObject.run(this);
        GameObjectManager.instance.killObject(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;

    }
}
