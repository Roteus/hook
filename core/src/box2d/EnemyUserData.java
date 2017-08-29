package box2d;

import com.badlogic.gdx.math.Vector2;

import enums.EnemyType;
import utils.Constants;

/**
 * Created by root on 17/08/17.
 */

public class EnemyUserData extends UserData {

    private Vector2 linearVelocity;
    private String[] textureRegions;

    public EnemyUserData(float width, float height, String animationAssetsId){
        super(width, height);
        userDataType = userDataType.ENEMY;
        linearVelocity = Constants.ENEMY_LINEAR_VELOCITY;
        this.animationAssetsId = animationAssetsId;
    }

    public void setLinearVelocity(Vector2 linearVelocity){
        this.linearVelocity = linearVelocity;
    }

    public Vector2 getLinearVelocity(){
        return linearVelocity;
    }

    public String[] getTextureRegions(){
        return textureRegions;
    }

}
