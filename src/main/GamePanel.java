package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel {
    private float xDelta = 100;
    private float yDelta = 100;
    private float xDir = 0.03f;
    private float yDir = 0.03f;
    private MouseInputs mouseInputs;
    private Color color = new Color(50, 49, 180);
    private Random rd;



    public GamePanel() {
        rd = new Random();
        setPanelSize();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }





    private void setPanelSize() {
        Dimension size = new Dimension(1200, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }





    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        updateRectangle();
//        g.setColor(color);
//        g.fillRect((int) xDelta, (int) yDelta, 200, 50);
//        repaint();
        //subImg = img.getSubimage(1*64,8*40,64,40);

       // g.drawImage(animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 240, 160, null);

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
}
