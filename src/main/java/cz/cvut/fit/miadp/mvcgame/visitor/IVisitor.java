package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;
import javafx.scene.canvas.GraphicsContext;

public interface IVisitor
{
    void visitCannon(AbsCannon go);
    void visitEnemy(AbsEnemy go);
    void visitGameInfo(AbsModelInfo go);
    void visitMissile(AbsMissile go);
    void visitCollision(AbsCollision go);

    void setGraphics(GraphicsContext gr);
}