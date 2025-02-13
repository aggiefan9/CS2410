package com.usu.a02305794.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

//    @Inject
//    public MainActivity(Repository repo){
//        this.repo = repo;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction()
//                    .setReorderingAllowed(true)
//                    .add(R.id.fragmentContainerView, HomeFragment.class, null)
//                    .commit();
//        }
//
//        ArrayList<ShoppingList> trips = new ArrayList<>();
//        for (int i = 0; i<1000; i++) {
//            ShoppingList trip = new ShoppingList();
//            trip.location = "Store" + i;
//            trips.add(trip);
//        }
//
//        RecyclerView recyclerView = findViewById(R.id.HomeRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new ListsAdapter((trips)));
//
//        ArrayList<PastTrip> pastTrips = new ArrayList<>();
//        for (int i = 0; i<1000; i++) {
//            PastTrip pastTrip = new PastTrip();
//            pastTrip.store = "Store" + i;
//            pastTrip.totalCost = i;
//            pastTrips.add(pastTrip);
//        }
//
//        RecyclerView analyticsRecyclerView = findViewById(R.id.analytics_recycler_view);
//        analyticsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}