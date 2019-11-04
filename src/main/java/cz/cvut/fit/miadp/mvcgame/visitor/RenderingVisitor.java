package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsModelInfo;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RenderingVisitor implements IVisitor {

    private Image cannonImg;
    private ImageView canon;
    private GraphicsContext gr;

    public RenderingVisitor(){
        this.cannonImg = new Image("images/cannon.png");
        this.canon = new ImageView(this.cannonImg);
    }

    public void setGraphics(GraphicsContext gr)
    {
        this.gr = gr;
    }

    @Override
    public void visitCannon(AbsCannon go) {
        // TODO Auto-generated method stub
        this.drawCannon(go);

    }

    private void drawCannon(AbsCannon go) {
        if(this.gr == null)  return;
        this.gr.clearRect(go.getX()-MvcGameConfig.MOVE_STEP, go.getY()-MvcGameConfig.MOVE_STEP, this.cannonImg.getWidth()+ MvcGameConfig.MOVE_STEP*2, this.cannonImg.getHeight()+MvcGameConfig.MOVE_STEP*2);
        this.gr.drawImage(this.cannonImg, go.getX(), go.getY());
    }

    @Override
    public void visitEnemy(AbsEnemy go) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitGameInfo(AbsModelInfo go) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitMissile(AbsMissile go) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitCollision(AbsCollision go) {
        // TODO Auto-generated method stub

    }

}