package scene;

import base.GameObject;
import base.GameObjectManager;
import game.background.Background;
import game.enemy.Enemy;
import game.enemy.EnemySpawner;
import game.enemy.ShootingEnemy;
import game.enemy.ShootingEnemySpawner;
import game.gate.Gate;
import game.player.Player;

public class GamePlayScene implements Scene{

    @Override
    public void init() {
        setupCharacter();
        setupPlayer();

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();


    }
    public void setupPlayer(){

        Player player = new Player();
        player.position.set(500,300);
        GameObjectManager.instance.add(player);

    }
    public void setupCharacter(){
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new EnemySpawner());
        GameObjectManager.instance.add(new ShootingEnemySpawner());
        GameObjectManager.instance.add(new Gate());
    }

}
