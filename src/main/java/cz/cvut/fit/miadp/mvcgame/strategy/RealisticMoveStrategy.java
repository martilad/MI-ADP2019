package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public class RealisticMoveStrategy implements IMovingStrategy {

    @Override
    public void updatePosition(AbsMissile missile) {
        double angleRadians = Math.toRadians(missile.getAngle());
        missile.move((int) ((((missile.getVelocity()) * missile.getLifetime() * Math.cos(angleRadians)) - MvcGameConfig.BALISTIC_COEFFICIENT * (missile.getLifetime() * missile.getLifetime()))),
                     (int) ((((missile.getVelocity()) * missile.getLifetime() * Math.sin(angleRadians)) + MvcGameConfig.BALISTIC_COEFFICIENT * (missile.getLifetime() * missile.getLifetime()))));
    }
}