package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjsFac;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

import java.util.List;


public abstract class AbsCannon extends GameObject {

    protected IShootingMode shootingMode;
    protected IGameObjsFac goFactory;

    public AbsCannon(IGameObjsFac goFactory){
        this.goFactory = goFactory;
    }

    public abstract Double getVelocity();
    public abstract Double getAngle();

    public abstract void setVelocity(Double velocity);
    public abstract void setAngle(Double angle);

    public abstract void aimUp();
    public abstract void aimDown();


    public abstract void moveUp();
    public abstract void moveDown();

    public abstract void incPower();
    public abstract void decPower();

    public void accept(IVisitor visitor)
    {
        visitor.visitCannon(this);
    }

    public void toggleShootingMode() {
        this.shootingMode.toggle(this);
    }

    public abstract List<AbsMissile> shoot();

    public abstract void setNShootingMode();
    public abstract void setSingleShootingMode();

    public abstract void primitiveShoot();
}
