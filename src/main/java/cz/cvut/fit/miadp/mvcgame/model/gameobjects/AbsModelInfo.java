package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsModelInfo extends GameObject {

    public IGameModel model;
    public AbsModelInfo(IGameModel model){
        this.model = model;
    }
    public abstract String getText();

    public void accept(IVisitor visitor)
    {
        visitor.visitGameInfo(this);
    }

}
