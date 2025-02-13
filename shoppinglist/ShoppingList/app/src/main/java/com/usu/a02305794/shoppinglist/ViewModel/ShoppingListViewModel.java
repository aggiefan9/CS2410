package com.usu.a02305794.shoppinglist.ViewModel;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.usu.a02305794.shoppinglist.Model.ListItem;
import com.usu.a02305794.shoppinglist.Model.ShoppingList;
import com.usu.a02305794.shoppinglist.Repository.Repository;

import java.util.ArrayList;
import java.util.Objects;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ShoppingListViewModel extends ViewModel {
    private Repository repository;
    private MutableLiveData<Boolean> saving = new MutableLiveData<>();
    private boolean checkedAscending = true;
    private ObservableArrayList<ListItem> items = new ObservableArrayList<>();
    private MutableLiveData<ShoppingList> list = new MutableLiveData<>();


    @Inject
    public ShoppingListViewModel(Repository repository){
        this.repository = repository;
        saving.postValue(false);
    }

    public void saveList(double budget, String location, String date){
        saving.postValue(true);
        new Thread (() ->{
            setCurrentList(repository.saveGroceryList(budget, location, date));
            saving.postValue(false);
        }).start();
    }

    public MutableLiveData<ShoppingList> getCurrentList(){
        return list;
    }

    public void setCurrentList(long id){
        this.list.postValue(repository.getTrip(id));
    }

    public ArrayList<ListItem> getItemsForCurrentList (){
        return repository.getListItemsForTrip(list.getValue().id);
    }

    public void saveList(){
        saving.postValue(true);
        new Thread (() ->{
            setCurrentList(repository.saveGroceryList(Objects.requireNonNull(list.getValue()).budget, Objects.requireNonNull(list.getValue()).location, Objects.requireNonNull(list.getValue()).date));
            saving.postValue(false);
        }).start();
    }

    public void saveItem(int quantity, String name, double price){
        saving.postValue(true);
        new Thread(() -> {
            repository.saveListItem(quantity, name, price, Objects.requireNonNull(list.getValue()).id);
            items = new ObservableArrayList<>();
            items.addAll(repository.getListItemsForTrip(list.getValue().id));
            saving.postValue(false);
        }).start();
    }


    public boolean sortChecked(){
        if(checkedAscending){
            checkedAscending = false;
            return true;
        } else {
            checkedAscending = true;
            return false;
        }
    }


    public void getAllTrips(){
        repository.getAllTrips();
    }
}
