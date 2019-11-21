package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;

public class Collision_A extends AbsCollision {
    @Override
    public AbsCollision clone() {
        return new Collision_A();
    }
}
