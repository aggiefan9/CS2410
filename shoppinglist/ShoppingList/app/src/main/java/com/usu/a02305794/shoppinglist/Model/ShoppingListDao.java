package com.usu.a02305794.shoppinglist.Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShoppingListDao {

    @Query("SELECT * FROM shoppinglist")
    public List<ShoppingList> getAllTrips();

    @Query("SELECT * FROM shoppinglist WHERE id = :id")
    public ShoppingList getTrip(long id);

    @Insert
    public long createShoppingList(ShoppingList list);

    @Update
    public void updateShoppingList(ShoppingList list);

    @Delete
    public void deleteShoppingList(ShoppingList list);
}
