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

public class GameModelProxy implements IGameModel {
    private IGameModel model;

    public GameModelProxy(IGameModel model) {
        this.model = model;
    }

    @Override
    public int getScore() {
        return this.model.getScore();
    }

    @Override
    public long getStopwatch() {
        return this.model.getStopwatch();
    }

    @Override
    public int getLevel() {
        return this.model.getLevel();
    }

    @Override
    public boolean isPause() {
        return this.model.isPause();
    }

    @Override
    public boolean isRunGame() {
        return this.model.isPause();
    }

    @Override
    public int getConfigMaxHeight() {
        return this.model.getConfigMaxHeight();
    }

    @Override
    public int getConfigMaxWidth() {
        return this.model.getConfigMaxWidth();
    }

    @Override
    public AbsModelInfo getInfo() {
        return this.model.getInfo();
    }

    @Override
    public void stopGame() {
        this.model.stopGame();
    }

    @Override
    public void startGame() {
        this.model.startGame();
    }

    @Override
    public void pauseResumeGame() {
        this.model.pauseResumeGame();
    }

    @Override
    public void switchMovingStrategy() {
        this.model.switchMovingStrategy();
    }

    @Override
    public IMovingStrategy getActiveMovingStrategy() {
        return this.model.getActiveMovingStrategy();
    }

    @Override
    public void registerCommand(AbsGameCommand cmd) {
        this.model.registerCommand(cmd);
    }

    @Override
    public void undoLastCommand() {
        this.model.undoLastCommand();
    }

    @Override
    public void setMemento(Object memento) {
        this.model.setMemento(memento);
    }

    @Override
    public Object createMemento() {
        return this.model.createMemento();
    }

    @Override
    public void aimCanonUp() {
        this.model.aimCanonUp();
    }

    @Override
    public void aimCanonDown() {
        this.model.aimCanonDown();
    }

    @Override
    public void incCanonPower() {
        this.model.incCanonPower();
    }

    @Override
    public void decCannonPower() {
        this.model.decCannonPower();
    }

    @Override
    public void moveCannonUp() {
        this.model.moveCannonUp();
    }

    @Override
    public void moveCannonDown() {
        this.model.moveCannonDown();

    }

    @Override
    public void cannonShoot() {
        this.model.cannonShoot();

    }

    @Override
    public void cannonToggleMode() {
        this.model.cannonToggleMode();

    }

    @Override
    public AbsCannon getCannon() {
        return this.model.getCannon();
    }

    @Override
    public void registerObserver(IObserver observer) {
        this.model.registerObserver(observer);
    }

    @Override
    public void unregisterObserver(IObserver observer) {
        this.model.unregisterObserver(observer);
    }

    @Override
    public List<AbsEnemy> getEnemies() {
        return this.model.getEnemies();
    }

    @Override
    public List<AbsMissile> getMissiles() {
        return this.model.getMissiles();
    }

    @Override
    public List<GameObject> getGameObjects() {
        return this.model.getGameObjects();
    }

}