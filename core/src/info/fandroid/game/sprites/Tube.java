package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.security.PrivilegedExceptionAction;
import java.util.Random;

public class Tube {
    //константы диапазон отклоенний труб по высоте/просветов
    public static final int FLUCTUATION = 130;
    public static final int TUBE_GAP = 100;
    public static final int LOWEST_OPENING = 120;

    public static final int TUBE_WIDTH = 52;

    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posBotTube;

    //позиции рандомные для труб
    private Random rand;

    //нарисуем прямоугольные границы вокруг труб
    private Rectangle boundsTop, boundsBot;

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public Tube(Float x) {
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");

        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        //создаем наши границы труб
        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x, posBotTube.y, bottomTube.getWidth(), bottomTube.getHeight());

    }

    //начальное расположение
    public void reposition(float x) {
        posTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBot.setPosition(posBotTube.x, posBotTube.y);
    }

    //метод столкновение птиц с трубами (обьект с обьектом)
    public boolean collides(Rectangle player) {
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }
}
