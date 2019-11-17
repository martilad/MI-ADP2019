package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;

public class NShootingMode implements IShootingMode {

    private int n_shoots = MvcGameConfig.DEFAULT_N_SHOOT_IN_MULTIPLE;

    @Override
    public void shoot(AbsCannon cannon) {
        double max_angle = MvcGameConfig.MAX_ANGLE_IN_MULTIPLE;
        double div = max_angle / (double)(this.n_shoots/2);
        double base_ange = cannon.getAngle();
        double act_ange = cannon.getAngle();
        for (int i = 0; i < this.n_shoots %2;i++){
            cannon.primitiveShoot();
        }
        for (int i = 0; i < this.n_shoots/2;i++) {
            if (act_ange - div < -90){
                break;
            }
            act_ange -= div;
            cannon.setAngle(act_ange);
            cannon.primitiveShoot();
        }
        cannon.setAngle(base_ange);
        act_ange = base_ange;
        for (int i = 0; i < this.n_shoots/2;i++) {
            if (act_ange + div > 90) {
                break;
            }
            act_ange += div;
            cannon.setAngle(act_ange);
            cannon.primitiveShoot();
        }
    }

    @Override
    public void toggle(AbsCannon cannon) {
        cannon.setSingleShootingMode();
    }

    private void set_n_shoots(int n){
        if (n > 1) {
            this.n_shoots = n;
        }
    }
}
