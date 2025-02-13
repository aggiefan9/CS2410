package com.example.myshoppinglist.repository;

import android.content.Context;

import androidx.room.Room;

import com.example.myshoppinglist.model.AppDatabase;
import com.example.myshoppinglist.model.Item;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;

@Singleton
public class Repository {

    AppDatabase db;

    ArrayList<Item> items;

    double total = 0;

    @Inject
    public Repository(@ApplicationContext Context context){
        db = Room.databaseBuilder(context, AppDatabase.class, "items-database").build();
    }

    public void saveItem(String task, int qty, double price){
        //save it
        Item newItem = new Item();
        newItem.task = task;
        newItem.qty = qty;
        newItem.price = price;
        newItem.isComplete = false;
        //Item save to database
        newItem.id = items.size()+1;
        db.getItemDao().createItem(newItem);
        items.add(newItem);
    }

    public ArrayList<Item> getItems(){
        if(items == null){
            items = (ArrayList<Item>) db.getItemDao().getItems();
        }
        return items;
    }

    public void deleteAll() {
        for(Item item: items) {
                db.getItemDao().deleteItem(item);
        }
        items.clear();
        items = (ArrayList<Item>) db.getItemDao().getItems();
        total = 0;
    }

    public void deleteItem(Item item){
        db.getItemDao().deleteItem(item);
    }


    public void updateItem(Item item){
        db.getItemDao().updateItem(item);
    }

    public double getTotal(){
        getItems();
        if (items == null){
            return 0.00;
        }
        for(Item item : items){
            total += item.price * item.qty;
        }
        return total;
    }

}
