package game.player;

import base.FrameCounter;
import base.GameObject;
import game.enemy.Enemy;
import game.enemy.ShootingEnemy;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.AnimationRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pow extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    public FrameCounter frameCounter;




    public Pow(){

        this.frameCounter = new FrameCounter(3);

        this.renderer = new AnimationRenderer(false,5,
                "resources/Saint/flame breath/flame_breath1.png",
                "resources/Saint/flame breath/flame_breath2.png",
                "resources/Saint/flame breath/flame_breath3.png",
                "resources/Saint/flame breath/flame_breath4.png",
                "resources/Saint/flame breath/flame_breath5.png");
        this.boxCollider = new BoxCollider(300,500);
        this.runHitObject = new RunHitObject(Enemy.class, ShootingEnemy.class);

//        this.bufferedImage = new BufferedImage(800, 600, BufferedImage.TYPE_4BYTE_ABGR);
//
//        this.graphics = this.bufferedImage.getGraphics();
    }

    @Override
    public void run() {
        super.run();

        this.boxCollider.position.set(this.position.x-150, this.position.y-300);
        if(this.frameCounter.run()){
            this.frameCounter.reset();
            this.runHitObject.run(this);
        }
        if(((AnimationRenderer)renderer).disable){
            isAlive = false;
            ((AnimationRenderer) renderer).disable = false;
            ((AnimationRenderer)renderer).currentIndex = 0;
        }


//        System.out.println(this.boxCollider.position.x + ", " + this.boxCollider.position.y);
//        render(graphics);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }

    //    public void render(Graphics graphics){
//
//        graphics
//
//    }

//    public void render(Graphics graphics){
//        graphics.setColor(Color.RED);
//        graphics.drawRect((int)this.boxCollider.position.x,(int)this.boxCollider.position.y,300,500);
//
//    }
}
