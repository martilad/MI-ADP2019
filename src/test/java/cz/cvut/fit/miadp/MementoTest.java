package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MementoTest{

    @Test
    public void MockTest() {

        GameModel model = new GameModel();
        model.startGame();
        AbsCannon cannon = model.getCannon().clone();
        List<AbsMissile> mis = new ArrayList<>(model.getMissiles());

        int sc = model.getScore();
        int l = model.getLevel();
        long s = model.getStopwatch();
        Object mem = model.createMemento();

        model.cannonShoot();
        model.moveCannonDown();
        model.moveCannonDown();
        model.moveCannonDown();
        model.timeTick();
        Assert.assertEquals(model.getCannon().getX(), cannon.getX());
        Assert.assertFalse(model.getCannon().getY()==cannon.getX());
        Assert.assertFalse(model.getMissiles().size()==mis.size());
        Assert.assertEquals(model.getStopwatch(), s);
        model.setMemento(mem);
        Assert.assertEquals(model.getCannon().getX(), cannon.getX());
        Assert.assertEquals(model.getCannon().getY(), cannon.getY());
        Assert.assertEquals(model.getMissiles().size(), mis.size());
        Assert.assertEquals(model.getStopwatch(), s);
        Assert.assertEquals(model.getScore(), sc);
        Assert.assertEquals(model.getLevel(), l);

    }
}
