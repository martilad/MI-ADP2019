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
                this.model.moveCannonUp();
                break;
            case "DOWN":
                this.model.moveCannonDown();
                break;
            case "LEFT":
                this.model.moveCannonLeft();
                break;
            case "RIGHT":
                this.model.moveCannonRight();
                break;
            case "SPACE":
                this.model.cannonShoot();
                break;
            case "M":
                this.model.cannonShoot();
                this.model.cannonShoot();
                break;
            default:
                //nothing
        }
    }

}
