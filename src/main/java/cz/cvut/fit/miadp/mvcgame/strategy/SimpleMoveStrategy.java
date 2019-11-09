package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;

import java.util.Random;

public class SimpleMoveStrategy implements IMovingStrategy {


    @Override
    public void updatePosition(AbsMissile absMissile) {
        absMissile.move(new Random().nextInt(5)-2, new Random().nextInt(5)-2);
    }


}
