package game.player;

import base.GameObject;
import base.GameObjectManager;
import physic.BoxCollider;
import renderer.HpRenderer;

import java.awt.*;



public class PowPlayer extends GameObject {
    public int count;

    public PowPlayer(){
        this.position.set(650,30);
        this.renderer = new HpRenderer(0,15, Color.RED);
    }

    @Override
    public void run() {
        super.run();
        HpRenderer hpRenderer = (HpRenderer) this.renderer;
        hpRenderer.width = 10*count;
    }
}
