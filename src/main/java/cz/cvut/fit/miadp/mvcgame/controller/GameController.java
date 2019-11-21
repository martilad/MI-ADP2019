package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.command.*;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class GameController {

    private IGameModel model;

    public GameController() { }

    public void setGameModel(IGameModel model) {
        this.model = model;
    }


    public void handleKeyCode(String keyCode){
        if (this.model == null) return;
        switch(keyCode){
            case "UP":
                this.model.registerCommand(new MoveUpCommand(this.model));
                break;
            case "DOWN":
                this.model.registerCommand(new MoveDownCommand(this.model));
                break;
            case "SPACE":
                this.model.registerCommand(new CannonShootCommand(this.model));
                break;
            case "M":
                this.model.registerCommand(new ToggleModeCommand(this.model));
                break;
            case "N":
                this.model.registerCommand(new SwitchStrategyCommand(this.model));
                break;
            default:
                System.out.println(keyCode);
        }
    }

}
