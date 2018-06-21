package game.player;

import base.Vector2D;
import input.KeyboardInput;

public class PlayerMove {
    public Vector2D velocity;



    public PlayerMove() {
        this.velocity = new Vector2D();
    }

    public void run(Player player){
        this.velocity.set(0, 0);
        if(KeyboardInput.instance.upPressed){
            this.velocity.y -= 5;
        }
        if(KeyboardInput.instance.downPressed){
            this.velocity.y += 5;
        }
        if(KeyboardInput.instance.leftPressed){
            this.velocity.x -= 5;
        }
        if(KeyboardInput.instance.rightPressed){
            this.velocity.x += 5;
        }

        this.backToScreen(player);

        player.position.addUp(this.velocity);
    }


    public void backToScreen(Player player){
        if(player.position.x>=800){
            player.position.x =800-16;
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
