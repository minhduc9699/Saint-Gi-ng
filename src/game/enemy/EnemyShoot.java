package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.arrow.EnemyArrow;

public class EnemyShoot {
    private FrameCounter frameCounter ;

    public EnemyShoot(){
        this.frameCounter = new FrameCounter(100);
    }

    public void run(ShootingEnemy shootingEnemy){

        if(this.frameCounter.run()){
            EnemyArrow enemyArrow = GameObjectManager.instance.recycle(EnemyArrow.class);
            enemyArrow.velocity= new Vector2D(0,4);
            enemyArrow.position.set(shootingEnemy.position);

            this.frameCounter.reset();
        }




    }
}
