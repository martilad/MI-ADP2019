package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public abstract class AbsGameCommand {
    protected IGameModel model;
    private Object memento;

    public AbsGameCommand(IGameModel model) {
        this.model = model;
    }


    public void doExecute() {
        this.memento = this.model.createMemento();

        this.execute();
    }

    public abstract void execute();


    public void unExecute() {
        this.model.setMemento(this.memento);
    }
}
