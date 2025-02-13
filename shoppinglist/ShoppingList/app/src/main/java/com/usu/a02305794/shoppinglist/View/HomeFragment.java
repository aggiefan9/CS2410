package com.usu.a02305794.shoppinglist.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.usu.a02305794.shoppinglist.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {
    public HomeFragment(){
        super(R.layout.fragment_home);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        view.findViewById((R.id.newList)).setOnClickListener(button -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_newListFragment);

        });
        return view;
    }
}