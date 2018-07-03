package game.background;

import base.GameObject;
import renderer.BackgroundRenderer;

public class StartBackground extends GameObject {
    public StartBackground() {
        this.renderer = new BackgroundRenderer("resources/start screen/start_screen.png", 800, 600);
    }

}
