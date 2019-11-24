package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class PauseResumeGameCommand extends AbsGameCommand {

    public PauseResumeGameCommand(IGameModel model) {
        super(model);
    }

    @Override
    public void execute() {
        model.pauseEndGame();
    }
}
