package game.gate;

import base.GameObject;
import renderer.HpRenderer;

import java.awt.*;

public class GateHp extends GameObject {
    public int count;

    public GateHp(){
        this.position.set(650,60);
        this.renderer = new HpRenderer(0,15, Color.GREEN);
    }

    @Override
    public void run() {
        super.run();
        HpRenderer hpRenderer = (HpRenderer) this.renderer;
        hpRenderer.width = 10*count;
    }
}
