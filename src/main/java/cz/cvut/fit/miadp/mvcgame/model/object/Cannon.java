package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;

public class Cannon extends GameObject {


    public Cannon(Position position) {
        super(position);
    }

    public void moveUp(){
        this.position.move(this.position.getX(), this.position.getY()-1);
    }

    public void moveDown(){
        this.position.move(this.position.getX(), this.position.getY()+1);
    }
}
