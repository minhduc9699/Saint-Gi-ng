package game.player;


import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class Player extends GameObject {
    public BoxCollider boxCollider;
    public Vector2D velocity;
    public PlayerMove playerMove;
    public PlayerHit playerHit;


    public Player() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/35062809_1614728438625643_5526487157390180352_n.png",80,80);
        this.boxCollider = new BoxCollider(40,40);
        this.playerMove = new PlayerMove();
        this.playerHit = new PlayerHit();
    }

    public void run(){
        super.run();
        playerMove.run(this);
        playerHit.run(this);
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x-20,this.position.y-20);

    }
}

