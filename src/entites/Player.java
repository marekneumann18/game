package entites;

import main.Game;
import utilz.Help;
import utilz.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Help.*;

public class Player extends Entity {
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 25;
    private int playerAction = IDLE;
    private boolean left, right, up, down,jump;
    private float playerSpeed = 2.0f;
    private boolean moving = false, attacking = false;
    private int[][] lvlData;
    private float xDrawOffset = 21* Game.SCALE;
    private float yDrawOffset = 4* Game.SCALE;

    //jumping, gravity
    private float airSpeed = 0f;
    private float gravity = 0.04f * Game.SCALE;
    private float jumpSpeed = -2.25f * Game.SCALE;
    private float fallSpeedAfterCollision = 0.5f * Game.SCALE;
    private boolean inAir = false;



    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimations();
        initHitbox(x,y,20*Game.SCALE,28*Game.SCALE);
    }

    public void update() {
        updateMoving();
        updateAnimationTick();
        setAnimation();


    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex],  (int)(hitbox.x -xDrawOffset), (int) (hitbox.y -yDrawOffset), width, height, null);
        drawHitbox(g);
    }


    private void setAnimation() {
        int startAni = playerAction;
        if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }
        if (attacking) {
            playerAction = ATTACK_1;

        }
        if (startAni != playerAction) {
            resetAniTick();
        }

    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                attacking = false;
            }
        }

    }

    private void updateMoving() {
        moving = false;
        if (!left && !right && !inAir)
            return;

        float xSpeed = 0;

        if (left)
            xSpeed -=playerSpeed;
        else if (right )
            xSpeed +=playerSpeed;
        if (inAir)  {

        }else {
            updateXPos(xSpeed);
        }





//        if (canMoveHere(hitbox.x + xSpeed, hitbox.y + ySpeed, hitbox.width, hitbox.height, lvlData)) {
//            hitbox.x += xSpeed;
//            hitbox.y += ySpeed;
//            moving = true;
//        }


    }

    private void updateXPos(float xSpeed ) {
        if (canMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData)) {
            hitbox.x += xSpeed;

        }else {
            hitbox.x = GetEntityXPosNextToWall(hitbox,xSpeed);
        }
    }

    public void loadLvlData(int[][] lvlData) {
        this.lvlData = lvlData;
    }


    private void loadAnimations() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);

        animations = new BufferedImage[9][6];
        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);

            }
        }


    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;


    }
}
