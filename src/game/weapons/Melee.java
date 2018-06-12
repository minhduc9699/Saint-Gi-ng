package game.weapons;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class Melee extends GameObject {
    public BoxCollider boxCollider;
    public FrameCounter frameCounter;


    public Melee() {
        this.renderer = new ImageRenderer("resources/WS109-12-2013-2-PIXLR.png",200,100);
        this.boxCollider = new BoxCollider(42,52);
        this.frameCounter = new FrameCounter(2);

    }

    public void run(){

        this.boxCollider.position.set(this.position.x-21,this.position.y-26);
        if(this.frameCounter.run()){
            this.isAlive = false;
            this.frameCounter.reset();
        }
    }
}
