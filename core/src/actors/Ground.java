package actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

import box2d.GroundUserData;

/**
 * Created by root on 10/08/17.
 */

public class Ground extends GameActor{

    public Ground(Body body){
        super(body);
    }

    public GroundUserData getUserData(){
        return (GroundUserData) userData;
    }
}
