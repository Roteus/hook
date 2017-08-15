package box2d;

import enums.UserDataType;

/**
 * Created by root on 11/08/17.
 */

public abstract class UserData {

    protected UserDataType userDataType;

    public UserData(){

    }

    public UserDataType getUserDataType(){
        return userDataType;
    }

}
