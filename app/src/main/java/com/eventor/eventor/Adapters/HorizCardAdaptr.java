package com.eventor.eventor.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eventor.eventor.Data.TrendingEventsData;
import com.eventor.eventor.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 17-03-2017.
 */

public class HorizCardAdaptr extends RecyclerView.Adapter<HorizCardAdaptr.SingleItemRowHolder> {
    private ArrayList<TrendingEventsData> itemsList;
    private Context mContext;

    public HorizCardAdaptr(Context context, ArrayList<TrendingEventsData> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_row, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        TrendingEventsData iteww = itemsList.get(i);
        holder.itemImage.setImageResource(iteww.getId());
        holder.tvTitle.setText(iteww.getTime());

       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.time);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }

}

