package game.gate;

import base.GameObject;
import base.GameObjectManager;
import game.arrow.EnemyArrow;
import game.enemy.Enemy;
import game.player.PlayerMove;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;
import scene.EndingScence;
import scene.SceneManager;

public class Gate extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    public static int life;
    public GateHp gateHp;


    public Gate() {
        this.position.set(400, 515);
        this.renderer = new ImageRenderer("resources/background/gate.png", 800, 150);
        this.boxCollider = new BoxCollider(800, 150);
        this.runHitObject = new RunHitObject(
                Enemy.class,
                EnemyArrow.class);
        this.life = 10;
        this.gateHp = GameObjectManager.instance.recycle(GateHp.class);
    }

    @Override
    public void run() {
        gateHp.count = this.life;
        super.run();
        runHitObject.run(this);
        this.boxCollider.position.set(this.position);
        if(this.life < 0){
            SceneManager.instance.changeScene(new EndingScence());

        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Enemy || gameObject instanceof EnemyArrow) {
            this.life -=1;
        }

    }
}