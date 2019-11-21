package cz.cvut.fit.miadp.mvcgame.proxy;

import cz.cvut.fit.miadp.mvcgame.command.AbsGameCommand;
import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsModelInfo;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public interface IGameModel {

    int getConfigMaxHeight();
    int getConfigMaxWidth();

    int getScore();
    long getStopwatch();
    int getLevel();


    boolean isPause();
    boolean isRunGame();



    AbsModelInfo getInfo();

    void stopGame();
    void startGame();
    void pauseResumeGame();


    void switchMovingStrategy();
    IMovingStrategy getActiveMovingStrategy();

    void registerCommand(AbsGameCommand cmd);
    void undoLastCommand();

    void setMemento(Object memento);
    Object createMemento();

    void aimCanonUp();
    void aimCanonDown();
    void incCanonPower();
    void decCannonPower();
    void moveCannonUp();
    void moveCannonDown();
    void cannonShoot();
    void cannonToggleMode();
    AbsCannon getCannon();

    void registerObserver(IObserver observer);
    void unregisterObserver(IObserver observer);

    List<AbsEnemy> getEnemies();
    List<AbsMissile> getMissiles();
    List<GameObject> getGameObjects();
}

