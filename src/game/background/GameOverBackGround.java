package game.background;

import base.GameObject;
import renderer.BackgroundRenderer;

public class GameOverBackGround extends GameObject {
    public GameOverBackGround() {
        this.renderer = new BackgroundRenderer("resources/lose screen/lose.png", 800, 600);
    }

}
