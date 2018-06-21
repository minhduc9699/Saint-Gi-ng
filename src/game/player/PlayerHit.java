package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.arrow.EnemyArrow;
import game.weapons.Bow;
import game.weapons.Melee;
import input.KeyboardInput;
import renderer.ImageRenderer;

public class PlayerHit {

    public FrameCounter frameCounter;



    public PlayerHit() {
    }

    public void run(Player player){
        this.frameCounter = new FrameCounter(1   );
        if(KeyboardInput.instance.spacePressed){
            Melee melee = new Melee();
            melee.position.set(player.position.x+22,player.position.y-30);
            GameObjectManager.instance.add(melee);

        }
            if(KeyboardInput.instance.zPressed) {
                Bow bow = new Bow();
                //bow.renderer = new ImageRenderer("resources/download - Copy.jpg",200,100);


                bow.position.set(player.position.x - 22, player.position.y - 30);
                GameObjectManager.instance.add(bow);
            }
            if(KeyboardInput.instance.zReleased) {
                EnemyArrow arrow = GameObjectManager.instance.recycle(EnemyArrow.class);
                arrow.velocity = new Vector2D(-4, 0);
                arrow.position.set(player.position);

            }

        if (KeyboardInput.instance.xPressed){
            Bow bow = new Bow();
            bow.position.set(player.position.x+22,player.position.y-30);
            GameObjectManager.instance.add(bow);

        }
        if(KeyboardInput.instance.xReleased) {
            EnemyArrow arrow = GameObjectManager.instance.recycle(EnemyArrow.class);
            arrow.velocity = new Vector2D(4, 0);
            arrow.position.set(player.position);
            frameCounter.reset();
        }

    }
}
