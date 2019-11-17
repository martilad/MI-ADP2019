package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public class Missile_A extends AbsMissile {

    private IMovingStrategy moveStrat;

    public Missile_A(int x, int y, IMovingStrategy myMoveStrat){
        this.moveStrat = myMoveStrat;
        this.setX(x);
        this.setY(y);
    }

    public void move(){
        this.moveStrat.updatePosition(this);
    }

}
