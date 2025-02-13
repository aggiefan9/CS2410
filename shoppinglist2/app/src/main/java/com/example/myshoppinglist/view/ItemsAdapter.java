package com.example.myshoppinglist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshoppinglist.R;
import com.example.myshoppinglist.model.Item;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.TodoViewHolder> {

    public interface OnItemClick{
        public void onClick(Item item);
    }

    ObservableArrayList<Item> items;
    OnItemClick eventListener;
    public ItemsAdapter(ObservableArrayList<Item> items, OnItemClick eventListener){
        this.items = items;
        this.eventListener = eventListener;
        items.addOnListChangedCallback(new ObservableList.OnListChangedCallback() {
            @Override
            public void onChanged(ObservableList sender) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
                notifyItemRangeChanged(positionStart,itemCount);
            }

            @Override
            public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
                notifyItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
                notifyItemMoved(fromPosition, toPosition);
            }

            @Override
            public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
                notifyItemRangeRemoved(positionStart, itemCount);
            }
        });
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TodoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Item item = items.get(position);
        CheckBox checkBox = holder.itemView.findViewById(R.id.checkBox);
        TextView price = holder.itemView.findViewById(R.id.priceView);
        price.setText(String.format("Total Price: %.2f \n Qty: %d", item.price* item.qty, item.qty));
        checkBox.setChecked(item.isComplete);
        checkBox.setText(item.task);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                eventListener.onClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder{

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
