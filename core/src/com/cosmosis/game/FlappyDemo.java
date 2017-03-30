package com.cosmosis.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cosmosis.game.states.GameStateManager;
import com.cosmosis.game.states.MenuState;

public class FlappyDemo extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	public static final String TITLE = "Flappy Birdy";
    private GameStateManager gsm;
    private SpriteBatch sb;

	public static Music music;
	private String musicLocation = "music.mp3";

	@Override
	public void create () {
		sb = new SpriteBatch();
        gsm = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal(musicLocation));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
        Gdx.gl.glClearColor(1, 1, 0, 1);

        gsm.push(new MenuState(gsm));
    }

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(sb);
	}
	
	@Override
	public void dispose () {
		super.dispose();
		music.dispose();
		sb.dispose();
	}
}
