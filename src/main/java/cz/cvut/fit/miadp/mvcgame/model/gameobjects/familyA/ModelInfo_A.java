package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsModelInfo;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class ModelInfo_A extends AbsModelInfo {
    public ModelInfo_A(IGameModel model) {
        super(model);
        this.setX(10);
        this.setY(10);
    }

    public String getText()
    {
        String text = "Score: " + this.model.getScore()
                + " Enemies: " + this.model.getEnemies().size()
                + " Missiles: " + this.model.getMissiles().size()
                + " Time: " + this.model.getStopwatch() + " seconds"
                + " Angle: " + this.model.getCannon().getAngle()
                + " Speed: " + this.model.getCannon().getVelocity();

        if (this.model.isPause()) {
            text += "PAUSED";
        }
        if (!this.model.isRunGame()) {
            text += "<ENTER> FOR NEW GAME";
        }
        return text;
    }
}
