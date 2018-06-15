package game.weapons;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.enemy.Enemy;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class Melee extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    public FrameCounter frameCounter;
    private RunHitObject runHitObject;


    public Melee() {
        this.renderer = new ImageRenderer("resources/WS109-12-2013-2-PIXLR.png",200,100);
        this.boxCollider = new BoxCollider(200,100);
        this.frameCounter = new FrameCounter(2);
        this.runHitObject = new RunHitObject(Enemy.class);

    }

    public void run(){

        this.boxCollider.position.set(this.position.x-100,this.position.y-50);
        if(this.frameCounter.run()){
            this.isAlive = false;
            this.frameCounter.reset();
            this.runHitObject.run(this);
        }
    }

    @Override
    public void getHit(GameObject gameObject) {

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
