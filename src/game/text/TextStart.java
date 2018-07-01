package game.text;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;
import renderer.TextRenderer;

import java.awt.*;

public class TextStart extends GameObject {
    public TextStart(){
        this.renderer = new TextRenderer(
                "press ENTER to start game",
                Color.CYAN,
                "resources/FiraMono-Bold.ttf",
                25

        );
        this.position = new Vector2D(220,100);
    }
}
