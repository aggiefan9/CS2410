package com.example.myshoppinglist.viewmodel;

import android.os.Handler;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myshoppinglist.model.Item;
import com.example.myshoppinglist.repository.Repository;

import java.util.ArrayList;
import java.util.Observable;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ItemsViewModel extends ViewModel {
    Repository repository;
    ObservableArrayList<Item> items = new ObservableArrayList<>();
    MutableLiveData<Double> total = new MutableLiveData<>();
    Handler handler = new Handler();


    @Inject
    public ItemsViewModel(Repository repository){
        this.repository = repository;
    }

    public ObservableArrayList<Item> getItems() {
            this.items.clear();
            new Thread(() -> {
                ArrayList<Item> repoItems = this.repository.getItems();
                handler.post(() ->{
                    this.items.addAll(repoItems);
                });
            }).start();
        return this.items;
    }

    public void toggleItemStatus(Item item){
        new Thread(() -> {
            item.isComplete = !item.isComplete;
            this.repository.updateItem(item);
            int index = items.indexOf(item);
            handler.post(() -> {
                items.set(index, item);
            });
        }).start();
    }

    public void clearAll() {
        new Thread(() -> {
            this.repository.deleteAll();
            ArrayList<Item> repoItems = this.repository.getItems();
            handler.post(() -> {
                this.items.addAll(repoItems);
            });
        }).start();
    }

    public MutableLiveData<Double> getTotal(){
        new Thread(() -> {
            this.total.postValue(this.repository.getTotal());
        }).start();
        return total;
    }
}

