package box2d;

import enums.UserDataType;

/**
 * Created by root on 11/08/17.
 */

public class GroundUserData extends UserData {

    public GroundUserData(){
        super();
        userDataType = UserDataType.GROUND;
    }

}
