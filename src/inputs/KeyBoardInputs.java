package inputs;

import entites.Player;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utilz.Constants.Directions.*;

public class KeyBoardInputs implements KeyListener {
    private final GamePanel gamePanel;
    private final Player player;

    public KeyBoardInputs(GamePanel gamePanel, Player player) {
        this.gamePanel = gamePanel;
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:

                player.setDirection(UP);
                break;
            case KeyEvent.VK_A:

              player.setDirection(LEFT);
                break;
            case KeyEvent.VK_S:

               player.setDirection(DOWN);
                break;
            case KeyEvent.VK_D:

                player.setDirection(RIGHT);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D:
                player.setMoving(false);
                break;
        }

    }
}
