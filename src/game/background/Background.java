package game.background;

import base.GameObject;
import renderer.BackgroundRenderer;

import java.awt.*;

public class Background extends GameObject {

    public Background() {
        this.renderer = new BackgroundRenderer("resources/background/map.png", 800, 600);
    }
}
