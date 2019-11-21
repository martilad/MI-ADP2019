package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class AimCannonDownCommand extends AbsGameCommand {

    public AimCannonDownCommand(IGameModel subject) {
        super(subject);
    }

    @Override
    public void execute() {
        model.aimCanonDown();
    }
}