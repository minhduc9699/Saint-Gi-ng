package game.enemy;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.arrow.EnemyArrow;
import game.arrow.PlayerArrow;
import game.gate.Gate;
import game.player.Player;
import game.player.Pow;
import game.score.Score;
import game.weapons.Melee;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import utils.Sound;

import javax.sound.sampled.Clip;
import javax.swing.text.PlainDocument;
import java.util.Random;

public class ShootingEnemy extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    public Random random;
    public EnemyShoot enemyShoot;
    public RunHitObject runHitObject;
    public AnimationRenderer runAnimation = new AnimationRenderer(true,4,
            "resources/enemies/range enemy/idle/range-enemy-idle1.png",
            "resources/enemies/range enemy/idle/range-enemy-idle2.png",
            "resources/enemies/range enemy/idle/range-enemy-idle3.png",
            "resources/enemies/range enemy/idle/range-enemy-idle4.png",
            "resources/enemies/range enemy/idle/range-enemy-idle5.png",
            "resources/enemies/range enemy/idle/range-enemy-idle6.png");

    public AnimationRenderer shootAnimation = new AnimationRenderer(true, 4,
            "resources/enemies/range enemy/shoot/range-enemy-shoot1.png",
            "resources/enemies/range enemy/shoot/range-enemy-shoot2.png",
            "resources/enemies/range enemy/shoot/range-enemy-shoot3.png",
            "resources/enemies/range enemy/shoot/range-enemy-shoot4.png",
            "resources/enemies/range enemy/shoot/range-enemy-shoot5.png",
            "resources/enemies/range enemy/shoot/range-enemy-shoot6.png");
    private Clip clip;


    public ShootingEnemy() {
        this.clip = Sound.loadAudio("resources/Sound/enemy_die.wav");

        this.velocity = new Vector2D(0,3);
        this.boxCollider = new BoxCollider(64, 64);
        this.enemyShoot = new EnemyShoot();
        this.renderer = runAnimation;
        this.runHitObject = new RunHitObject(
                EnemyArrow.class,
                Melee.class,
                Pow.class,
                Player.class
        );

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);

        if(position.y >= 250 && position.y <=600){
            this.velocity.set(0,0);
            this.renderer = new ImageRenderer("resources/enemies/range-enemy.png",64,64);

            enemyShoot.run(this);
        }

        this.boxCollider.position.set(this.position.x - 32, this.position.y - 32);
        runHitObject.run(this);

    }
//
//    public void createAction(ShootingEnemy shootingEnemy){
//        this.addAction(
//                new SequenceAction(
//                        new ActionAdapter() {
//                            @Override
//                            public boolean run(GameObject owner) {
//                                shootingEnemy.renderer = new AnimationRenderer(true, 2,
//                                        "resources/enemies/range enemy/shoot/range-enemy-shoot1.png",
//                                        "resources/enemies/range enemy/shoot/range-enemy-shoot2.png",
//                                        "resources/enemies/range enemy/shoot/range-enemy-shoot3.png",
//                                        "resources/enemies/range enemy/shoot/range-enemy-shoot4.png",
//                                        "resources/enemies/range enemy/shoot/range-enemy-shoot5.png",
//                                        "resources/enemies/range enemy/shoot/range-enemy-shoot6.png");
//                                return true;
//                            }
//
//                        }),
//                        new ActionAdapter({}
//
//
//        );
//
//
//    }



    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof  Melee || gameObject instanceof PlayerArrow) {
            this.isAlive = false;
            Player.powCount+= 1;
            Score.score +=5;


            this.clip.loop(1);
            this.clip.start();
        }
        if(gameObject instanceof Pow){
            this.isAlive = false;
        }
        if(gameObject instanceof  Player){
            this.position.y -= 40;
        }
    }




    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

}
