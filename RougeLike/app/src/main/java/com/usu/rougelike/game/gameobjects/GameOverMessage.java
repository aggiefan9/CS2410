package com.usu.rougelike.game.gameobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.usu.rougelike.game.gameengine.Game;
import com.usu.rougelike.game.gameengine.GameObject;

public class GameOverMessage extends GameObject {
    public GameOverMessage(Game game) {
        super(game);
    }

    @Override
    public void render(Canvas canvas, Paint paint) {
        // this object is a little different than the others as is doesn't have a position inherently.
        // its position is determined at render time.
        // here are some of the things that will be useful for you.
        // float height = game.getHeight(); // get the height of the game
        // float width = game.getWidth(); // get the width of the game
        boolean isPlaying = game.getGameState().get("playing");
        if (isPlaying) return;
        paint.setColor(Color.RED);
        paint.setTextSize(150);
        canvas.drawText("GAME OVER", game.getWidth() / 8, game.getHeight() / 3, paint);
        canvas.drawCircle(game.getWidth() / 2, game.getHeight() / 2, 200, paint);
        canvas.drawRoundRect(game.getWidth() / 2 - 65, game.getHeight() / 2 + 150,game.getWidth() / 2 - 5, game.getHeight() / 2 + 250, 50, 50, paint);
        canvas.drawRoundRect(game.getWidth() / 2 + 5, game.getHeight() / 2 + 150,game.getWidth() / 2 + 65, game.getHeight() / 2 + 250, 50, 50, paint);
        canvas.drawRoundRect(game.getWidth() / 2 - 135, game.getHeight() / 2 + 100,game.getWidth() / 2 - 75, game.getHeight() / 2 + 250,  50, 50, paint);
        canvas.drawRoundRect(game.getWidth() / 2 + 75, game.getHeight() / 2 + 100,game.getWidth() / 2 + 135, game.getHeight() / 2 + 250,  50, 50, paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(game.getWidth() / 2 - 75, game.getHeight() / 2, 50, paint);
        canvas.drawCircle(game.getWidth() / 2 + 75, game.getHeight() / 2, 50, paint);
        canvas.save();
        canvas.translate(game.getWidth() / 2, game.getHeight() / 2 + 115);
        canvas.rotate(45);
        canvas.drawRect(-25, -25, 25, 25, paint);
        canvas.restore();
        paint.setColor(Color.RED);
        canvas.drawRect(game.getWidth() / 2 - 50, game.getHeight() / 2 + 125, game.getWidth() / 2 + 50, game.getHeight() / 2 + 175, paint);
        canvas.drawRect(game.getWidth() / 2 - 5, game.getHeight() / 2 + 75, game.getWidth() / 2 + 5, game.getHeight() / 2 + 175, paint);
    }
}
