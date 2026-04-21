package main;

import entites.Player;
import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;

public class GamePanel extends JPanel {
    private float xDelta = 100;
    private float yDelta = 100;
    private float xDir = 0.03f;
    private float yDir = 0.03f;
    private MouseInputs mouseInputs;
    private Color color = new Color(50, 49, 180);
    private Random rd;
    private final Player player;
    private Game game;



    public GamePanel(Game game,Player player) {
        this.player = player;
        this.game = game;
        rd = new Random();
        setPanelSize();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }





    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH,GAME_HEIGHT);

        setPreferredSize(size);



    }





    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        updateRectangle();
//        g.setColor(color);
//        g.fillRect((int) xDelta, (int) yDelta, 200, 50);
//        repaint();
        game.render(g);

    }


    private void updateRectangle() {
        xDelta += xDir;
        if (xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = getRndColor();
        }
        yDelta += yDir;
        if (yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            color = getRndColor();
        }

    }

    private Color getRndColor() {
        int r = rd.nextInt(255);
        int g = rd.nextInt(255);
        int b = rd.nextInt(255);
        return new Color(r, g, b);

    }

    public Game getGame() {
        return game;
    }
}
