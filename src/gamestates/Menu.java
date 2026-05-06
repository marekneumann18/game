package gamestates;

import main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static main.Game.GAME_WIDTH;

public class Menu extends State implements Statemethods {


    public Menu(Game game) {
        super(game);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.PINK);
        g.drawString("MENU",GAME_WIDTH/2,200);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            Gamestate.state = Gamestate.PLAYING;


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
