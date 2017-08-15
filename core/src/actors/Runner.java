package actors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.physics.box2d.Body;

import box2d.RunnerUserData;

/**
 * Created by root on 10/08/17.
 */

public class Runner extends GameActor {

    private boolean jumping;
    private boolean dodging;

    public Runner(Body body){
        super(body);
    }

    @Override
    public RunnerUserData getUserData(){
        return (RunnerUserData) userData;
    }

    public void jump(){

        if(!(jumping || dodging)){
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
        }

    }

    public void landed(){
        jumping = false;
    }

    public void dodge(){
        if (!jumping){
            body.setTransform(this.getUserData().getDodgePosition(), this.getUserData().getDodgeAngle());
            dodging = true;
        }
    }

    public void stopDodge(){
        dodging = false;
        body.setTransform(getUserData().getRunningPosition(), 0f);
    }

    public boolean isDodging(){
        return dodging;
    }
}
