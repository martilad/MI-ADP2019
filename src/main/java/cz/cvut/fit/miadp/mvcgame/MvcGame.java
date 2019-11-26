package cz.cvut.fit.miadp.mvcgame;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.proxy.GameModelProxy;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.view.GameView;

public class MvcGame
{
    private GameModelProxy proxyModel;
    private GameController controller;
    private GameView view;

    public void init(){
        IGameModel model = new GameModel();
        this.proxyModel = new GameModelProxy(model);
        this.view = new GameView(this.proxyModel);
        this.controller = this.view.makeController();
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        for(String code : pressedKeysCodes) this.controller.handleKeyCode(code);
    }

    public void update() {
        this.proxyModel.timeTick();
    }

    public void render(IGameGraphics gr) {
        this.view.setGraphics(gr);
        this.view.render();
    }

    public String getWindowTitle() {
        return "The MI-ADP.16 MvcGame - martilad (martilad@it.cvut.cz)";
    }

    public int getWindowWidth() {
        return MvcGameConfig.MAX_X;
    }

    public int getWindowHeight() {
        return  MvcGameConfig.MAX_Y;
    }
}