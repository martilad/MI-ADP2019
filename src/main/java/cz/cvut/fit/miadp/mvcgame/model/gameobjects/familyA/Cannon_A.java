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
    private List<AbsMissile> shootBag;
    private double velocity;
    private double angle;

    public Cannon_A(IGameObjsFac goFactory) {
        super(goFactory);
        this.shootingMode = singleShootingMode;
        this.setX(MvcGameConfig.CANON_INIT_X);
        this.setY(MvcGameConfig.CANON_INIT_Y);
        this.velocity = MvcGameConfig.CANNON_INIT_VELOCITY;
        System.out.println("velocituy+" + this.velocity);
        this.angle = MvcGameConfig.CANnON_INIT_ANGLE;
    }

    public Cannon_A(AbsCannon c) {
        super(c);
        this.setX(c.getX());
        this.setY(c.getY());
        this.velocity = c.getVelocity();
        this.angle = c.getAngle();
    }

    @Override
    public Double getVelocity() {
       return this.velocity;
    }

    @Override
    public Double getAngle()
    {
        return this.angle;
    }

    @Override
    public void setAngle(Double angle) {
        this.angle = angle;
    }

    @Override
    public void setVelocity(Double velocity) {
        this.velocity = velocity;
    }

    @Override
    public void aimUp() {
        if (this.angle + MvcGameConfig.ANGLE_STEP > 90.0f) return;
        this.angle += MvcGameConfig.ANGLE_STEP;
    }

    @Override
    public void aimDown() {
        if (this.angle - MvcGameConfig.ANGLE_STEP < -90.0f) return;
        this.angle -= MvcGameConfig.ANGLE_STEP;
    }

    @Override
    public void incPower() {
        this.velocity += MvcGameConfig.VELOCITY_STEP;
    }

    @Override
    public void decPower() {
        if (this.velocity - MvcGameConfig.VELOCITY_STEP < 0) return;
        this.velocity -= MvcGameConfig.VELOCITY_STEP;
    }

    @Override
    public List<AbsMissile> shoot() {
        this.shootBag = new ArrayList<>();

        this.shootingMode.shoot(this);

        return this.shootBag;
    }

    @Override
    public void setNShootingMode() {
        shootingMode = doubleShootingMode;
    }

    @Override
    public void setSingleShootingMode() {
        shootingMode = singleShootingMode;
    }

    @Override
    public void primitiveShoot() {
        this.shootBag.add(this.goFactory.createMissile());
    }

    @Override
    public AbsCannon clone() {
        return new Cannon_A(this);
    }

    @Override
    public void moveUp() {
        if (this.getY() - MvcGameConfig.MOVE_STEP <= 0) return;
        this.move(0, -1* MvcGameConfig.MOVE_STEP);
    }

    @Override
    public void moveDown() {
        if (this.getY() + MvcGameConfig.MOVE_STEP >= MvcGameConfig.MAX_Y) return;
        this.move(0, MvcGameConfig.MOVE_STEP);
    }
}
