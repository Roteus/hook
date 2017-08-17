package actors;

import com.badlogic.gdx.physics.box2d.Body;

import box2d.EnemyUserData;
import box2d.UserData;

/**
 * Created by root on 17/08/17.
 */

public class Enemy extends GameActor {

    public Enemy(Body body){
        super(body);
    }

    @Override
    public EnemyUserData getUserData() {
        return (EnemyUserData) userData;
    }

    @Override
    public void act(float delta){
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }
}
