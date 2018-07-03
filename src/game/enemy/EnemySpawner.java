package game.enemy;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class EnemySpawner extends GameObject {
    private FrameCounter frameCounter;
    private Random random;

    public EnemySpawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(50);
        createAction();

    }

    @Override
    public void run() {
        super.run();
//        if (this.frameCounter.run()) {
//            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
//            enemy.position.set(this.random.nextInt(800), 0);
//            this.frameCounter.reset();
//        }
    }

    public void createAction(){
        this.addAction(
                new LimitAction(
                        new SequenceAction(
                                new WaitAction(100),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                                        enemy.position.set(random.nextInt(700),2);
                                        return true;
                                    }
                                }
                        )
                        ,70)
        );


    }

}
