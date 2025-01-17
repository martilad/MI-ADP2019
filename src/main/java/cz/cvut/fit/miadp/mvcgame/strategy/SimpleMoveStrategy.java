package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;


public class SimpleMoveStrategy implements IMovingStrategy {

    @Override
    public void updatePosition(AbsMissile missile) {
        double angleRadians = Math.toRadians(missile.getAngle());
        missile.move((int)((missile.getVelocity()) * missile.getLifetime() * Math.cos(angleRadians)),
                (int)((missile.getVelocity()) * missile.getLifetime() * Math.sin(angleRadians)));
    }
}
