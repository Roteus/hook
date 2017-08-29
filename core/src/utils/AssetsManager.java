package utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

/**
 * Created by root on 23/08/17.
 */

public class AssetsManager {
    private static HashMap<String, TextureRegion> texturesMap = new HashMap<String, TextureRegion>();
    private static HashMap<String, Animation> animationsMap = new HashMap<String, Animation>();
    private static TextureAtlas textureAtlas;
    private static BitmapFont smallFont;
    private static BitmapFont smallestFont;
    private static BitmapFont largeFont;

    public static void loadAssets(){
        //background
        texturesMap.put(Constants.BACKGROUND_ASSETS_ID, new TextureRegion(new Texture(Gdx.files.internal(Constants.BACKGROUND_IMAGE_PATH))));

        //ground
        texturesMap.put(Constants.GROUND_ASSETS_ID, new TextureRegion(new Texture(Gdx.files.internal(Constants.GROUND_IMAGE_PATH))));

        textureAtlas = new TextureAtlas(Constants.SPRITE_ATLAS_PATH);

        //runner
        texturesMap.put(Constants.RUNNER_JUMPING_ASSETS_ID, textureAtlas.findRegion(Constants.RUNNER_JUMPING_REGION_NAME));
        texturesMap.put(Constants.RUNNER_DODGING_ASSETS_ID, textureAtlas.findRegion(Constants.RUNNER_DODGING_REGION_NAME));
        texturesMap.put(Constants.RUNNER_HIT_ASSETS_ID, textureAtlas.findRegion(Constants.RUNNER_HIT_REGION_NAME));
        animationsMap.put(Constants.RUNNER_RUNNING_ASSETS_ID, createAnimation(textureAtlas, Constants.RUNNER_RUNNING_REGION_NAMES));

        //enemy
        animationsMap.put(Constants.FLYING_SMALL_ENEMY_ASSETS_ID, createAnimation(textureAtlas, Constants.FLYING_SMALL_ENEMY_REGION_NAMES));
        animationsMap.put(Constants.FLYING_WIDE_ENEMY_ASSETS_ID, createAnimation(textureAtlas, Constants.FLYING_WIDE_ENEMY_REGION_NAMES));
        animationsMap.put(Constants.RUNNING_BIG_ENEMY_ASSETS_ID, createAnimation(textureAtlas, Constants.RUNNING_BIG_ENEMY_REGION_NAMES));
        animationsMap.put(Constants.RUNNING_LONG_ENEMY_ASSETS_ID, createAnimation(textureAtlas, Constants.RUNNING_LONG_ENEMY_REGION_NAMES));
        animationsMap.put(Constants.RUNNING_SMALL_ENEMY_ASSETS_ID, createAnimation(textureAtlas, Constants.RUNNING_SMALL_ENEMY_REGION_NAMES));
        animationsMap.put(Constants.RUNNING_WIDE_ENEMY_ASSETS_ID, createAnimation(textureAtlas, Constants.RUNNING_WIDE_ENEMY_REGION_NAMES));
    }

    private static Animation createAnimation(TextureAtlas textureAtlas, String[] regionNames){
        TextureRegion[] runningFrames = new TextureRegion[regionNames.length];

        for (int i = 0; i < regionNames.length; i++){
            String path = regionNames[i];
            runningFrames[i] = textureAtlas.findRegion(path);
        }

        return new Animation(0.1f, runningFrames);
    }

    public static Animation getAnimation(String key){
        return animationsMap.get(key);
    }

    public static TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public static BitmapFont getSmallFont() {
        return smallFont;
    }

    public static BitmapFont getSmallestFont() {
        return smallestFont;
    }

    public static BitmapFont getLargeFont() {
        return largeFont;
    }

    public static void dispose(){
        textureAtlas.dispose();
        smallestFont.dispose();
        smallFont.dispose();
        largeFont.dispose();
        texturesMap.clear();
        animationsMap.clear();
    }
}
