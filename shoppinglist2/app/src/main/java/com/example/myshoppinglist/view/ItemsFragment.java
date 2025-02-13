package com.example.myshoppinglist.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myshoppinglist.R;
import com.example.myshoppinglist.viewmodel.ItemsViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ItemsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ItemsViewModel viewModel = new ViewModelProvider(this).get(ItemsViewModel.class);

        View view = inflater.inflate(R.layout.fragment_items_fragment, container, false);

        view.findViewById(R.id.plusButton).setOnClickListener(button -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_todos_fragment_to_newTodosFragment);
        });

        viewModel.getTotal().observe(this, (d)-> {
            TextView textView = view.findViewById(R.id.header);
            textView.setText(String.format("Current Total for Your Shopping List: $%.2f",d));
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new ItemsAdapter(viewModel.getItems(), item -> {
            viewModel.toggleItemStatus(item);
        }));
        view.findViewById(R.id.clearAllButton).setOnClickListener(button -> {
            viewModel.clearAll();
            onCreateView(inflater,container,savedInstanceState);
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}