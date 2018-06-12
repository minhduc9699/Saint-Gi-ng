package game.player;

import base.GameObjectManager;
import game.weapons.Melee;
import input.KeyboardInput;

public class PlayerHit {



    public PlayerHit() {
    }

    public void run(Player player){
        if(KeyboardInput.instance.spacePressed){
            Melee melee = new Melee();
            melee.position.set(player.position.x+22,player.position.y-30);
            GameObjectManager.instance.add(melee);

        }
    }
}
