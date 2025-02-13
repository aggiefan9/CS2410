package com.example.myshoppinglist.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Item {
    @PrimaryKey
    public long id;

    @ColumnInfo
    public String task;

    @ColumnInfo
    public boolean isComplete;

    @ColumnInfo
    public int qty;

    @ColumnInfo
    public double price;

    @Override
    public boolean equals(Object o) {
        Item other = (Item) o;
        return other.id == this.id;
    }
}
