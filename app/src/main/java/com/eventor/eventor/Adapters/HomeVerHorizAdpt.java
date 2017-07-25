package com.eventor.eventor.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.eventor.eventor.Data.EvenstOfDay;
import com.eventor.eventor.R;

import java.util.ArrayList;
public class HomeVerHorizAdpt extends RecyclerView.Adapter<HomeVerHorizAdpt.ItemSingleitems> {
    ArrayList<EvenstOfDay> elist=new ArrayList<>();
    Context ctx;
    public HomeVerHorizAdpt(ArrayList<EvenstOfDay> list, Context context) {
        this.elist=list;
        this.ctx=context;
    }

    @Override
    public HomeVerHorizAdpt.ItemSingleitems onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ver_hoz_row, null);
       ItemSingleitems mh = new ItemSingleitems(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(HomeVerHorizAdpt.ItemSingleitems holder, int position) {
        EvenstOfDay it=elist.get(position);
        holder.x.setImageResource(it.getImg());

    }

    @Override
    public int getItemCount() {
        return elist.size();
    }
    class ItemSingleitems extends RecyclerView.ViewHolder {
                ImageView x;
         ItemSingleitems(View itemView) {
            super(itemView);
          this.x=(ImageView)itemView.findViewById(R.id.weekEvent);
        }
    }
}
