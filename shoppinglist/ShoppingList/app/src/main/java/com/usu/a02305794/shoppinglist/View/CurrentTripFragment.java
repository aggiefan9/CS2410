package com.usu.a02305794.shoppinglist.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.usu.a02305794.shoppinglist.R;
import com.usu.a02305794.shoppinglist.ViewModel.ShoppingListViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CurrentTripFragment extends Fragment {
    public CurrentTripFragment(){
        super(R.layout.fragment_current_trip);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ShoppingListViewModel viewModel = new ViewModelProvider(getActivity()).get(ShoppingListViewModel.class);
        View view = inflater.inflate(R.layout.fragment_current_trip, container, false);
        view.findViewById(R.id.saveButton).setOnClickListener(button -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_currentTrip_to_homeFragment);
        });
        view.findViewById(R.id.newItemButton).setOnClickListener(button -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_CurrentTripFragment_to_fragment_new_item);
        });
        return view;
    }
}