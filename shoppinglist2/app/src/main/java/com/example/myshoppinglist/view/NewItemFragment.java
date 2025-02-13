package com.example.myshoppinglist.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myshoppinglist.R;
import com.example.myshoppinglist.viewmodel.NewItemsViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewItemFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_item, container, false);
        NewItemsViewModel viewModel = new ViewModelProvider(this)
                .get(NewItemsViewModel.class);

        viewModel.getErrorMessage().observe(this, (message)-> {
            TextView errorView = view.findViewById(R.id.errorMessage);
            errorView.setText(message);
        });

        viewModel.getSaving().observe(this, (saving) ->{
            Button button = view.findViewById(R.id.saveButton);
            if(saving) {
                button.setEnabled(false);
                button.setText("Saving...");
            }else {
                button.setEnabled(true);
                button.setText("Save");
            }
        });

        viewModel.getSaveSuccess().observe(this, (saveSuccess) -> {
            if (saveSuccess){
                NavHostFragment.findNavController(this).popBackStack();
            }
        });

        view.findViewById(R.id.saveButton).setOnClickListener(button -> {
            EditText taskText = view.findViewById(R.id.item);
            EditText priceText = view.findViewById(R.id.price);
            EditText qtyText = view.findViewById(R.id.qty);
            viewModel.saveItem(taskText.getText().toString().equals("") ? "": taskText.getText().toString(),
                    Double.parseDouble(priceText.getText().toString().equals("") ? "0" : priceText.getText().toString()),
                    Integer.parseInt(qtyText.getText().toString().equals("") ? "0" : qtyText.getText().toString()));
        });

        return view;
    }
}