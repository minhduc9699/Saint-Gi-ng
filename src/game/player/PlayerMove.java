package game.player;

import base.Vector2D;
import input.KeyboardInput;

public class PlayerMove {
    public Vector2D velocity;



    public PlayerMove() {
        this.velocity = new Vector2D();
    }

    public void run(Player player){
        if(KeyboardInput.instance.upPressed){
            this.velocity.y = -3;
        }
        if(KeyboardInput.instance.downPressed){
            this.velocity.y = 3;
        }
        if(KeyboardInput.instance.leftPressed){
            this.velocity.x = -3;
        }
        if(KeyboardInput.instance.rightPressed){
            this.velocity.x = 3;
        }
        if(KeyboardInput.instance.upReleased){
            this.velocity.y = 0;
        }
        if(KeyboardInput.instance.downReleased){
            this.velocity.y = 0;
        }
        if(KeyboardInput.instance.leftReleased){
            this.velocity.x = 0;
        }
        if(KeyboardInput.instance.rightReleased){
            this.velocity.x = 0;
        }
        this.backToScreen(player);

        player.velocity.set(this.velocity);
    }


    public void backToScreen(Player player){
        if(player.position.x>=1024){
            player.position.x =1020;
        }
        if(player.position.x<=0){
            player.position.x = 3;
        }

        if(player.position.y>=450){
            player.position.y = 446;
        }
        if(player.position.y<=0){
            player.position.y = 3;
        }

    }
}
