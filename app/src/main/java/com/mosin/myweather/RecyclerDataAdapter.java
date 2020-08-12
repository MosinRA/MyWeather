package com.mosin.myweather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.ViewHolder> {
    private ArrayList<String> data;

    public RecyclerDataAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = data.get(position);

        holder.setTextToTextView(text);
//        holder.setOnClickForItem(text);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView menuRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menuRecyclerView = itemView.findViewById(R.id.itemCityTextView);
        }

        void setTextToTextView(String text) {
            menuRecyclerView.setText(text);
        }

//        void setOnClickForItem(final String text) {
//            textView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(onItemClickCallback != null) {
//                        onItemClickCallback.onItemClicked(text);
//                    }
//                }
//            });
//        }
    }
}