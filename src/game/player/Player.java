package game.player;


import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import game.arrow.EnemyArrow;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import renderer.Renderer;

public class Player extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    public Vector2D velocity;
    public PlayerMove playerMove;
    public PlayerHit playerHit;
    public Renderer animationRenderer;
    public FrameCounter frameCounter = new FrameCounter(5);
    private RunHitObject runHitObject;


    public Player() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/Saint Giong images/Saint/standing/saint_standing.png",64,64);
        this.boxCollider = new BoxCollider(40,40);
        this.playerMove = new PlayerMove();
        this.playerHit = new PlayerHit();
        this.runHitObject = new RunHitObject(
                Enemy.class,

                EnemyArrow.class);

    }

    public void run(){
        super.run();

        if(playerHit.animationRenderer.disable) {
            playerHit.animationRenderer.disable = false;
            playerHit.animationRenderer.currentIndex = 0;
            this.renderer = new ImageRenderer("resources/Saint Giong images/Saint/standing/saint_standing.png", 64, 64);
            frameCounter.reset();
        }
        playerHit.run(this);


        playerMove.run(this);
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x-20,this.position.y-20);
        this.runHitObject.run(this);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {

        if(gameObject instanceof Enemy || gameObject instanceof EnemyArrow){
            this.position.y+=40;
        }

    }
}

