package cz.cvut.fit.miadp.mvcgame.proxy;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class GameModelProxy implements IGameModel {
    private IGameModel subject;

    public GameModelProxy(IGameModel subject)
    {
        this.subject = subject;
    }

    @Override
    public void moveCannonUp() {
        this.subject.moveCannonUp();

    }

    @Override
    public void moveCannonDown() {
        this.subject.moveCannonDown();

    }

    @Override
    public void cannonShoot() {
        this.subject.cannonShoot();

    }

    @Override
    public void cannonToggleMode() {
        this.subject.cannonToggleMode();

    }

    @Override
    public void registerObserver(IObserver observer) {
        subject.registerObserver(observer);
    }

    @Override
    public void unregisterObserver(IObserver observer) {
        subject.unregisterObserver(observer);
    }

    @Override
    public List<GameObject> getGameObjects() {
        return subject.getGameObjects();
    }

}