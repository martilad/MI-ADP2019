package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;


public abstract class AbsCannon extends GameObject {

    public abstract Float getVelocity();
    public abstract Float getAngle();

    public abstract void setVelocity(Float velocity);
    public abstract void setAngle(Float angle);

    public abstract void aimUp();
    public abstract void aimDown();


    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();

    public abstract void incPower();
    public abstract void decPower();

    public void accept(IVisitor visitor)
    {
        visitor.visitCannon(this);
    }


}
