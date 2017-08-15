package com.gdx.hook;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.GameScreen;

public class HookGame extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}

	@Override
	public void render() {

	}
}
