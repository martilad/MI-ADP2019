package cz.cvut.fit.miadp.mvcgame.proxy;

import cz.cvut.fit.miadp.mvcgame.model.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public interface IGameModel {
    void moveCannonUp();
    void moveCannonDown();
    void cannonShoot();
    void cannonToggleMode();
    void registerObserver(IObserver observer);
    void unregisterObserver(IObserver observer);
    List<GameObject> getGameObjects();
}

