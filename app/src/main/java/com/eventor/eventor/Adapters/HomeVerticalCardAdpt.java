package com.eventor.eventor.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.eventor.eventor.Data.DaysOfWeek;
import com.eventor.eventor.Data.EvenstOfDay;
import com.eventor.eventor.R;

import java.util.ArrayList;
public class HomeVerticalCardAdpt extends RecyclerView.Adapter<HomeVerticalCardAdpt.ItemRowsHolder> {
    ArrayList<DaysOfWeek> list = new ArrayList<>();
    ArrayList<EvenstOfDay> ls=new ArrayList<>();
    Context mContext;

    @Override
    public ItemRowsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_vertical_card, null);
        ItemRowsHolder mh = new ItemRowsHolder(v);
        return mh;
    }




    public HomeVerticalCardAdpt(Context context, ArrayList<DaysOfWeek> list,ArrayList<EvenstOfDay> ds) {
        this.list = list;
        this.mContext = context;
        this.ls=ds;
    }

    @Override
    public void onBindViewHolder(ItemRowsHolder holder, int position) {
        DaysOfWeek d=list.get(position);
        holder.day.setText(d.getDay());
        HomeVerHorizAdpt hvz = new HomeVerHorizAdpt(ls,mContext);
        holder.r.setHasFixedSize(true);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(holder.r);
        holder.r.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.r.setAdapter(hvz);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

 class ItemRowsHolder extends RecyclerView.ViewHolder {
       private RecyclerView r;
      private   TextView day;
        ItemRowsHolder(View itemView) {
            super(itemView);
            day=(TextView)itemView.findViewById(R.id.DayOfWeek);
            r = (RecyclerView) itemView.findViewById(R.id.recycler_view_list_day);


        }
    }
}
