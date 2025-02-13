package com.usu.a02305794.shoppinglist.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ShoppingList {

    @PrimaryKey
    public long id;

    @ColumnInfo
    public double budget;

    @ColumnInfo
    public String location;

    @ColumnInfo
    public String date;
}
