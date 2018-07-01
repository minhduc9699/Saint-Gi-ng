package game.player;

import base.Vector2D;
import input.KeyboardInput;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;

public class PlayerMove {
    public Vector2D velocity;

    public AnimationRenderer runAnimation;
    public ImageRenderer standImage;


    public PlayerMove() {
        this.velocity = new Vector2D();
        this.standImage = new ImageRenderer("resources/Saint Giong images/Saint/standing/saint_standing.png",64,64);

        this.runAnimation = new AnimationRenderer(8,
                "resources/Saint Giong images/Saint/moving/saint_moving1.png",
                "resources/Saint Giong images/Saint/moving/saint_moving2.png",
                "resources/Saint Giong images/Saint/moving/saint_moving3.png",
                "resources/Saint Giong images/Saint/moving/saint_moving4.png",
                "resources/Saint Giong images/Saint/moving/saint_moving5.png",
                "resources/Saint Giong images/Saint/moving/saint_moving6.png",
                "resources/Saint Giong images/Saint/moving/saint_moving7.png",
                "resources/Saint Giong images/Saint/moving/saint_moving8.png"
        );
    }

    public void run(Player player){
        this.velocity.set(0, 0);
        if(KeyboardInput.instance.upPressed){
                player.renderer = runAnimation;
                this.velocity.y -= 5;

        }
        if(KeyboardInput.instance.downPressed){
                player.renderer = runAnimation;
                this.velocity.y += 5;

        }
        if(KeyboardInput.instance.leftPressed){
                player.renderer = runAnimation;
                this.velocity.x -= 5;

        }
        if(KeyboardInput.instance.rightPressed){
                player.renderer = runAnimation;
                this.velocity.x += 5;

        }

//        if (!KeyboardInput.instance.upPressed) {
//            System.out.println("release up");
//            player.renderer = this.standImage;
//        }
//
//        if (!KeyboardInput.instance.downPressed) {
//            player.renderer = this.standImage;
//        }
//        if (!KeyboardInput.instance.leftPressed) {
//            player.renderer = this.standImage;
//        }
//        if (!KeyboardInput.instance.rightPressed) {
//            player.renderer = this.standImage;
        //}


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
