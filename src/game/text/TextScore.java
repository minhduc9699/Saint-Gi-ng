package game.text;

import base.GameObject;
import base.Vector2D;
import game.score.Score;
import renderer.TextRenderer;

import java.awt.*;

public class TextScore extends GameObject {

        public TextScore(){
            this.renderer = new TextRenderer(
                    "Score: " + Score.score,
                    Color.CYAN,
                    "resources/FiraMono-Bold.ttf",
                    25

            );
            this.position = new Vector2D(50,50);
        }

    @Override
    public void run() {
        super.run();
        ((TextRenderer)renderer).text = "Score: " + Score.score;

    }
}
