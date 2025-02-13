package com.usu.a02305794.shoppinglist.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.usu.a02305794.shoppinglist.Model.ShoppingList;
import com.usu.a02305794.shoppinglist.R;
import com.usu.a02305794.shoppinglist.ViewModel.ShoppingListViewModel;

public class NewListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_new_list, container, false);
        ShoppingListViewModel viewModel = new ViewModelProvider(getActivity()).get(ShoppingListViewModel.class);
        view.findViewById(R.id.saveNewList).setOnClickListener(button -> {


            EditText editLocation = view.findViewById(R.id.newLocation);
            String location = editLocation.getText().toString().equals("") ? " " : editLocation.getText().toString();

            EditText editBudget = view.findViewById(R.id.newBudget);
            double budget = editBudget.getText().toString().equals("") ? 0.00 : Double.parseDouble(editBudget.getText().toString());

            EditText editDate = view.findViewById(R.id.newDate);
            String date = editDate.getText().toString().equals("") ? " " : editDate.getText().toString();

            viewModel.saveList(budget, location, date);
            NavHostFragment.findNavController(this).navigate(R.id.action_newListFragment_to_CurrentTripFragment);
        });
        view.findViewById(R.id.CancelNewList).setOnClickListener(button -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_newListFragment_to_homeFragment);
        });
        return view;
    }
}