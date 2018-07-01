package game.weapons;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.enemy.Enemy;
import game.enemy.ShootingEnemy;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;
import renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Melee extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    public FrameCounter frameCounter;
    private RunHitObject runHitObject;
//    BufferedImage bufferedImage;
//    Graphics graphics;


    public Melee() {
        //this.renderer = new ImageRenderer("resources/WS109-12-2013-2-PIXLR.png",200,100);
        this.boxCollider = new BoxCollider(50,100);
        this.frameCounter = new FrameCounter(2);
        this.runHitObject = new RunHitObject(Enemy.class, ShootingEnemy.class);
//        this.bufferedImage = new BufferedImage(800, 600, BufferedImage.TYPE_4BYTE_ABGR);
//
//        this.graphics = this.bufferedImage.getGraphics();

    }

    public void run(){

        this.boxCollider.position.set(this.position.x,this.position.y-50);
        if(this.frameCounter.run()){
            this.isAlive = false;
            this.frameCounter.reset();
            this.runHitObject.run(this);
        }
        //render(graphics);
    }
//    public void render(Graphics graphics){
//
//        graphics
//
//    }

//    public void render(Graphics graphics){
//        graphics.setColor(Color.RED);
//        graphics.drawRect((int)this.boxCollider.position.x,(int)this.boxCollider.position.y,50,100);
//
//    }

    @Override
    public void getHit(GameObject gameObject) {

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
