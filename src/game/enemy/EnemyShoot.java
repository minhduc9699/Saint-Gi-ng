package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.arrow.EnemyArrow;
import utils.Sound;

import javax.sound.sampled.Clip;

public class EnemyShoot {
    private FrameCounter frameCounter ;
    private Clip clipshoot;


    public EnemyShoot(){
        this.frameCounter = new FrameCounter(100);
        this.clipshoot = Sound.loadAudio("resources/Sound/Saint_attack_arrow.wav");

    }

    public void run(ShootingEnemy shootingEnemy){

        if(this.frameCounter.run()){
            EnemyArrow enemyArrow = GameObjectManager.instance.recycle(EnemyArrow.class);
            enemyArrow.velocity= new Vector2D(0,4);
            enemyArrow.position.set(shootingEnemy.position.x,shootingEnemy.position.y+40);
            this.clipshoot.loop(1);
            this.clipshoot.start();

            this.frameCounter.reset();
        }




    }
}
