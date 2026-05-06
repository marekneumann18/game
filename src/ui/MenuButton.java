package ui;

import gamestates.Gamestate;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.UI.Buttons.*;

public class MenuButton {
    private int xPos, yPos, row, index;
    private Gamestate gamestate;
    private BufferedImage[] images;
    private int xOffCenter = B_WIDTH / 2;

    public MenuButton(int xPos, int yPos, int row, Gamestate gamestate) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.row = row;
        this.gamestate = gamestate;
        loadImg();
    }

    private void loadImg() {
        images = new BufferedImage[3];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BUTTON_ATLAS);
        for (int i = 0; i < images.length; i++) {
            images[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, row * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);

        }

    }

    public void draw(Graphics g) {

        g.drawImage(images[index], xPos - xOffCenter, yPos, B_WIDTH, B_HEIGHT, null);
    }

    public void update() {
        index = 0;
    }
}
