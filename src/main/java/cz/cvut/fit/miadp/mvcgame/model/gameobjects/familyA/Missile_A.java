package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public class Missile_A extends AbsMissile {

    private IMovingStrategy moveStrat;

    public Missile_A(int x, int y, double angle, double velocity, IMovingStrategy myMoveStrat){
        super(x, y, angle, velocity);
        this.moveStrat = myMoveStrat;
    }

    public Missile_A(Missile_A missile){
        super(missile);
        this.moveStrat = missile.getStrategy();
    }


    public IMovingStrategy getStrategy() {
        return this.moveStrat;
    }


    public void move(){
        this.moveStrat.updatePosition(this);
    }

    @Override
    public AbsMissile clone() {
        return new Missile_A(this);
    }

}
