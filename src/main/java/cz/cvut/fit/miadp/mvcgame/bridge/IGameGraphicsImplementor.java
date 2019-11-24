package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;

public interface IGameGraphicsImplementor {

    void drawImage(String path, Position pos);
    void drawText(String text, Position pos);
    void drawLine(Position begin, Position end);
    void clear();


}
