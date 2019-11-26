package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class JavaFxGraphics implements IGameGraphicsImplementor{

    private GraphicsContext gc;
    public JavaFxGraphics(GraphicsContext gc) {
        this.gc = gc;
    }
    private Map<String, Image> imageCache = new HashMap<>();

    @Override
    public void drawImage(String path, Position pos) {
        Image img;
        if (imageCache.containsKey(path)){
            img = imageCache.get(path);
        }else{
            img = new Image(path);
            imageCache.put(path, img);
        }
        this.gc.drawImage(img, pos.getX() - img.getWidth()/2, pos.getY() - img.getHeight()/2);
    }

    @Override
    public void drawText(String text, Position pos) {
        this.gc.strokeText(text, pos.getX(), pos.getY());
    }

    @Override
    public void drawLine(Position begin, Position end) {
        this.gc.strokeLine(begin.getX(), begin.getY(), end.getX(), end.getY());
    }

    @Override
    public void clear() {
        this.gc.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);
    }
}
