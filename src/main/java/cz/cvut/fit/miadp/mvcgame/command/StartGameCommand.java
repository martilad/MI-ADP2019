package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class StartGameCommand extends AbsGameCommand {

    public StartGameCommand(IGameModel model) {
        super(model);
    }

    @Override
    public void execute() {
        model.startGame();
    }
}
