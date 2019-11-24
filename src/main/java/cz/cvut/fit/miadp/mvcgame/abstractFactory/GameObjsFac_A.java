package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.*;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.*;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMoveStrategy;

import java.util.Random;

public class GameObjsFac_A implements IGameObjsFac {

    private GameModel model;
    private IMovingStrategy activeMovingStrategy = new SimpleMoveStrategy();
    private Random random = new Random();
    public GameObjsFac_A(GameModel model)
    {
        this.model = model;
    }

    @Override
    public AbsCannon createCannon() {
        return new Cannon_A(this);
    }

    @Override
    public AbsCollision createCollision(int x, int y) {
        Collision_A c = new Collision_A();
        c.setX(x);
        c.setY(y);
        return c;
    }

    @Override
    public AbsEnemy createEnemy() {
        int place = random.nextInt(this.model.getConfigMaxWidth() - (this.model.getConfigMaxWidth() / 5));
        int x_cannon_zone = (this.model.getConfigMaxWidth() / 5) + place;
        int y = random.nextInt(this.model.getConfigMaxHeight());
        return new Enemy_A(x_cannon_zone, y, model.getLevel());
    }

    @Override
    public AbsMissile createMissile() {
        return new Missile_A(
                this.model.getCannon().getX(),
                this.model.getCannon().getY(),
                this.model.getCannon().getAngle(),
                this.model.getCannon().getVelocity(),
                this.model.getActiveMovingStrategy()
        );
    }

    @Override
    public AbsModelInfo createModelInfo() {
        return new ModelInfo_A(this.model);
    }

}
