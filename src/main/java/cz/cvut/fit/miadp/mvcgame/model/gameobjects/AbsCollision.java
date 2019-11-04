package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class AbsCollision extends GameObject {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visitCollision(this);
    }
}
