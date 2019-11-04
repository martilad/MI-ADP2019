package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;

public abstract class LifeTimeLimitedGameObject extends GameObject {

    private long bornAt;

    public LifeTimeLimitedGameObject(Position position) {
        super(position);
        bornAt = System.currentTimeMillis();
    }

    public long getAge(){
        return System.currentTimeMillis()-bornAt;
    }
}
