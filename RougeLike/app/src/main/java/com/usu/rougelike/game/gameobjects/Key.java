package com.usu.rougelike.game.gameobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.usu.rougelike.game.gameengine.Game;
import com.usu.rougelike.game.gameengine.GameObject;
import com.usu.rougelike.game.gameengine.Location;

public class Key extends GameObject {
    public Key(Game game) {
        super(game);
        getState().set("active", true);
    }

    @Override
    public void render(Canvas canvas, Paint paint) {
        // things you can do in this render method for reference.
        // Location coords = getState().get("coords"); // gets the objects row and column in the grid
        // int cellSize = game.getGameState().get("cellSize"); // gets the size of each cell from the game
        // int myX = (int)coords.x * cellSize; // gets the screen space x position
        // int myY = (int)coords.y * cellSize; // gets the screen space y position
        // boolean isActive = getState().get("active"); // get whether the key is active or not (not active means the player already picked it up)

        boolean isActive = getState().get("active");
        if (!isActive) return;

        Location coords = getState().get("coords");
        int cellSize = game.getGameState().get("cellSize");
        int myX = (int)coords.x * cellSize;
        int myY = (int)coords.y * cellSize;

        canvas.translate(myX, myY);
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        canvas.drawRect((cellSize / 2) - 1, (cellSize / 2) + 10, cellSize, (cellSize / 2) - 10, paint);
        canvas.drawRect(cellSize - 35, (cellSize / 2) + 10, cellSize - 25, (cellSize / 2) + 20, paint);
        canvas.drawRect(cellSize - 15, (cellSize / 2) + 10, cellSize - 5, (cellSize / 2) + 20, paint);
        canvas.drawCircle(cellSize / 4, cellSize / 2, cellSize / 4, paint);
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(82, 58, 40));
        canvas.drawCircle(cellSize / 4, cellSize / 2, cellSize / 8, paint);
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
        canvas.drawRect((cellSize / 2) - 1, (cellSize / 2) + 10, cellSize, (cellSize / 2) - 10, paint);
        canvas.drawRect(cellSize - 35, (cellSize / 2) + 10, cellSize - 25, (cellSize / 2) + 20, paint);
        canvas.drawRect(cellSize - 15, (cellSize / 2) + 10, cellSize - 5, (cellSize / 2) + 20, paint);
        canvas.drawCircle(cellSize / 4, cellSize / 2, cellSize / 4, paint);
        canvas.drawCircle(cellSize / 4, cellSize / 2, cellSize / 8, paint);

    }
}
