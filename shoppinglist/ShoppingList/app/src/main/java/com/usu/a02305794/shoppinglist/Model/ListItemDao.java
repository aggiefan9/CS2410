package com.usu.a02305794.shoppinglist.Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ListItemDao {

//    @Query("SELECT * FROM listitem WHERE checked = 1")
//    public List<ListItem> getCheckedListItems();
//
//    @Query("SELECT checked FROM listitem WHERE id = :id")
//    public Boolean getIsChecked(long id);

    @Query("SELECT * FROM listitem WHERE tripId = :id")
    public List<ListItem> getListItemForTrip(long id);

    @Query("SELECT * FROM listitem WHERE tripId = :id ORDER BY name DESC")
    public List<ListItem> sortNameDesc(long id);

    @Query("SELECT * FROM listitem WHERE tripId = :id ORDER BY name ASC")
    public List<ListItem> sortNameAsc(long id);

    @Query("SELECT * FROM listitem WHERE tripId = :id ORDER BY quantity DESC")
    public List<ListItem> sortQtyDesc(long id);

    @Query("SELECT * FROM listitem WHERE tripId = :id ORDER BY quantity ASC")
    public List<ListItem> sortQtyAsc(long id);

    @Query("SELECT * FROM listitem WHERE tripId = :id ORDER BY price DESC")
    public List<ListItem> sortPriceDesc(long id);

    @Query("SELECT * FROM listitem WHERE tripId = :id ORDER BY price ASC")
    public List<ListItem> sortPriceAsc(long id);

    @Query("SELECT * FROM listitem WHERE tripId = :id ORDER BY checked DESC, name ASC")
    public List<ListItem> sortCheckedDesc(long id);

    @Query("SELECT * FROM listitem WHERE tripId = :id ORDER BY checked ASC, name ASC")
    public List<ListItem> sortCheckedAsc(long id);

    @Insert
    public long createListItem(ListItem item);

    @Update
    public void updateListItem(ListItem item);

    @Delete
    public void deleteListItem(ListItem item);
}
