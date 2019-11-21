package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;

public class Enemy_A extends AbsEnemy {

    public Enemy_A(int X, int Y, double velocity) {
        super(X, Y, velocity);
    }

    public Enemy_A(AbsEnemy enemy) {
        super(enemy);
    }

    @Override
    public void move() {

    }

    @Override
    public AbsEnemy clone() {
        return new Enemy_A(this);
    }
}
