package com.usu.a02305794.shoppinglist.Model;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ListItem.class, ShoppingList.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ListItemDao getListItemDao();
    public abstract ShoppingListDao getShoppingListDao();
}