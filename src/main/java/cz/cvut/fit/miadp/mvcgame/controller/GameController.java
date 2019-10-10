package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;

public class GameController {

    private GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }

    public void handleKeyCode(String keyCode){
        switch(keyCode){
            case "UP":
                this.model.moveLogoUp();
                break;
            case "DOWN":
                this.model.moveLogoDown();
                break;
            case "LEFT":
                this.model.moveLogoLeft();
                break;
            case "RIGHT":
                this.model.moveLogoRight();
                break;
            default:
                //nothing
        }
    }

}
