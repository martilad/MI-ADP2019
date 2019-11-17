package cz.cvut.fit.miadp.mvcgame.model;

import java.util.*;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.abstractFactory.GameObjsFac_A;
import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjsFac;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsModelInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.Missile_A;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class GameModel implements IObservable, IGameModel {
    private List<IObserver> myObs;

    private IGameObjsFac goFact = new GameObjsFac_A(this);

    private AbsCannon cannon;
    private AbsModelInfo gameInfo;
    private List<AbsEnemy> enemies;
    private List<AbsMissile> missiles;
    private List<AbsCollision> collisions;

    private Timer timer;
    private long stopwatch;
    private int score;
    private boolean runGame;
    //private Stack<AbsGameCommand> executedCommands;

    public GameModel() {
        this.myObs = new ArrayList<IObserver>();

        this.cannon = this.goFact.createCannon();
        this.gameInfo = this.goFact.createModelInfo();

        this.enemies = new ArrayList<AbsEnemy>();
        this.missiles = new ArrayList<AbsMissile>();
        this.collisions = new ArrayList<AbsCollision>();
        this.initTimer();
    }

    public void moveCannonUp()
    {
        this.cannon.moveUp();

        this.notifyMyObservers();
    }

    public AbsCannon getCannon(){
        return this.cannon;
    }

    public void moveCannonDown()
    {
        this.cannon.moveDown();

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

    private void initTimer() {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //executeCommands();
                moveGameObjects();
                checkWin();
                stopwatch += MvcGameConfig.TIME_PERIOD;
            }
        }, 0, MvcGameConfig.TIME_PERIOD);
    }

    private void checkWin() {
        if (this.score < MvcGameConfig.GOAL_TO_WIN) return;
        stopGame();
    }

    public void stopGame() {
        timer.cancel();
        this.runGame = false;
        this.notifyMyObservers();
    }

    public void startGame() {
        if (runGame) return;
        //initGameModel();
        //initGameObjects();
        initTimer();
        this.notifyMyObservers();
    }

    private void moveGameObjects() {
        moveMissiles();
        //moveEnemies();
        //removeBadMissiles();
        //handleCollisions();
        //addEnemies();
        this.notifyMyObservers();
    }

    public List<GameObject> getGameObjects() {
        List<GameObject> go = new ArrayList<GameObject>();

        go.addAll(this.missiles);
        go.addAll(this.enemies);
        go.addAll(this.collisions);
        go.add(this.cannon);
        go.add(this.gameInfo);

        return go;
    }

    public void timeTick() {
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        this.moveMissiles();
    }

    private void moveMissiles() {
        for (AbsMissile missile : this.missiles){
            missile.move();
        }
        this.notifyMyObservers();
    }

    public void cannonShoot() {

        this.missiles.addAll(this.cannon.shoot());
        this.notifyMyObservers();
    }

    @Override
    public void cannonToggleMode() {
        this.cannon.toggleShootingMode();
        this.notifyMyObservers();
    }
}
