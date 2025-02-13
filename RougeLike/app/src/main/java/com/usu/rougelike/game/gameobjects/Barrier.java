package com.usu.rougelike.game.gameobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.usu.rougelike.game.gameengine.Game;
import com.usu.rougelike.game.gameengine.GameObject;
import com.usu.rougelike.game.gameengine.Location;

public class Barrier extends GameObject {
    public Barrier(Game game) {
        super(game);
    }

    @Override
    public void render(Canvas canvas, Paint paint) {
        // things you can do in this render method for reference.
        // Location coords = getState().get("coords"); // gets the objects row and column in the grid
        // int cellSize = game.getGameState().get("cellSize"); // gets the size of each cell from the game
        // int myX = (int)coords.x * cellSize; // gets the screen space x position
        // int myY = (int)coords.y * cellSize; // gets the screen space y position

        Location coords = getState().get("coords");
        int cellSize = game.getGameState().get("cellSize");
        int myX = (int)coords.x * cellSize;
        int myY = (int)coords.y * cellSize;

        canvas.translate(myX, myY);
        paint.setColor(Color.GRAY);
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GRAY);
        canvas.drawRect(0, 0, cellSize / 2, cellSize / 2, paint);
        canvas.drawRect(cellSize / 2, cellSize / 2, cellSize, cellSize, paint);
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.LTGRAY);
        canvas.drawRect(0, cellSize / 2, cellSize / 2, cellSize, paint);
        canvas.drawRect(cellSize / 2, 0, cellSize, cellSize / 2, paint);
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.DKGRAY);
        canvas.drawRect(cellSize / 4, cellSize / 4, cellSize * 3 / 4, cellSize * 3 / 4, paint);
    }
}
