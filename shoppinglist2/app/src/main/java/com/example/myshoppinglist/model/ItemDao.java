package com.example.myshoppinglist.model;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM Item")
    public List<Item> getItems();

//    @Query("SELECT * FROM todo WHERE isComplete = 1")
//    public List<Item> getCompletedTodos();
//
//    @Query("SELECT isComplete FROM todo WHERE id = :id")
//    public Boolean getIsTodoCompleted(long id);

    @Insert
    public long createItem(Item item);

    @Update
    public void updateItem(Item item);

    @Delete
    public void deleteItem(Item item);
}
