package actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

import box2d.EnemyUserData;
import utils.AssetsManager;

/**
 * Created by root on 17/08/17.
 */

public class Enemy extends GameActor {

    private Animation animation;
    private float stateTime;

    public Enemy(Body body){
        super(body);
        animation = AssetsManager.getAnimation(getUserData().getAnimationAssetsId());
        stateTime = 0f;
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

    @Override
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch, parentAlpha);
        stateTime += Gdx.graphics.getDeltaTime();
        batch.draw((TextureRegion) animation.getKeyFrame(stateTime, true), (screenRectangle.x - (screenRectangle.width * 0.1f)), screenRectangle.y, (screenRectangle.width * 1.2f), (screenRectangle.height * 1.1f));
    }
}
