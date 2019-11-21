package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class IncCannonPowerCommand extends AbsGameCommand {

    public IncCannonPowerCommand(IGameModel model) {
        super(model);
    }

    @Override
    public void execute() {
        model.incCanonPower();
    }
}
