package game.player;

import base.GameObject;
import renderer.HpRenderer;

import java.awt.*;

public class PlayerHp extends GameObject {
    public int count;

    public PlayerHp(){
        this.position.set(650,90);
        this.renderer = new HpRenderer(0,15, Color.YELLOW);
    }

    @Override
    public void run() {
        super.run();
        HpRenderer hpRenderer = (HpRenderer) this.renderer;
        hpRenderer.width = 10*count;
    }
}
