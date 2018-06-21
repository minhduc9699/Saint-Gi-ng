package game.weapons;

import base.FrameCounter;
import base.GameObject;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class Bow extends GameObject {

    public FrameCounter frameCounter;
    private RunHitObject runHitObject;

    public Bow() {
        this.frameCounter = new FrameCounter(2);

    }

    public void run() {
        if(frameCounter.run()){
            this.isAlive = false;
            this.frameCounter.reset();
        }
    }

}
