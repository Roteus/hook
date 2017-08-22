package box2d;

import enums.UserDataType;

/**
 * Created by root on 11/08/17.
 */

public class GroundUserData extends UserData {

    public GroundUserData(float width, float height){
        super(width, height);
        userDataType = UserDataType.GROUND;
    }

}
