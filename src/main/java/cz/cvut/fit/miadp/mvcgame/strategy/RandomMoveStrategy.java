package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

import java.util.Random;

public class RandomMoveStrategy implements IMovingStrategy {

    private Random rnd = new Random();

    @Override
    public void updatePosition(AbsMissile missile) {
        double angleRadians = Math.toRadians(missile.getAngle());
        int rngY = rnd.nextInt(MvcGameConfig.MOVE_STEP*30);
        missile.move((int)((missile.getVelocity()/5) * missile.getLifetime()/10 * Math.cos(angleRadians)),
                (rngY - MvcGameConfig.MOVE_STEP*30/2));
        //missile.move((int)((missile.getVelocity()) * missile.getLifetime() * Math.cos(angleRadians)),
         //       (int)((missile.getVelocity()) * missile.getLifetime() * Math.sin(angleRadians)));
    }
}
