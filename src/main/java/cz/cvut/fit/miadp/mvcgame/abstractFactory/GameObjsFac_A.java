package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.*;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMoveStrategy;

public class GameObjsFac_A implements IGameObjsFac {

    private IMovingStrategy activeMovingStrategy = new SimpleMoveStrategy();

    //game model a nacita si z nej faktory nastavit

    @Override
    public AbsCannon createCannon() {
        return new Cannon_A();
    }

    @Override
    public AbsCollision createCollision() {
        return new Collision_A();
    }

    @Override
    public AbsEnemy createEnemy() {
        return new Enemy_A();
    }

    @Override
    public AbsMissile createMissile() {
        return new Missile_A(this.activeMovingStrategy);
    }

    @Override
    public AbsModelInfo createModelInfo() {
        return new ModelInfo_A();
    }

}
