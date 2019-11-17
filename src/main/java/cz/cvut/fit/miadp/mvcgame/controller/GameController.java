package cz.cvut.fit.miadp.mvcgame.controller;

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
                this.model.moveCannonUp();
                break;
            case "DOWN":
                this.model.moveCannonDown();
                break;
            case "SPACE":
                this.model.cannonShoot();
                break;
            case "M":
                this.model.cannonToggleMode();
                break;
            default:
                System.out.println(keyCode);
        }
    }

}
