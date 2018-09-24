package ru.firsov.navalshooter.Sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.firsov.navalshooter.base.Sprite;
import ru.firsov.navalshooter.math.Rect;
import ru.firsov.navalshooter.math.Rnd;

public class Star extends Sprite {

    private Vector2 v = new Vector2();
    private Rect worldBounds;

    public Star(TextureAtlas atlas) {
        super(atlas.findRegion("Star"));
        v.set(Rnd.nextFloat(-0.005f, 0.005f), Rnd.nextFloat(-0.5f, -0.1f));
        setHeightProportion(Rnd.nextFloat(0.1f, 0.2f));
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        checkAndHandleBounds();
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        float posX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float posY = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
        pos.set(posX, posY);
    }

    private void checkAndHandleBounds() {
        if (getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight());
        if (getLeft() > worldBounds.getRight()) setRight(worldBounds.getLeft());
        if (getTop() < worldBounds.getBottom()) setBottom(worldBounds.getTop());
    }
}
