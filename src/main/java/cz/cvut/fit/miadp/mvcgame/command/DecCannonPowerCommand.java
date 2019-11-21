package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class DecCannonPowerCommand extends AbsGameCommand {

    public DecCannonPowerCommand(IGameModel model) {
        super(model);
    }

    @Override
    public void execute() {
        model.decCannonPower();
    }
}
