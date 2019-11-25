package cz.cvut.fit.miadp;


import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Cannon_A;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MementoTest{
    @InjectMocks
    private GameModel model;

    @Test
    public void MockTest() {


        Object mem = model.createMemento();


        model.setMemento(mem);



        Assert.assertEquals(model.getScore(), 0);
        Assert.assertEquals(model.getCannon(), 0);

    }
}
