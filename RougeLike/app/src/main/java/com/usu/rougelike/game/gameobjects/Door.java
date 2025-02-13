package com.usu.rougelike.game.gameobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.usu.rougelike.game.gameengine.Game;
import com.usu.rougelike.game.gameengine.GameObject;
import com.usu.rougelike.game.gameengine.Location;

public class Door extends GameObject {
    public Door(Game game) {
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
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(cellSize / 2, cellSize / 3 + 10,cellSize / 3, paint);
        canvas.drawRect(cellSize / 6, cellSize / 3 + 10, cellSize * 5 / 6, cellSize - 10, paint);
        paint.setColor(Color.rgb(83, 132, 144));
        canvas.drawCircle(cellSize / 2, cellSize / 3 + 10,cellSize / 3 - 5, paint);
        canvas.drawRect(cellSize / 6 + 5, cellSize / 3 + 15, cellSize * 5 / 6 - 5, cellSize - 15, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawCircle(cellSize / 3, cellSize / 2 + 5, 10, paint);
        paint.reset();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        canvas.drawCircle(cellSize / 3, cellSize / 2 + 5, 10, paint);
    }
}
