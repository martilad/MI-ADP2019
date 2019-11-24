package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;

public class GameGraphics implements IGameGraphics {

    private IGameGraphicsImplementor implementor;


    public GameGraphics(IGameGraphicsImplementor implementor) {
        this.implementor = implementor;
    }

    @Override
    public void drawImage(String path, Position pos) {
        this.implementor.drawImage(path, pos);
    }

    @Override
    public void drawText(String text, Position pos) {
        this.implementor.drawText(text, pos);
    }

    @Override
    public void drawRectangle(Position leftTop, Position rightBottom) {
        this.implementor.drawLine(leftTop, new Position(leftTop.getX(), rightBottom.getY()));
        this.implementor.drawLine(new Position(leftTop.getX(), rightBottom.getY()), rightBottom);
        this.implementor.drawLine(new Position(rightBottom.getX(), leftTop.getY()), rightBottom);
        this.implementor.drawLine(leftTop, new Position(rightBottom.getX(), leftTop.getY()));
    }

    @Override
    public void clear() {
        this.implementor.clear();
    }
}
