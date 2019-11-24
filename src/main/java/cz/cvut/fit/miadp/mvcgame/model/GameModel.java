package cz.cvut.fit.miadp.mvcgame.model;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

import cz.cvut.fit.miadp.mvcgame.abstractFactory.GameObjsFac_A;
import cz.cvut.fit.miadp.mvcgame.abstractFactory.IGameObjsFac;
import cz.cvut.fit.miadp.mvcgame.command.AbsGameCommand;
import cz.cvut.fit.miadp.mvcgame.command.PauseResumeGameCommand;
import cz.cvut.fit.miadp.mvcgame.command.StartGameCommand;
import cz.cvut.fit.miadp.mvcgame.command.UndoLastCommand;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsModelInfo;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.RandomMoveStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.RealisticMoveStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMoveStrategy;

public class GameModel implements IObservable, IGameModel {
    private List<IObserver> myObs;

    private IGameObjsFac goFact;

    private AbsCannon cannon;
    private final List<IMovingStrategy> movingStrategies;
    private int actMoveStrategyIndex;

    private AbsModelInfo gameInfo;
    private List<AbsEnemy> enemies;
    private List<AbsMissile> missiles;
    private List<AbsCollision> collisions;

    private long stopwatch;
    private int score;
    private int level;
    private boolean runGame;
    private boolean pause;

    private Stack<AbsGameCommand> executedCommands;
    private Queue<AbsGameCommand> toExecutedCommands;

    public GameModel() {
        goFact = new GameObjsFac_A(this);
        this.movingStrategies = new ArrayList<>();
        movingStrategies.add(new RealisticMoveStrategy());
        movingStrategies.add(new SimpleMoveStrategy());
        movingStrategies.add(new RandomMoveStrategy());

        this.myObs = new ArrayList<>();
        this.cannon = this.goFact.createCannon();
        this.gameInfo = this.goFact.createModelInfo();
        this.cannon = this.goFact.createCannon();
        this.stopwatch = System.currentTimeMillis();
        this.toExecutedCommands = new LinkedBlockingQueue<>();
        this.executedCommands = new Stack<>();
        this.enemies = new ArrayList<>();
        this.missiles = new ArrayList<>();
        this.collisions = new ArrayList<>();
    }

    private void setStart(){
        this.score = MvcGameConfig.START_SCORE;
        this.level = 1;
        this.actMoveStrategyIndex = 0;
        this.pause = false;
        this.runGame = true;
    }

    public void moveCannonUp() {
        this.cannon.moveUp();
        this.notifyMyObservers();
    }

    public AbsCannon getCannon(){
        return this.cannon;
    }

    public void moveCannonDown() {
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
    public List<AbsEnemy> getEnemies() {
        return this.enemies;
    }

    @Override
    public List<AbsMissile> getMissiles() {
        return this.missiles;
    }

    @Override
    public void notifyMyObservers() {
        for(IObserver obs : this.myObs) {
            obs.update();
        }
    }

    private void executeCommands() {
        while (!this.toExecutedCommands.isEmpty()) {
            AbsGameCommand command = toExecutedCommands.poll();
            command.doExecute();
            this.executedCommands.push(command);
        }
    }

    private void checkWin() {
        if (this.score < MvcGameConfig.GOAL_TO_WIN) return;
        stopGame();
    }

    @Override
    public int getConfigMaxHeight() {
        return MvcGameConfig.MAX_Y;
    }

    @Override
    public int getConfigMaxWidth() {
        return MvcGameConfig.MAX_X;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public long getStopwatch() {
        return this.stopwatch;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public boolean isPause() {
        return this.pause;
    }

    @Override
    public boolean isRunGame() {
        return this.runGame;
    }

    @Override
    public AbsModelInfo getInfo() {
        return this.goFact.createModelInfo();
    }

    public void stopGame() {
        this.runGame = false;
        this.notifyMyObservers();
    }

    public void startGame() {
        if (this.runGame) return;
        setStart();
        this.cannon = this.goFact.createCannon();
        this.addEnemies();
        this.runGame = true;
        this.notifyMyObservers();
    }

    @Override
    public void pauseEndGame() {
        this.pause = !this.pause;
        this.notifyMyObservers();
    }

    @Override
    public void switchMovingStrategy() {
        this.actMoveStrategyIndex = (this.actMoveStrategyIndex + 1) % this.movingStrategies.size();
        System.out.println("Moving strategy: " + this.actMoveStrategyIndex);
    }

    @Override
    public IMovingStrategy getActiveMovingStrategy() {
        return this.movingStrategies.get(actMoveStrategyIndex);
    }

    @Override
    public void registerCommand(AbsGameCommand cmd) {
        if (cmd instanceof StartGameCommand) {
            cmd.doExecute();
            return;
        }
        if (!runGame) return;
        if (cmd instanceof PauseResumeGameCommand || cmd instanceof UndoLastCommand) {
            cmd.doExecute();
            return;
        }
        if (pause) return;
        this.toExecutedCommands.add(cmd);
    }

    @Override
    public void undoLastCommand() {
        if (executedCommands.empty()) return;
        AbsGameCommand cmd = this.executedCommands.pop();
        cmd.unExecute();
        notifyMyObservers();
    }

    @Override
    public void setMemento(Object memento) {
        Memento m = (Memento) memento;
        this.score = m.getScore();
        this.cannon = m.getCannon();
        this.actMoveStrategyIndex = m.getActiveMovementStrategyIndex();
        this.enemies = m.getEnemies();
        this.missiles = m.getMissiles();
        this.level = m.getLevel();
    }

    @Override
    public Object createMemento() {
        Memento m = new Memento();
        m.setActiveMovementStrategyIndex(this.actMoveStrategyIndex);
        m.setCannon(this.cannon);
        m.setEnemies(this.enemies);
        m.setMissiles(this.missiles);
        m.setScore(this.score);
        m.setLevel(this.level);
        return m;
    }

    @Override
    public void aimCanonUp() {
        this.cannon.aimUp();
        this.notifyMyObservers();
    }

    @Override
    public void aimCanonDown() {
        this.cannon.aimDown();
        this.notifyMyObservers();
    }

    @Override
    public void incCanonPower() {
        this.cannon.incPower();
        this.notifyMyObservers();
    }

    @Override
    public void decCannonPower() {
        this.cannon.decPower();
        this.notifyMyObservers();
    }

    private void moveGameObjects() {
        moveMissiles();
        moveEnemies();
        removeBadMissiles();
        handleCollisions();
        addEnemies();
        this.notifyMyObservers();
    }

    private void moveEnemies() {
        boolean incSpeed = isNewLevel();
        for (AbsEnemy enemy : this.enemies) {
            if (incSpeed) enemy.setVelocity(enemy.getVelocity()+MvcGameConfig.VELOCITY_STEP);
            enemy.move();
        }
    }

    private boolean isNewLevel() {
        if (score >= level * 10) {
            //SoundPlayer.playNewLevelEffect();
            level++;
            return true;
        }
        return false;
    }

    private void removeBadMissiles() {
        List<AbsMissile> rem = new ArrayList<>();

        for (AbsMissile misile : this.missiles) {
            if (misile.getX()-MvcGameConfig.THRESHOLD > this.getConfigMaxWidth() || misile.getX()+MvcGameConfig.THRESHOLD < 0) {
                rem.add(misile);
            } else if (misile.getY()-MvcGameConfig.THRESHOLD > this.getConfigMaxHeight() || misile.getY()+MvcGameConfig.THRESHOLD < 0) {
                rem.add(misile);
            }
        }
        for (AbsMissile missile : rem) {
            this.missiles.remove(missile);
        }
    }

    private void addEnemies() {
        for (int i = enemies.size(); i < MvcGameConfig.ENEMIES_CNT; i++) {
            this.enemies.add(this.goFact.createEnemy());
        }
    }

    public List<GameObject> getGameObjects() {
        List<GameObject> go = new ArrayList<>();
        go.addAll(this.missiles);
        go.addAll(this.enemies);
        go.addAll(this.collisions);
        go.add(this.cannon);
        go.add(this.gameInfo);
        return go;
    }

    public void timeTick() {
        if (!this.runGame || this.pause)return;
        for (AbsCollision c : this.collisions) {
            c.increaseTime();
        }
        for (AbsMissile missile : this.missiles){
            missile.increaseTime();
        }
        executeCommands();
        moveGameObjects();
        checkWin();
    }

    private void handleCollisions() {
        Set<AbsEnemy> enemiesToRemove = new HashSet<>();
        Set<AbsMissile> missilesToRemove = new HashSet<>();
        Set<AbsCollision> collisionsToRemove = new HashSet<>();

        for (AbsMissile m : this.missiles) {
            for (AbsEnemy e : this.enemies) {
                if (m.collidesWith(e)) {
                    //SoundPlayer.playCollisionEffect();
                    this.score++;
                    enemiesToRemove.add(e);
                    missilesToRemove.add(m);
                    this.collisions.add(this.goFact.createCollision(e.getX(), e.getY()));
                }
            }
        }

        for (AbsCollision c : this.collisions) {
            if (c.getLifetime() > MvcGameConfig.COLLISION_TIME)
                collisionsToRemove.add(c);
        }

        for (AbsEnemy enemy : enemiesToRemove) {
            this.enemies.remove(enemy);
        }

        for (AbsMissile missile : missilesToRemove) {
            this.missiles.remove(missile);
        }

        for (AbsCollision collision : collisionsToRemove) {
            this.collisions.remove(collision);
        }
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
        System.out.println("mode strategy: " + this.cannon.getShootingMode());
        this.notifyMyObservers();
    }

    public static class Memento {
        private AbsCannon cannon;
        private List<AbsMissile> missiles = new ArrayList<>();
        private List<AbsEnemy> enemies = new ArrayList<>();
        private int score;
        private int level;

        private int activeMovementStrategyIndex;

        public Memento() {
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }


        public AbsCannon getCannon() {
            return cannon;
        }

        public void setCannon(AbsCannon cannon) {
            this.cannon = cannon.clone();
        }


        public List<AbsMissile> getMissiles() {
            return missiles;
        }

        public void setMissiles(List<AbsMissile> missiles) {
            List<AbsMissile> newMissiles = new ArrayList<>();
            for (AbsMissile m : missiles) {
                newMissiles.add(m.clone());
            }
            this.missiles = newMissiles;
        }

        public List<AbsEnemy> getEnemies() {
            return enemies;
        }

        public void setEnemies(List<AbsEnemy> enemies) {
            List<AbsEnemy> newEnemies = new ArrayList<>();
            for (AbsEnemy e : enemies) {
                newEnemies.add(e.clone());
            }
            this.enemies = newEnemies;
        }

        public int getActiveMovementStrategyIndex() {
            return activeMovementStrategyIndex;
        }

        public void setActiveMovementStrategyIndex(int activeMovementStrategyIndex) {
            this.activeMovementStrategyIndex = activeMovementStrategyIndex;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
