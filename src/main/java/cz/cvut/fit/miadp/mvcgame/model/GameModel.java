package cz.cvut.fit.miadp.mvcgame.model;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.GameObjsFac_A;
import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjsFac;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsModelInfo;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;

public class GameModel implements IObservable {
    private List<IObserver> myObs;

    private IGameObjsFac goFact = new GameObjsFac_A();

    private AbsCannon cannon;
    private AbsModelInfo gameInfo;
    private List<AbsEnemy> enemies;
    private List<AbsMissile> missile;
    private List<AbsCollision> collisions;

    public GameModel() {
        this.myObs = new ArrayList<IObserver>();

        this.cannon = this.goFact.createCannon();
        this.gameInfo = this.goFact.createModelInfo();

        this.enemies = new ArrayList<AbsEnemy>();
        this.missile = new ArrayList<AbsMissile>();
        this.collisions = new ArrayList<AbsCollision>();
    }

    public void moveCannonUp()
    {
        this.cannon.moveUp();

        this.notifyMyObservers();
    }

    public void moveCannonDown()
    {
        this.cannon.moveDown();

        this.notifyMyObservers();
    }

    public void moveCannonLeft()
    {
        this.cannon.moveLeft();

        this.notifyMyObservers();
    }

    public void moveCannonRight()
    {
        this.cannon.moveRight();

        this.notifyMyObservers();
    }



    @Override
    public void registerObserver(IObserver obs) {
        this.myObs.add(obs);
    }

    @Override
    public void unregisterObserver(IObserver obs) {
        this.myObs.remove(obs);
    }

    @Override
    public void notifyMyObservers() {
        for(IObserver obs : this.myObs)
        {
            obs.update();
        }
    }



    public List<GameObject> getGameObjects() {
        List<GameObject> go = new ArrayList<GameObject>();

        go.addAll(this.missile);
        go.addAll(this.enemies);
        go.addAll(this.collisions);
        go.add(this.cannon);
        go.add(this.gameInfo);

        return go;
    }

    public void timeTick() {
        //this.moveMissiles();
    }

}
