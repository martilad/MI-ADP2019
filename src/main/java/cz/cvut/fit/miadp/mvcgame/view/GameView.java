package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView implements IObserver {
    private GameModel model;
    private GraphicsContext gr;
    private Image cvutLogoImage;
    private int updateCnt = 1;

    public GameView(GameModel model) {
        this.model = model;
        this.model.registerObserver(this);

        this.cvutLogoImage = new Image("icons/fit-icon-256x256.png");
    }

    public GameController makeController() {
        return new GameController(model);
    }

    public void setGraphicsContext(GraphicsContext gr){
        this.gr = gr;
        this.update();
    }

    public void render(){
        if (this.updateCnt > 0) {
            if (this.gr == null) return;
            Position logoPos = this.model.getLogoPosition();
            this.drawImage(logoPos, this.cvutLogoImage);

            this.updateCnt = 0;
        }
    }

    public void update(){
        this.updateCnt++;
    }

    private void drawImage(Position imgPos, Image img){
        gr.drawImage(img, imgPos.getX(), imgPos.getY());
    }
}
