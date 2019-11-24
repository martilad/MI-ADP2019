package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsEnemy extends GameObject {
    private double velocity;
    public void accept(IVisitor visitor)
    {
        visitor.visitEnemy(this);
    }

    public double getVelocity(){
        return this.velocity;
    }

    public void setVelocity(double velocity){
        this.velocity = velocity;
    }

    public AbsEnemy(int X, int Y, double velocity){
        this.setX(X);
        this.setY(Y);
        this.velocity = velocity;
    }
    public AbsEnemy(AbsEnemy enemy) {
        this.velocity = enemy.getVelocity();
        this.setX(enemy.getX());
        this.setY(enemy.getY());
    }

    public abstract void move();

    public abstract AbsEnemy clone();
}
