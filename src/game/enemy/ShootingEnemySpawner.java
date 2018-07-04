package game.enemy;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.sql.SQLOutput;
import java.util.Random;

public class ShootingEnemySpawner extends GameObject {

    private FrameCounter frameCounter;
    private Random random;

    public ShootingEnemySpawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(50);
        createAction();

    }

    @Override
    public void run() {
        super.run();
//        if (this.frameCounter.run()) {
//            ShootingEnemy shootingEnemy = GameObjectManager.instance.recycle(ShootingEnemy.class);
//            shootingEnemy.position.set(this.random.nextInt(800), 0);
//            shootingEnemy.velocity.set(0,3);
//            this.frameCounter.reset();
//        }
    }

    public void createAction(){

        this.addAction(
                new SequenceAction(
                        new WaitAction(200),
                        new LimitAction(
                                new SequenceAction(
                                        new ActionAdapter() {
                                            @Override
                                            public boolean run(GameObject owner) {
                                                ShootingEnemy shootingEnemy = GameObjectManager.instance.recycle(ShootingEnemy.class);
                                                shootingEnemy.position.set(random.nextInt(700), 2);
                                                shootingEnemy.velocity.set(0,3);
                                                return true;
                                            }
                                        },new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        return GameObjectManager.instance.countObjectAlive(ShootingEnemy.class) < 3;
                                    }
                                }


                                ),
                                50
                        )
                )
        );
    }


}
