package utils;

import com.badlogic.gdx.physics.box2d.Body;

import box2d.UserData;
import enums.UserDataType;

/**
 * Created by root on 11/08/17.
 */

public class BodyUtils {

    public static boolean bodyIsRunner(Body body){
        UserData userData  = (UserData) body.getUserData();
        return (userData != null && userData.getUserDataType() == UserDataType.RUNNER);
    }

    public static boolean bodyIsGround(Body body){
        UserData userData = (UserData) body.getUserData();
        return (userData != null && userData.getUserDataType() == UserDataType.GROUND);
    }
}
