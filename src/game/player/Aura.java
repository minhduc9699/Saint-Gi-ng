package game.player;

import base.GameObject;
import base.Vector2D;
import renderer.AnimationRenderer;

public class Aura extends GameObject {

    public Vector2D playerPosition = new Vector2D();
    public Aura(){
        this.renderer = new AnimationRenderer(true,6,
                "resources/aura/aura1.png",
                "resources/aura/aura2.png",
                "resources/aura/aura3.png",
                "resources/aura/aura4.png",
                "resources/aura/aura5.png",
                "resources/aura/aura6.png",
                "resources/aura/aura7.png",
                "resources/aura/aura8.png",
                "resources/aura/aura9.png",
                "resources/aura/aura10.png",
                "resources/aura/aura11.png",
                "resources/aura/aura12.png");


    }

    @Override
    public void run() {
        super.run();
        if(Player.powCount < 10){
            this.isAlive =false;
        }
    }
}
