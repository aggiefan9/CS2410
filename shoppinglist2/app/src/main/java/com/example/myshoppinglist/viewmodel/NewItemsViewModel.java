package com.example.myshoppinglist.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myshoppinglist.repository.Repository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NewItemsViewModel extends ViewModel {
    Repository repository;
    MutableLiveData<String> errorMessage = new MutableLiveData<>();
    MutableLiveData<Boolean> saving = new MutableLiveData<>();
    MutableLiveData<Boolean> saveSuccess = new MutableLiveData<>();

    @Inject
    public NewItemsViewModel(Repository repository){
        this.repository = repository;
        errorMessage.setValue("");
        saving.setValue(false);
        saveSuccess.setValue(false);
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public MutableLiveData<Boolean> getSaving() {
        return saving;
    }

    public MutableLiveData<Boolean> getSaveSuccess() {
        return saveSuccess;
    }

    public void saveItem(String item, double price, int qty){
        //check to make sure item not empty
        errorMessage.setValue("");
        saving.setValue(true);
        new Thread(() -> {
            if (item.isEmpty()){
                errorMessage.postValue("Item Name Cannot Be Empty");
            } else {
                this.repository.saveItem(item, qty, price);
                saveSuccess.postValue(true);
            }
            saving.postValue(false);
        }).start();
    }
}
