package game.arrow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

import java.awt.*;

public class EnemyArrow extends GameObject implements PhysicBody {



    public Vector2D velocity;
    public BoxCollider boxCollider;


    //constructor
    public EnemyArrow(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/35305528_1618520951579725_8665048622204715008_n.png",20,20);
        this.boxCollider = new BoxCollider(20,20);

    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 3, this.position.y - 3);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}
