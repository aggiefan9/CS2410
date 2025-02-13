package com.usu.a02305794.shoppinglist.ViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.usu.a02305794.shoppinglist.Model.ShoppingList;
import com.usu.a02305794.shoppinglist.R;

import java.util.ArrayList;

public class ListsAdapter extends RecyclerView.Adapter<ListsAdapter.ViewHolder> {

    private ArrayList<ShoppingList> lists;
    public ListsAdapter(ArrayList<ShoppingList> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LinearLayout listLayout = new LinearLayout(parent.getContext());
//        listLayout.setPadding(16,16,16,16);
//        listLayout.setOrientation(LinearLayout.VERTICAL);
//        TextView storeView = new TextView(parent.getContext());
//        storeView.setTag("storeView");
//        TextView totalCostView = new TextView(parent.getContext());
//        totalCostView.setTag("totalCostView");
//        listLayout.addView(storeView);
//        listLayout.addView(totalCostView);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_lists_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShoppingList list = lists.get(position);
        TextView dateView = holder.itemView.findViewById(R.id.Date);
        TextView location = holder.itemView.findViewById(R.id.Location);

        dateView.setText(list.date);
        location.setText(list.location + "");
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
