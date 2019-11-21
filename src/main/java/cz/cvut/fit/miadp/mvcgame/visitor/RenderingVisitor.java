package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsModelInfo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class RenderingVisitor implements IVisitor {

    private Image cannonImg;
    private Image missileImg;
    private Image enemy1Img;
    private Image enemy2Img;
    private Image collisionImg;

    private GraphicsContext gr;

    public RenderingVisitor(){
        this.cannonImg = new Image("images/cannon.png");
        this.missileImg = new Image("images/missile.png");
        this.enemy1Img = new Image("images/enemy1.png");
        this.enemy2Img = new Image("images/enemy2.png");
        this.collisionImg = new Image("images/collision.png");
    }

    public void setGraphics(GraphicsContext gr)
    {
        this.gr = gr;
    }

    @Override
    public void visitCannon(AbsCannon go) {
        if(this.gr == null)  return;
        this.gr.drawImage(this.cannonImg,
                go.getX() - this.cannonImg.getWidth()/2,
                go.getY() - this.cannonImg.getHeight()/2);
    }


    @Override
    public void visitEnemy(AbsEnemy go) {
        if(this.gr == null)  return;
        this.gr.drawImage(this.enemy1Img,
                go.getX() - this.enemy1Img.getWidth()/2,
                go.getY() - this.enemy2Img.getHeight()/2);

    }

    @Override
    public void visitGameInfo(AbsModelInfo go) {
        this.gr.strokeText(go.getText(), go.getX(), go.getY());
    }

    @Override
    public void visitMissile(AbsMissile go) {
        if(this.gr == null)  return;
        this.gr.drawImage(this.missileImg,
                go.getX() - this.missileImg.getWidth()/2,
                go.getY() - this.missileImg.getHeight()/2);
    }

    @Override
    public void visitCollision(AbsCollision go) {
        if(this.gr == null)  return;
        this.gr.drawImage(this.collisionImg,
                go.getX() - this.collisionImg.getWidth()/2,
                go.getY() - this.collisionImg.getHeight()/2);

    }

}