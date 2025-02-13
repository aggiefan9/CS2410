package com.usu.a02305794.shoppinglist.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ListItem {
    @PrimaryKey
    public long id;

    @ColumnInfo
    public int quantity;

    @ColumnInfo
    public boolean checked;

    @ColumnInfo
    public String name;

    @ColumnInfo
    public long tripId;

    @ColumnInfo
    public double price;
}
