package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class CannonShootCommand extends AbsGameCommand {

    public CannonShootCommand(IGameModel model) {
        super(model);
    }

    @Override
    public void execute() {
        model.cannonShoot();
    }
}