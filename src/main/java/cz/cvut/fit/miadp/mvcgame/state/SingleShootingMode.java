package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public class SingleShootingMode implements IShootingMode{



    @Override
    public void shoot(AbsCannon cannon) {
        cannon.primitiveShoot();
    }

    @Override
    public void toggle(AbsCannon cannon) {
        cannon.setDoubleShootingMode();
    }
}
