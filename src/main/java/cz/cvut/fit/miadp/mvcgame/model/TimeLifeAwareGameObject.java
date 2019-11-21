package cz.cvut.fit.miadp.mvcgame.model;


public abstract class TimeLifeAwareGameObject extends GameObject
{
    private int created = 0;

    public int getLifetime() {
        return this.created;
    }

    public void increaseTime(){
        this.created++;
    }

}