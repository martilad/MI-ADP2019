package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.TimeLifeAwareGameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsMissile extends TimeLifeAwareGameObject
{
    private double angle;
    private double velocity;
    private int initX;
    private int initY;


    public void accept(IVisitor visitor)
    {
        visitor.visitMissile(this);
    }

    public abstract void move();

    public AbsMissile(int x, int y, double angle, double velocity) {
        this.setX(x);
        this.setY(y);
        this.setInitX(x);
        this.setInitY(y);
        this.setAngle(angle);
        this.setVelocity(velocity);

    }

    public AbsMissile(AbsMissile missile) {
        this.setX(missile.getX());
        this.setY(missile.getY());
        this.setInitX(missile.getInitX());
        this.setInitY(missile.getInitY());
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

    public void setInitX(int initX) {
        this.initX = initX;
    }

    public void setInitY(int initY) {
        this.initY = initY;
    }

    public int getInitX() {
        return initX;
    }

    public int getInitY() {
        return initY;
    }

    public abstract AbsMissile clone();
}
