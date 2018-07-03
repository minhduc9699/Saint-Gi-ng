package scene;

import base.GameObject;
import base.GameObjectManager;
import game.background.Background;
import game.background.GameOverBackGround;
import game.enemy.Enemy;
import game.enemy.EnemySpawner;
import game.enemy.ShootingEnemySpawner;
import game.gate.Gate;
import game.text.GameOverScore;
import game.text.TextScore;

public class EndingScence implements Scene{

    @Override
    public void init() {
        GameObjectManager.instance.add(new GameOverBackGround());







    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();


    }



}
