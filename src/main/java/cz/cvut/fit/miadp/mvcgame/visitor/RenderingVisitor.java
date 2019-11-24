package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsModelInfo;

import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;


public class RenderingVisitor implements IVisitor {

    private IGameGraphics gr;

    public RenderingVisitor(){
    }

    public void setGraphics(IGameGraphics gr)
    {
        this.gr = gr;
    }

    @Override
    public void visitCannon(AbsCannon go) {
        if(this.gr == null)  return;
        this.gr.drawImage("images/cannon.png", new Position(go.getX(), go.getY()));
    }


    @Override
    public void visitEnemy(AbsEnemy go) {
        if(this.gr == null)  return;
        this.gr.drawImage("images/enemy1.png", new Position(go.getX(), go.getY()));

    }

    @Override
    public void visitGameInfo(AbsModelInfo go) {
        this.gr.drawText(go.getText(), new Position(go.getX(), go.getY()));
    }

    @Override
    public void visitMissile(AbsMissile go) {
        if(this.gr == null)  return;
        this.gr.drawImage("images/missile.png", new Position(go.getX(), go.getY()));
    }

    @Override
    public void visitCollision(AbsCollision go) {
        if(this.gr == null)  return;
        this.gr.drawImage("images/collision.png", new Position(go.getX(), go.getY()));
    }

}