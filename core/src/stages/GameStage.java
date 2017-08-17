package stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

import actors.Enemy;
import actors.Ground;
import actors.Runner;
import utils.BodyUtils;
import utils.WorldUtils;

/**
 * Created by root on 09/08/17.
 */

public class GameStage extends Stage implements ContactListener{

    //para o  debug
    private static final int VIEWPORT_WIDTH = 20;
    private static final int VIEWPORT_HEIGHT = 13;

    private World world;
    private Ground ground;
    private Runner runner;

    private final float TIME_STEP = (1 / 300f);
    private float accumulator = 0f;

    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    private Rectangle screenRightSide;
    private Rectangle screenLeftSide;

    public Vector3 touchPoint;

    public GameStage(){
        setupWorld();
        setupCamera();
        setupTouchControlAreas();
        //debug
        renderer = new Box2DDebugRenderer();
    }

    private void setupCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set((camera.viewportWidth/2), (camera.viewportHeight/2), 0f);
        camera.update();
    }

    public void setupWorld(){
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        setupGround();
        setupRunner();
        createEnemy();
    }

    public void setupGround(){
        ground = new Ground(WorldUtils.createGround(world));
        addActor(ground);
    }

    public void setupRunner() {
        runner = new Runner(WorldUtils.createRunner(world));
        addActor(runner);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for (Body body : bodies)
            update(body);

        //fixed timestep
        accumulator += delta;

        while (accumulator >= delta){
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

        //TODO interpolação
    }

    private void update(Body body){
        if(!BodyUtils.bodyInBounds(body)){
            if(BodyUtils.bodyIsEnemy(body) && !runner.isHit()){
                createEnemy();
            }
            world.destroyBody(body);
        }
    }

    private void createEnemy(){
        Enemy enemy = new Enemy(WorldUtils.createEnemy(world));
        addActor(enemy);
    }

    @Override
    public void draw() {
        super.draw();
        renderer.render(world, camera.combined);
    }

    public void setupTouchControlAreas(){
        touchPoint = new Vector3();
        screenRightSide = new Rectangle((getCamera().viewportWidth /2), 0, (getCamera().viewportWidth /2), getCamera().viewportHeight);
        screenLeftSide = new Rectangle(0,0, (getCamera().viewportWidth /2), getCamera().viewportHeight);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button){

        //pegar coordenadas atual
        translateScreenToWorldCoordinates(x,y);

        if(rightSideTouched(touchPoint.x, touchPoint.y)){
            runner.jump();
        }
        else if(leftSideTouched(touchPoint.x, touchPoint.y)){
            runner.dodge();
        }

        return super.touchDown(x,y,pointer,button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(runner.isDodging()){
            runner.stopDodge();
        }
        return super.touchUp(screenX, screenY, pointer, button);
    }

    private boolean  rightSideTouched(float x, float y){
        return screenRightSide.contains(x,y);
    }

    private boolean leftSideTouched(float x, float y){
        return screenLeftSide.contains(x,y);
    }

    //Função Helper para ajudar a pegar as coordenadas no mundo
    private void translateScreenToWorldCoordinates(int x, int y){
        getCamera().unproject(touchPoint.set(x,y,0));
    }


    @Override
    public void beginContact(Contact contact) {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsEnemy(b)) || (BodyUtils.bodyIsEnemy(a) && BodyUtils.bodyIsRunner(b))){
            runner.hit();
    }
       else if((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsGround(b)) || (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsRunner(b))){
            runner.landed();
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
