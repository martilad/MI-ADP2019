package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class UndoLastCommand extends AbsGameCommand {

    public UndoLastCommand(IGameModel model) {
        super(model);
    }

    @Override
    public void execute() {
        model.undoLastCommand();
    }
}