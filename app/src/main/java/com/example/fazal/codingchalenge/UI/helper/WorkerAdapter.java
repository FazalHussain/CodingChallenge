package com.example.fazal.codingchalenge.UI.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fazal.codingchalenge.Models.data.Items;
import com.example.fazal.codingchalenge.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkerAdapter extends RecyclerView.Adapter<WorkerAdapter.ViewHolder> {

    List<Items> itemsList;
    Context context;

    public WorkerAdapter(Context context, List<Items> itemsList) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.worker_item_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Items item = itemsList.get(i);
        if (item.getType().equalsIgnoreCase("worker")) {
            viewHolder.tvFirstName.setText(context.getString(R.string.first_name,
                    item.getAttributes().getFirstName()));
            viewHolder.tvLastName.setText(context.getString(R.string.last_name,
                    item.getAttributes().getLastName()));
            viewHolder.tvCreated.setText(context.getString(R.string.created_at,
                    item.getAttributes().getCreated_at()));
            viewHolder.tvUpdated.setText(context.getString(R.string.updated_at,
                    item.getAttributes().getUpdated_at()));
        }

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvFirstName)
        TextView tvFirstName;
        @BindView(R.id.tvLastName)
        TextView tvLastName;
        @BindView(R.id.tvCreatedAt)
        TextView tvCreated;
        @BindView(R.id.tvUpdatedAt)
        TextView tvUpdated;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
