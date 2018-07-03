package game.text;

import base.GameObject;
import base.Vector2D;
import game.score.Score;
import renderer.TextRenderer;

import java.awt.*;

public class GameOverScore extends GameObject {

    public GameOverScore(){

        this.renderer = new TextRenderer(
                "YOUR FINAL SCORE: " + Score.score,
                Color.white,
                "resources/FiraMono-Bold.ttf",
                50

        );
        this.position = new Vector2D(200,200);
    }

    @Override
    public void run() {
        super.run();
        ((TextRenderer)renderer).text = "Score: " + Score.score;

    }


}
