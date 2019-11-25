package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.state.NShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CannonTest {

    @InjectMocks
    private GameModel model;

    @Test
    public void aimUpTest() {
        AbsCannon c = model.getCannon();
        c.aimUp();
        Assert.assertEquals(MvcGameConfig.CANNON_INIT_ANGLE + MvcGameConfig.ANGLE_STEP, c.getAngle(), 0.00001);
        c.aimDown();
        Assert.assertEquals(MvcGameConfig.CANNON_INIT_ANGLE, c.getAngle(), 0.00001);
    }

    public void maxAimTest(){
        AbsCannon c = model.getCannon();
        for (int i=0;i<100;i++)
            c.aimUp();
        Assert.assertEquals(90, c.getAngle(), 0.00001);
    }

    @Test
    public void shootTest() {
        AbsCannon c = model.getCannon();
        Assert.assertTrue(c.shoot().size() > 0);
    }

    @Test
    public void incPowerTest() {
        AbsCannon c = model.getCannon();
        c.incPower();
        Assert.assertEquals(MvcGameConfig.CANNON_INIT_VELOCITY + MvcGameConfig.VELOCITY_STEP, c.getVelocity(), 0.00001);
        c.decPower();
        Assert.assertEquals(MvcGameConfig.CANNON_INIT_VELOCITY, c.getVelocity(), 0.00001);
    }

    @Test
    public void changeModeTest() {
        AbsCannon c = model.getCannon();
        Assert.assertTrue(c.getShootingMode() instanceof SingleShootingMode);
        c.toggleShootingMode();
        Assert.assertTrue(c.getShootingMode() instanceof NShootingMode);
        c.toggleShootingMode();
        Assert.assertTrue(c.getShootingMode() instanceof SingleShootingMode);

    }

    @Test
    public void cannonMoveUpTest() {
        GameController controller = new GameController();
        IGameModel model = new GameModel();
        controller.setGameModel(model);

        controller.handleKeyCode("Enter");
        controller.handleKeyCode("Up");
        model.timeTick();
        Assert.assertEquals(MvcGameConfig.CANON_INIT_Y - MvcGameConfig.MOVE_STEP, model.getCannon().getY());
    }
}
