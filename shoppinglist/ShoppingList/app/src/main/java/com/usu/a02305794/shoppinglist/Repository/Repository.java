package com.usu.a02305794.shoppinglist.Repository;

import android.content.Context;

import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.usu.a02305794.shoppinglist.Model.AppDatabase;
import com.usu.a02305794.shoppinglist.Model.ShoppingList;
import com.usu.a02305794.shoppinglist.Model.ListItem;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;

@Singleton
public class Repository {

    AppDatabase db;

    @Inject
    public Repository(@ApplicationContext Context context) {
        db = Room.databaseBuilder(context, AppDatabase.class, "shoppingList-database").build();
    }

    public void saveListItem(int quantity, String name, double price, long tripID) {
        ListItem newItem = new ListItem();
        newItem.quantity = quantity;
        newItem.checked = false;
        newItem.name = name;
        newItem.price = price;
        newItem.tripId = tripID;
        newItem.id = db.getListItemDao().createListItem(newItem);
    }

    public long saveGroceryList(double budget, String location, String date) {
        ShoppingList newList = new ShoppingList();
        newList.budget = budget;
        newList.date = date;
        newList.location = location;
        newList.id = db.getShoppingListDao().createShoppingList(newList);
        return newList.id;
    }

    public ArrayList<ListItem> getListItemsForTrip(long id) {
        return (ArrayList<ListItem>) db.getListItemDao().getListItemForTrip(id);
    }

    public ArrayList<ListItem> sortNameDesc(long id) {
        return (ArrayList<ListItem>) db.getListItemDao().sortNameDesc(id);
    }

    public ArrayList<ListItem> sortNameAsc(long id) {
        return (ArrayList<ListItem>) db.getListItemDao().sortNameAsc(id);
    }

    public ArrayList<ListItem> sortQtyDesc(long id) {
        return (ArrayList<ListItem>) db.getListItemDao().sortQtyDesc(id);
    }

    public ArrayList<ListItem> sortQtyAsc(long id) {
        return (ArrayList<ListItem>) db.getListItemDao().sortQtyAsc(id);
    }

    public ArrayList<ListItem> sortPriceDesc(long id) {
        return (ArrayList<ListItem>) db.getListItemDao().sortPriceDesc(id);
    }

    public ArrayList<ListItem> sortPriceAsc(long id) {
        return (ArrayList<ListItem>) db.getListItemDao().sortPriceAsc(id);
    }

    public ArrayList<ListItem> sortCheckedDesc(long id) {
        return (ArrayList<ListItem>) db.getListItemDao().sortCheckedDesc(id);
    }

    public ArrayList<ListItem> sortCheckedAsc(long id) {
        return (ArrayList<ListItem>) db.getListItemDao().sortCheckedAsc(id);
    }

    public ArrayList<ShoppingList> getAllTrips() {
        return (ArrayList<ShoppingList>) db.getShoppingListDao().getAllTrips();
    }

    public ShoppingList getTrip(long id) {
        return db.getShoppingListDao().getTrip(id);
    }
}
