package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;

public abstract class GameObject {

    protected Position position;

    public GameObject(Position position) {
        this.position = position;
    }

    public void move(int x, int y){
        this.position.move(x, y);
    }
}
