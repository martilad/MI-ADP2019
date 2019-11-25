package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.GameObjsFac_A;
import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjsFac;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Cannon_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Enemy_A;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMoveStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class ObjectFactoryTest {

    private IGameObjsFac factory;
    private GameModel model;

    @Before
    public void initFactory() {
        model = new GameModel();
        this.factory = new GameObjsFac_A(model);
    }

    @Test
    public void createCollisionTest() {
        int cannonPos = 10;
        double cannonVel = 10.;
        double cannonAn = 0;

        int enemyX = 30;
        int enemyY = 10;

        AbsCannon cannon = mock(Cannon_A.class);
        when(cannon.getX()).thenReturn(cannonPos);
        when(cannon.getY()).thenReturn(cannonPos);
        when(cannon.getAngle()).thenReturn(cannonAn);
        when(cannon.getVelocity()).thenReturn(cannonVel);
        this.model.startGame();
        model.setCannon(cannon);

        ArrayList<AbsMissile> mis = new ArrayList<>();
        mis.add(this.factory.createMissile());
        when(cannon.shoot()).thenReturn(mis);

        AbsEnemy enemy = mock(Enemy_A.class);
        when(enemy.getX()).thenReturn(enemyX);
        when(enemy.getY()).thenReturn(enemyY);

        model.addNewEnemy(enemy);

        while (!(model.getActiveMovingStrategy() instanceof SimpleMoveStrategy)) {
            model.switchMovingStrategy();
        }
        model.cannonShoot();
        Assert.assertEquals(model.getMissiles().get(0).getX(), cannonPos);
        Assert.assertEquals(model.getMissiles().get(0).getY(), cannonPos);
        Assert.assertEquals(model.getMissiles().get(0).getAngle(), cannonAn, 0.001);
        Assert.assertEquals(model.getMissiles().get(0).getVelocity(), cannonVel, 0.001);
        Assert.assertEquals(model.getEnemies().size(), MvcGameConfig.ENEMIES_CNT + 1);
        Assert.assertEquals(model.getMissiles().size(), 1);
        model.timeTick();
        model.timeTick();
        Assert.assertEquals(model.getEnemies().size(), MvcGameConfig.ENEMIES_CNT);
        Assert.assertEquals(model.getMissiles().size(), 0);
    }

    @Test
    public void createMissileTest() {
        int pos = 100;
        double valgun = 100f;
        AbsCannon cannon = mock(Cannon_A.class);
        when(cannon.getX()).thenReturn(pos);
        when(cannon.getY()).thenReturn(pos);
        when(cannon.getAngle()).thenReturn(valgun);
        when(cannon.getVelocity()).thenReturn(valgun);

        model.setCannon(cannon);
        AbsMissile mis = this.factory.createMissile();

        Assert.assertEquals(pos, mis.getX());
        Assert.assertEquals(pos, mis.getY());
        Assert.assertEquals(valgun, mis.getAngle(), 0.0001);
        Assert.assertEquals(valgun, mis.getVelocity(), 0.0001);
    }
}
