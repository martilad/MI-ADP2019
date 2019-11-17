package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjsFac;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.NShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;

import java.util.ArrayList;
import java.util.List;

public class Cannon_A extends AbsCannon
{
    private static final IShootingMode singleShootingMode = new SingleShootingMode();
    private static final IShootingMode doubleShootingMode = new NShootingMode();
    private List<AbsMissile> shootBatch;

    public Cannon_A(IGameObjsFac goFactory)
    {
        super(goFactory);
        this.shootingMode = singleShootingMode;
        this.setX(MvcGameConfig.CANON_INIT_X);
        this.setY(MvcGameConfig.CANON_INIT_Y);
    }

    public Double getVelocity()
    {
        return null;
    }

    public Double getAngle()
    {
        return null;
    }

    @Override
    public void setVelocity(Double velocity) {

    }

    @Override
    public void setAngle(Double angle) {

    }


    public void setVelocity(Float velocity)
    {

    }

    public void setAngle(Float angle)
    {

    }

    public void aimUp()
    {

    }

    public void aimDown()
    {

    }

    public void incPower()
    {

    }

    public void decPower()
    {

    }

    @Override
    public List<AbsMissile> shoot() {
        this.shootBatch = new ArrayList<>();

        this.shootingMode.shoot(this);

        return this.shootBatch;
    }

    public void setNShootingMode() {
        shootingMode = doubleShootingMode;
    }

    public void setSingleShootingMode() {
        shootingMode = singleShootingMode;
    }

    @Override
    public void primitiveShoot() {
        this.shootBatch.add(this.goFactory.createMissile());
    }

    @Override
    public void moveUp() {
        this.move(0, -1* MvcGameConfig.MOVE_STEP);

    }

    @Override
    public void moveDown() {
        this.move(0, MvcGameConfig.MOVE_STEP);

    }

}
