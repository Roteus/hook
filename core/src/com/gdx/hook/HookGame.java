package com.gdx.hook;

import com.badlogic.gdx.Game;
import screens.GameScreen;
import utils.AssetsManager;

public class HookGame extends Game {

	@Override
	public void create() {
		AssetsManager.loadAssets();
		setScreen(new GameScreen());
	}

}
