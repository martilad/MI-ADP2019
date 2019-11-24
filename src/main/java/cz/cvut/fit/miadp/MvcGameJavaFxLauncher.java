package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.bridge.GameGraphics;
import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.bridge.JavaFxGraphics;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.*;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import javafx.util.Pair;

public class MvcGameJavaFxLauncher extends Application {

    private static final MvcGame theMvcGame = new MvcGame();
    private final KeyCombination ctrlZ = new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN);

    @Override
    public void init() {
        theMvcGame.init();
    }

    @Override
    public void start(Stage stage) {
        String winTitle = theMvcGame.getWindowTitle();
        int winWidth = theMvcGame.getWindowWidth();
        int winHeigth = theMvcGame.getWindowHeight();



        stage.setTitle( winTitle );

        Group root = new Group();
        Scene theScene = new Scene( root );
        stage.setScene( theScene );
            
        Canvas canvas = new Canvas( winWidth, winHeigth );
        root.getChildren().add( canvas );
            

        IGameGraphics gc = new GameGraphics(new JavaFxGraphics(canvas.getGraphicsContext2D()));

        List<String> pressedKeysCodes = new ArrayList<>();

        theScene.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (ctrlZ.match(ke)) {
                pressedKeysCodes.add("Ctrl+Z");
                return;
            }
            if (!pressedKeysCodes.contains(ke.getCode().getName()))
                pressedKeysCodes.add(ke.getCode().getName());
        });

        theScene.addEventFilter(KeyEvent.KEY_RELEASED, ke -> pressedKeysCodes.remove(ke.getCode().getName()));

        // the game-loop
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // Clear the canvas
                theMvcGame.processPressedKeys(pressedKeysCodes);
                pressedKeysCodes.clear();
                theMvcGame.update();
                theMvcGame.render(gc);
            }
        }.start();
            
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}