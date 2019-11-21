package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class AimCannonUpCommand extends AbsGameCommand {

    public AimCannonUpCommand(IGameModel subject) {
        super(subject);
    }

    @Override
    public void execute() {
        model.aimCanonUp();
    }
}
