package box2d;

import enums.UserDataType;

/**
 * Created by root on 11/08/17.
 */

public abstract class UserData {

    protected UserDataType userDataType;
    protected float width;
    protected float height;
    protected String animationAssetsId;

    public UserData(){

    }

    public UserData(float width, float height){
        this.width = width;
        this.height = height;
    }

    public UserDataType getUserDataType(){
        return userDataType;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getAnimationAssetsId() {
        return animationAssetsId;
    }
}
