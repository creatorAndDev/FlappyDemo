package info.fandroid.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import info.fandroid.game.FlappyDemo;

public class MenuState extends State{
    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        //для того что бы меню на начальном экране не было мелким
        camera.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);

        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        //для того что бы меню на начальном экране не было мелким
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(playBtn, camera.position.x - playBtn.getWidth() / 2, camera.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();

        System.out.println("MenuState Dispose");
    }
}
