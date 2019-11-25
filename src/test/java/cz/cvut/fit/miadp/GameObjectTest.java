package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Enemy_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Missile_A;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMoveStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameObjectTest {

    @Test
    public void positionTest() {
        AbsEnemy e = new Enemy_A(0,0,0);
        e.setX(100);
        e.setY(100);
        Assert.assertEquals(e.getX(), 100);
        Assert.assertEquals(e.getY(), 100);
    }

    @Test
    public void collidesWithTest() {
        AbsMissile m = new Missile_A(100, 100, 0, 0, new SimpleMoveStrategy());
        AbsEnemy e = new Enemy_A(0,0,0);
        e.setX(100 + MvcGameConfig.COLLISION_NEIGHBORHOOD-1);
        e.setY(100 + MvcGameConfig.COLLISION_NEIGHBORHOOD-1);
        Assert.assertTrue(m.collidesWith(e));
        e.setX(0);
        e.setY(0);
        Assert.assertFalse(m.collidesWith(e));
    }

}
