package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class ShootingEnemySpawner extends GameObject {

    private FrameCounter frameCounter;
    private Random random;

    public ShootingEnemySpawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(50);

    }

    @Override
    public void run() {
        if (this.frameCounter.run()) {
            ShootingEnemy shootingEnemy = GameObjectManager.instance.recycle(ShootingEnemy.class);
            shootingEnemy.position.set(this.random.nextInt(800), 0);
            shootingEnemy.velocity.set(0,3);
            this.frameCounter.reset();
        }
    }
}
