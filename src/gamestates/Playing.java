package gamestates;

import entites.Player;
import levels.LevelManager;

import static main.Game.SCALE;

public class Playing {
    private Player player;
    private LevelManager levelManager;
    private void initClasses() {
        levelManager = new LevelManager(this);
        player = new Player(200, 200, (int) (64 * SCALE), (int) (40 * SCALE));
        player.loadLvlData(levelManager.getCurrentLevel().getLvlData());
    }
    public Player getPlayer() {
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }
}
