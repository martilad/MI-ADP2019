package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class GameObject {

    private Position position = new Position(0,0);

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


    public boolean collidesWith(GameObject other) {
        return (Math.abs(this.getX() - other.getX())) < MvcGameConfig.COLLISION_NEIGHBORHOOD
                && (Math.abs(this.getY() - other.getY())) < MvcGameConfig.COLLISION_NEIGHBORHOOD;
    }

    public abstract void accept(IVisitor visitor);
}
