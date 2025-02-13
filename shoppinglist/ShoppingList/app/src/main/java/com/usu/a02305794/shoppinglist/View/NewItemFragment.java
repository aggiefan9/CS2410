package com.usu.a02305794.shoppinglist.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.usu.a02305794.shoppinglist.R;
import com.usu.a02305794.shoppinglist.ViewModel.ShoppingListViewModel;


public class NewItemFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_item, container, false);
        ShoppingListViewModel viewModel = new ViewModelProvider(getActivity()).get(ShoppingListViewModel.class);
        view.findViewById(R.id.newItemSave).setOnClickListener(button->{
            EditText editName = view.findViewById(R.id.newItemName);
            String name = editName.getText().toString().equals("") ? " ": editName.getText().toString();

            EditText editQuantity = view.findViewById(R.id.newItemQuantity);
            int quantity = editQuantity.getText().toString().equals("") ? 1: Integer.parseInt(editQuantity.getText().toString());

            EditText editPrice = view.findViewById(R.id.newItemPrice);
            double price = editPrice.getText().toString().equals("") ? 1: Double.parseDouble(editPrice.getText().toString());

            viewModel.saveItem(quantity, name, price);
            NavHostFragment.findNavController(this).navigate(R.id.action_fragment_new_item_to_CurrentTripFragment);
        });
        view.findViewById(R.id.newItemCancel).setOnClickListener(button -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_fragment_new_item_to_CurrentTripFragment);
        });

        return view;
    }
}