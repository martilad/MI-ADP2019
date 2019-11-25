package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.TimeLifeAwareGameObject;
import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

import javax.sound.midi.SysexMessage;

public abstract class AbsMissile extends TimeLifeAwareGameObject
{
    private double angle;
    private double velocity;


    public void accept(IVisitor visitor)
    {
        visitor.visitMissile(this);
    }

    public abstract void move();

    public AbsMissile(int x, int y, double angle, double velocity) {
        this.setX(x);
        this.setY(y);
        this.setAngle(angle);
        this.setVelocity(velocity);
    }

    public AbsMissile(AbsMissile missile) {
        this.setX(missile.getX());
        this.setY(missile.getY());
        this.setAngle(missile.getAngle());
        this.setVelocity(missile.getVelocity());
    }

    public double getAngle(){
        return this.angle;
    }

    public double getVelocity(){
        return this.velocity;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public abstract AbsMissile clone();
}
