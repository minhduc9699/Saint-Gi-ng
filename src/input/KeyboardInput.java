package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

    public static KeyboardInput instance = new KeyboardInput();

    public boolean leftPressed;
    public boolean leftReleased;
    public boolean rightPressed;
    public boolean rightReleased;
    public boolean upPressed;
    public boolean upReleased;
    public boolean downReleased;
    public boolean downPressed;
    public boolean spacePressed;
    public boolean spaceReleased;
    public boolean zPressed;
    public boolean xPressed;
    public boolean zReleased;
    public boolean xReleased;

    private KeyboardInput() {

    }

    public void reset() {
//        this.leftPressed = false;
//        this.leftReleased = false;
//        this.rightPressed = false;
//        this.rightReleased = false;
//        this.upPressed = false;
//        this.upReleased = false;
        this.spacePressed = false;
        this.spaceReleased = false;
        this.zPressed = false;
        this.zReleased = false;
        this.xPressed = false;
        this.xReleased = false;
//        this.downPressed =false;
//        this.downReleased =false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.rightPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.downPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.spacePressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            this.xPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_Z){
            this.zPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.rightPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.downPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.spacePressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            this.xReleased = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_Z){
            this.zReleased = true;
        }
    }
}
