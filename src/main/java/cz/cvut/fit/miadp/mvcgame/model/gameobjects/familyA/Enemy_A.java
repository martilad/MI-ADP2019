package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;

import java.util.Random;

public class Enemy_A extends AbsEnemy {
    private Random rnd = new Random();
    public Enemy_A(int X, int Y, double velocity) {
        super(X, Y, velocity);
    }

    public Enemy_A(AbsEnemy enemy) {
        super(enemy);
    }

    @Override
    public void move() {
        int dirX = rnd.nextBoolean() ? 1 : -1;
        int dirY = rnd.nextBoolean() ? 1 : -1;

        int nx = (int) (this.getX() + dirX * this.getVelocity());
        int ny = (int) (this.getY() + dirY * this.getVelocity());

        if (nx < (MvcGameConfig.MAX_X / 3)) nx = (MvcGameConfig.MAX_X / 3);
        if (nx > MvcGameConfig.MAX_X) nx = MvcGameConfig.MAX_X;
        if (ny < 0) ny = 0;
        if (ny > MvcGameConfig.MAX_Y) ny = MvcGameConfig.MAX_Y;

        this.setX(nx);
        this.setY(ny);
    }

    @Override
    public AbsEnemy clone() {
        return new Enemy_A(this);
    }
}
