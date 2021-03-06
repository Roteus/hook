package utils;

import com.badlogic.gdx.math.Path;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by root on 09/08/17.
 */

public class Constants {

    public static final String GAME_NAME = "Hook";

    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 600;
    public static final float WORLD_TO_SCREEN = 32;

    //world
    public static final Vector2 WORLD_GRAVITY = new Vector2(0,-10);
    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 25f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;

    //runner
    public static final float RUNNER_X = 2;
    public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH = 1f;
    public static final float RUNNER_HEIGHT = 2f;
    public static float RUNNER_DENSITY = 0.5f;
    public static final float RUNNER_GRAVITY_SCALE = 3f;
    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0,13f);
    public static final float RUNNER_HIT_ANGULAR_IMPULSE = 10f;
    public static final float RUNNER_DODGE_X = 2f;
    public static final float RUNNER_DODGE_Y = 1.5f;

    //enemys
    public static final float ENEMY_X = 25f;
    public static final float ENEMY_DENSITY = RUNNER_DENSITY;
    public static final float RUNNING_SHORT_ENEMY_Y = 1.5f;
    public static final float RUNNING_LONG_ENEMY_Y = 2f;
    public static final float FLYING_ENEMY_Y = 3f;
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-10f, 0);

    //background
    public static final String BACKGROUND_IMAGE_PATH = "landscape.png";
    public static final String GROUND_IMAGE_PATH = "ground_final.png";

    //sprites runner
    public static final String SPRITE_ATLAS_PATH = "characters.txt";
    public static final String[] RUNNER_RUNNING_REGION_NAMES = new String[] {"alienGreen_run1", "alienGreen_run2"};
    public static final String RUNNER_DODGING_REGION_NAME = "alienGreen_dodge";
    public static final String RUNNER_HIT_REGION_NAME = "alienGreen_hit";
    public static final String RUNNER_JUMPING_REGION_NAME = "alienGreen_jump";


    //sprites enemys
    public static final String[] RUNNING_SMALL_ENEMY_REGION_NAMES = new String[] {"ladybug_walk1", "ladybug_walk2"};
    public static final String[] RUNNING_LONG_ENEMY_REGION_NAMES = new String[] {"barnacle_bite1", "barnacle_bite2"};
    public static final String[] RUNNING_BIG_ENEMY_REGION_NAMES =  new String[] {"spider_walk1", "spider_walk2"};
    public static final String[] RUNNING_WIDE_ENEMY_REGION_NAMES = new String[] {"worm_walk1", "worm_walk2"};
    public static final String[] FLYING_SMALL_ENEMY_REGION_NAMES = new String[] {"bee_fly1", "bee_fly2"};
    public static final String[] FLYING_WIDE_ENEMY_REGION_NAMES = new String[] {"fly_fly1", "fly_fly2"};

    public static final String BACKGROUND_ASSETS_ID = "background";
    public static final String GROUND_ASSETS_ID = "ground";
    public static final String RUNNER_RUNNING_ASSETS_ID = "runner_running";
    public static final String RUNNER_DODGING_ASSETS_ID = "runner_dodging";
    public static final String RUNNER_HIT_ASSETS_ID = "runner_hit";
    public static final String RUNNER_JUMPING_ASSETS_ID = "runner_jumping";
    public static final String RUNNING_SMALL_ENEMY_ASSETS_ID = "running_small_enemy";
    public static final String RUNNING_LONG_ENEMY_ASSETS_ID = "running_long_enemy";
    public static final String RUNNING_BIG_ENEMY_ASSETS_ID = "running_big_enemy";
    public static final String RUNNING_WIDE_ENEMY_ASSETS_ID = "running_wide_enemy";
    public static final String FLYING_SMALL_ENEMY_ASSETS_ID = "flying_small_enemy";
    public static final String FLYING_WIDE_ENEMY_ASSETS_ID = "flying_wide_enemy";
}
