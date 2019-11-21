package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class ToggleModeCommand extends AbsGameCommand {

    public ToggleModeCommand(IGameModel model) {
        super(model);
    }

    @Override
    public void execute() {
        model.cannonToggleMode();
    }
}

