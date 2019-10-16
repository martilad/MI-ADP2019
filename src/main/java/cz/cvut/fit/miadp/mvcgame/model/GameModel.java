package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.geometry.Position;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements IObservable {

    private Position logoPos;
    private List<IObserver> myObs;

    public GameModel(){
        logoPos = new Position((int)((MvcGameConfig.MAX_X/2)-128), (int)((MvcGameConfig.MAX_Y/2)-128) );
        this.myObs = new ArrayList<>();
    }

    public void moveLogoUp(){
        logoPos.setY(logoPos.getY() - 10);
        this.notifyMyObservers();
    }

    public void moveLogoDown(){
        logoPos.setY(logoPos.getY() + 10);
        this.notifyMyObservers();
    }

    public void moveLogoLeft(){
        logoPos.setX(logoPos.getX() - 10);
        this.notifyMyObservers();
    }

    public void moveLogoRight(){
        logoPos.setX(logoPos.getX() + 10);
        this.notifyMyObservers();
    }

    public Position getLogoPosition() {
        return new Position(this.logoPos);
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
        for(IObserver obs : this.myObs){
            obs.update();
        }
    }
}
