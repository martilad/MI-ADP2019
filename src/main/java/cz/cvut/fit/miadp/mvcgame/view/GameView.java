package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;
import cz.cvut.fit.miadp.mvcgame.visitor.RenderingVisitor;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView implements IObserver {
    private GameModel model;
    private IVisitor renderingVisitor;
    private int updateCnt = 1;

    public GameView(GameModel model) {
        this.model = model;

        this.model.registerObserver(this);

        this.renderingVisitor = new RenderingVisitor();
    }

    public void setGraphics(GraphicsContext gr)
    {
        this.renderingVisitor.setGraphics(gr);
    }

    public GameController makeController() {
        return new GameController(model);
    }

    public void update() {
        this.updateCnt++;
    }

    public void render() {
        if(this.updateCnt > 0)
        {

            for(GameObject go : this.model.getGameObjects())
            {
                go.accept(this.renderingVisitor);
            }

            this.updateCnt = 0;
        }
    }


}