package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsModelInfo;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class ModelInfo_A extends AbsModelInfo {
    public ModelInfo_A(IGameModel model) {
        super(model);
        this.setX(MvcGameConfig.INFO_X);
        this.setY(MvcGameConfig.INFO_Y);
    }

    public String getText() {
        String text = "Score: " + this.model.getScore()
                + " Enemies: " + this.model.getEnemies().size()
                + " Missiles: " + this.model.getMissiles().size()
                + " Time: " + (System.currentTimeMillis()-this.model.getStopwatch())/1000 + " seconds"
                + " Angle: " + this.model.getCannon().getAngle()
                + " Speed: " +(double)Math.round(this.model.getCannon().getVelocity() * 1000d) / 1000d
                + " Level: " + model.getLevel();

        if (this.model.isPause()) {
            text += "          PAUSED";
        }
        if (!this.model.isRunGame()) {
            text += "          PRESS ENTER FOR START";
        }
        return text;
    }
}
