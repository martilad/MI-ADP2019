package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.TimeLifeAwareGameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class AbsCollision extends TimeLifeAwareGameObject {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visitCollision(this);
    }
}
