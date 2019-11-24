package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.command.*;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class GameController {

    private IGameModel model;

    public GameController() {}

    public void setGameModel(IGameModel model) {
        this.model = model;
    }


    public void handleKeyCode(String keyCode){
        if (this.model == null) return;
        switch(keyCode){
            case "Up":
                this.model.registerCommand(new MoveUpCommand(this.model));
                break;
            case "Down":
            case "S":
                this.model.registerCommand(new MoveDownCommand(this.model));
                break;
            case "W":
                this.model.registerCommand(new MoveUpCommand(this.model));
                break;
            case "A":
            case "Left":
                this.model.registerCommand(new AimCannonUpCommand(this.model));
                break;
            case "D":
            case "Right":
                this.model.registerCommand(new AimCannonDownCommand(this.model));
                break;
            case "M":
            case "Q":
                this.model.registerCommand(new ToggleModeCommand(this.model));
                break;
            case "N":
            case "E":
                this.model.registerCommand(new SwitchStrategyCommand(this.model));
                break;
            case "Enter":
                this.model.registerCommand(new StartGameCommand(this.model));
                break;
            case "Esc":
                this.model.registerCommand(new PauseResumeGameCommand(this.model));
                break;
            case "Space":
                this.model.registerCommand(new CannonShootCommand(this.model));
                break;
            case "Minus":
            case "Subtract":
                this.model.registerCommand(new DecCannonPowerCommand(this.model));
                break;
            case "Equals":
            case "Add":
                this.model.registerCommand(new IncCannonPowerCommand(this.model));
                break;
            case "Ctrl+Z":
                this.model.undoLastCommand();
                break;
            default:
                System.out.println(keyCode);
        }
    }

}
