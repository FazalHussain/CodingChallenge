package com.example.fazal.codingchalenge.UI.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fazal.codingchalenge.Constants.Constant;
import com.example.fazal.codingchalenge.Models.data.Item;
import com.example.fazal.codingchalenge.Models.data.Items;
import com.example.fazal.codingchalenge.Models.data.SectionRole;
import com.example.fazal.codingchalenge.R;

import java.lang.invoke.ConstantCallSite;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Worker Adapter class
 */
public class WorkerAdapter extends RecyclerView.Adapter {

    List<Item> itemsList;
    Context context;

    public static final int SECTION_TYPE = 0;
    public static final int ITEM_TYPE = 1;

    /**
     * Constructor
     *
     * @param context   Holding the reference of an activity.
     * @param itemsList The list of items {@linkplain List<Item>}
     */
    public WorkerAdapter(Context context, List<Item> itemsList) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = null;
        if (i == SECTION_TYPE) {
            view = inflater.inflate(R.layout.section_layout, viewGroup, false);
            return new SectionViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.worker_item_row, viewGroup, false);
            return new ViewHolder(view);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = itemsList.get(position);
        if (item.isSection()) {

            //Cast item with section & cast view holder to section view holder & set the role

            SectionRole sectionRole = (SectionRole) item;
            SectionViewHolder sectionViewHolder = (SectionViewHolder) holder;
            sectionViewHolder.tvSection.setText(sectionRole.getRole());

        } else {

            //Cast Recycler view holder with item view holder and cast item with Items
            //Map the data to item row

            ViewHolder viewHolder = (ViewHolder) holder;
            Items items = (Items) item;

            viewHolder.tvFirstName.setText(context.getString(R.string.first_name,
                    items.getAttributes().getFirstName()));
            viewHolder.tvLastName.setText(context.getString(R.string.last_name,
                    items.getAttributes().getLastName()));
            viewHolder.tvCreated.setText(context.getString(R.string.created_at,
                    items.getAttributes().getCreated_at()));
            viewHolder.tvUpdated.setText(context.getString(R.string.updated_at,
                    items.getAttributes().getUpdated_at()));

        }
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (itemsList.get(position).isSection()) {
            return SECTION_TYPE;
        } else {
            return ITEM_TYPE;
        }
    }

    /**
     * The item view holder inner class
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvFirstName)
        TextView tvFirstName;
        @BindView(R.id.tvLastName)
        TextView tvLastName;
        @BindView(R.id.tvCreatedAt)
        TextView tvCreated;
        @BindView(R.id.tvUpdatedAt)
        TextView tvUpdated;

        /**
         * Constructor
         *
         * @param itemView The root view of layout.
         * @see ButterKnife#bind(View)
         */
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * The section view holder inner class
     */
    class SectionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvSection)
        TextView tvSection;

        /**
         * Constructor
         *
         * @param itemView The root view of layout.
         * @see ButterKnife#bind(View)
         */
        public SectionViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * Refresh the list of items
     *
     * @param items The collection of an items {@linkplain List<Item>}
     * @see RecyclerView.Adapter#notifyDataSetChanged()
     */
    public void refresh(List<Item> items) {
        itemsList = items;
        notifyDataSetChanged();
    }
}
