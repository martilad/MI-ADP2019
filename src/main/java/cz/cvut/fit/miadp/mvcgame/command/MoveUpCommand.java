package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class MoveUpCommand extends AbsGameCommand {

    public MoveUpCommand(IGameModel model) {
        super(model);
    }

    @Override
    public void execute() {
        model.moveCannonUp();
    }
}