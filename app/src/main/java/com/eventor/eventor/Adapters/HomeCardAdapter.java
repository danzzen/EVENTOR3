package com.eventor.eventor.Adapters;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eventor.eventor.Data.TrendingEventsData;
import com.eventor.eventor.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class HomeCardAdapter extends RecyclerView.Adapter<HomeCardAdapter.ItemRowHolder> {
    ArrayList<TrendingEventsData> list = new ArrayList<>();
    Context mContext;
  float he,wi;
int orient;

    @Override
    public HomeCardAdapter.ItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_row, null);
        return   new ItemRowHolder(v);
    }


    public HomeCardAdapter(Context context, ArrayList<TrendingEventsData> list) {
        this.list = list;
        this.mContext = context;

    }


    public HomeCardAdapter(Context context, ArrayList<TrendingEventsData> list,float h ,float w,int i) {
        this.list = list;
        this.mContext = context;
        he=h;
        wi=w;
        orient=i;
    }
    @Override
    public void onBindViewHolder(HomeCardAdapter.ItemRowHolder holder, int position)
    {

//        int i = Activity.getResources().getConfiguration().orientation;
//        Activity.getResources().getConfiguration().orientation();

    holder.position.setText(position+1+"/7");
   if(orient==1) {
       holder.cd.setLayoutParams(new LinearLayout.LayoutParams((int) wi - 160, (int) (he / 3.2)));
   }
   else
       {
           holder.cd.setLayoutParams(new LinearLayout.LayoutParams((int) wi/2, (int) (he / 2)));
       }
        TrendingEventsData ted = list.get(position);
        String time = ted.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long actualmillis = date.getTime();


        Calendar cal = Calendar.getInstance();
        long currentmillis = cal.getTimeInMillis();
        long duration=actualmillis-currentmillis;

     tTimer  countDownTimer = new tTimer(duration, 1000, holder.tvTitle);
countDownTimer.start();

        if(position==7)
        {
            holder.cd.setVisibility(View.INVISIBLE);
        }

//       setText();

//        Glide.with(mContext)
//                .load(ted.getId()).centerCrop()
//                .placeholder(R.drawable.eev)
//                .crossFade(2800)
//                .into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ItemRowHolder extends RecyclerView.ViewHolder {

        TextView tvTitle,position;
        ImageView itemImage;
        LinearLayout cd;

        ItemRowHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.time);
            this.position = (TextView) view.findViewById(R.id.position);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
            cd =(LinearLayout) view.findViewById(R.id.cardfortrending);
        }
    }




    // CountDownTimer class
    public class tTimer extends CountDownTimer
    {
TextView tv;
        public tTimer(long startTime, long interval,TextView tw )
        {
            super(startTime, interval);
        tv =tw;
        }

        @Override
        public void onFinish()
        {
        }

        @Override
        public void onTick(long millisUntilFinished)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("  HH/ mm /ss");
            String s = sdf.format(millisUntilFinished);

            String p[] = s.split("/");

            String ss = p[0] +"hours " +p[1] +"mins "+ p[2]+"sec remaining";
        tv.setText(ss);
        }
    }

}

