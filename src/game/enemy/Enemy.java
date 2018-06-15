package game.enemy;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

import javax.swing.*;
import java.util.Random;

public class Enemy extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    public Random random;

    public Enemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/35305528_1618520951579725_8665048622204715008_n.png", 64,64);
        this.boxCollider = new BoxCollider(64, 64);

    }

    @Override
    public void run() {
    super.run();
    this.position.addUp(0, 3);
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
