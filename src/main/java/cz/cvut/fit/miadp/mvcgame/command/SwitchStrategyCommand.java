package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class SwitchStrategyCommand extends AbsGameCommand {

    public SwitchStrategyCommand(IGameModel model) {
        super(model);
    }

    @Override
    public void execute() {
        model.switchMovingStrategy();
    }
}
