package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public class Cannon_A extends AbsCannon
{
    public Cannon_A()
    {
        this.setX(MvcGameConfig.CANON_POS_X);
        this.setY(MvcGameConfig.CANON_POS_Y);
        //this.setX((int)(MvcGameConfig.CANON_POS_Y / 2));
    }

    public Float getVelocity()
    {
        return null;
    }

    public Float getAngle()
    {
        return null;
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
    public AbsMissile shoot() {
        AbsMissile mis = this.goFact.createMissile();
        mis.setX(this.getX());
        mis.setY(this.getY());
        return mis;
    }

    @Override
    public void setDoubleShootingMode() {

    }

    @Override
    public AbsMissile primitiveShoot() {
        return null;
    }

    @Override
    public void moveUp() {
        this.move(0, -1* MvcGameConfig.MOVE_STEP);

    }

    @Override
    public void moveDown() {
        this.move(0, MvcGameConfig.MOVE_STEP);

    }

    @Override
    public void moveLeft() {
        this.move(-1* MvcGameConfig.MOVE_STEP, 0);

    }

    @Override
    public void moveRight() {
        this.move(MvcGameConfig.MOVE_STEP, 0);

    }

}
