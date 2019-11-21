package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class MoveDownCommand extends AbsGameCommand {

    public MoveDownCommand(IGameModel model) {
        super(model);
    }

    @Override
    public void execute() {
        model.moveCannonDown();
    }
}
