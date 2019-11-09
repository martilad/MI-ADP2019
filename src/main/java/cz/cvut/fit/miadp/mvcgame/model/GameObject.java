package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.GameObjsFac_A;
import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjsFac;
import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class GameObject {

    protected Position position = new Position(0,0);
    protected IGameObjsFac goFact = new GameObjsFac_A();

    public void move(int dx, int dy)
    {
        this.position.move(dx,dy);
    }

    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public abstract void accept(IVisitor visitor);
}
