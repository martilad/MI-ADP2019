package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Missile_A;
import cz.cvut.fit.miadp.mvcgame.strategy.RealisticMoveStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMoveStrategy;
import org.junit.Assert;
import org.junit.Test;

public class MovingStrategyTest {

    int pos = 10;
    double angle = 0;
    double vel = 10;

    @Test
    public void RealMoveTest() {
        AbsMissile mis = new Missile_A(pos, pos, angle, vel, new RealisticMoveStrategy());
        mis.move();
        Assert.assertEquals(10, mis.getX());
        Assert.assertEquals(10, mis.getY());
        mis.increaseTime();
        mis.move();
        Assert.assertEquals(10+(int)(MvcGameConfig.MOVE_STEP-0.001), mis.getX());
        Assert.assertEquals(10, mis.getY());
    }

    @Test
    public void SimpleMoveTest() {
        AbsMissile mis = new Missile_A(pos, pos, angle, vel, new SimpleMoveStrategy());
        mis.move();
        Assert.assertEquals(10, mis.getX());
        Assert.assertEquals(10, mis.getY());
        mis.increaseTime();
        mis.move();
        Assert.assertEquals(10+ MvcGameConfig.MOVE_STEP, mis.getX());
        Assert.assertEquals(10, mis.getY());
    }

}
