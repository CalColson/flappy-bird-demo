package com.cosmosis.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cosmosis.game.FlappyDemo;

/**
 * Created by Cal on 2/1/2017.
 */

public class MenuState extends State {
    private Texture background;
    private Texture playBtn;

    private String backgroundLocation = "bg.png";
    private String playBtnLocation = "playbtn.png";


    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        background = new Texture(backgroundLocation);
        playBtn = new Texture(playBtnLocation);

    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(playBtn, cam.position.x - (playBtn.getWidth() / 2),
                cam.position.y - (playBtn.getHeight() / 2));
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println(this.getClass().getSimpleName() + " disposed");
    }
}
