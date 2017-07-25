package com.eventor.eventor.tabfragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.eventor.eventor.Adapters.*;
import com.eventor.eventor.Data.*;
import com.eventor.eventor.R;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class HomeFragments extends Fragment
{

    RecyclerView mrcView;
  FrameLayout fm;
HomeCardAdapter homeCardAdapter;
ScrollView scrollView;
float h,w;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = layoutInflater.inflate(R.layout.home_fragment, container, false);
        mrcView = (RecyclerView) rootView.findViewById(R.id.recycler_view_list);
        fm =(FrameLayout)rootView.findViewById(R.id.categorieslayout);
//       gw=(RecyclerView)rootView.findViewById(R.id.grid);

        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mrcView.setHasFixedSize(true);

         h =getActivity().getWindowManager().getDefaultDisplay().getHeight();
         w=getActivity().getWindowManager().getDefaultDisplay().getWidth();

        mrcView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        ArrayList<TrendingEventsData> sList = getListItemData();
//        homeCardAdapter = new HomeCardAdapter(getContext(), sList);
       int i = getActivity().getResources().getConfiguration().orientation;
  //2 means land
        if(i== 2) {
            homeCardAdapter = new HomeCardAdapter(getContext(), sList, h, w,2);
        }
        else
            {
                homeCardAdapter = new HomeCardAdapter(getContext(), sList, h, w,1);
            }
        mrcView.setAdapter(homeCardAdapter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mrcView);
//        setcards();


    }
//       tTimer countDownTimer = new tTimer(10000000, 5000 );
//     countDownTimer.start();

//        ArrayList<data> al = getListItemDatforcategories();
//        gw.setHasFixedSize(true);
//        gw.setLayoutManager(new GridLayoutManager(getContext(),2 ));
//       gw.stopScroll();
//        adapter ad =new adapter(getContext(),al);
//        gw.setAdapter(ad);
//        smartScroll(scrollView,gw);

//    String myDate = "2014/10/29 18:10:45";
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    Date date = sdf.parse(myDate);
//    long millis = date.getTime();

    public ArrayList getListItemData() {

        ArrayList<TrendingEventsData> listViewItems = new ArrayList<>();
        listViewItems.add(new TrendingEventsData(R.drawable.microphone,"2017/10/29 18:10:45" ));
        listViewItems.add(new TrendingEventsData(R.drawable.events, "2017/11/29 18:10:45"));
        listViewItems.add(new TrendingEventsData(R.drawable.eev, "2017/12/29 18:10:45"));
        listViewItems.add(new TrendingEventsData(R.drawable.microphone,"2017/10/29 18:10:45" ));
        listViewItems.add(new TrendingEventsData(R.drawable.events, "2017/11/29 18:10:45"));
        listViewItems.add(new TrendingEventsData(R.drawable.eev, "2017/12/29 18:10:45"));
        listViewItems.add(new TrendingEventsData(R.drawable.microphone,"2017/10/29 18:10:45"));
        listViewItems.add(new TrendingEventsData(R.drawable.microphone,"2017/10/29 18:10:45"));
        return listViewItems;
    }



//    public ArrayList getListItemDatforcategories() {
//
//        ArrayList<data> listViewItems = new ArrayList<>();
//        listViewItems.add(new data("technical",0,R.drawable.microphone));
//        listViewItems.add(new data("cultural",0,R.drawable.microphone));
//        listViewItems.add(new data("literary",0,R.drawable.microphone));
//        listViewItems.add(new data("sports",0,R.drawable.microphone));
//        listViewItems.add(new data("others",0,R.drawable.microphone));
//        return listViewItems;
//    }



//    public void setcards()
//    {
//        CardView cd1 = (CardView)fm.findViewById(R.id.tech);
//        TextView tvTitle1= (TextView)cd1.findViewById(R.id.name);
//        ImageView itemImage1 = (ImageView)cd1.findViewById(R.id.itemImage);
//        tvTitle1.setText("Technical");
//        itemImage1.setImageResource(R.drawable.microphone);
//
//
//        CardView cd2 = (CardView)fm.findViewById(R.id.cultural);
//        TextView tvTitle2 = (TextView)cd2.findViewById(R.id.name);
//        ImageView itemImage2 = (ImageView)cd2.findViewById(R.id.itemImage);
//        tvTitle2.setText("Cultural");
//        itemImage2.setImageResource(R.drawable.microphone);
//
//        CardView cd3 = (CardView)fm.findViewById(R.id.lite);
//        TextView tvTitle3 = (TextView)cd3.findViewById(R.id.name);
//        ImageView itemImage3 = (ImageView)cd3.findViewById(R.id.itemImage);
//        tvTitle3.setText("Literary");
//        itemImage3.setImageResource(R.drawable.microphone);
//
//        CardView cd4 = (CardView)fm.findViewById(R.id.sport);
//        TextView tvTitle4 = (TextView)cd4.findViewById(R.id.name);
//        ImageView itemImage4 = (ImageView)cd4.findViewById(R.id.itemImage);
//        tvTitle4.setText("Sports");
//        itemImage4.setImageResource(R.drawable.microphone);
//
//
//        CardView cd5 = (CardView)fm.findViewById(R.id.others);
//        TextView tvTitle5 = (TextView)cd5.findViewById(R.id.name);
//        ImageView itemImage5 = (ImageView)cd5.findViewById(R.id.itemImage);
//        tvTitle5.setText("Others");
//        itemImage5.setImageResource(R.drawable.microphone);
//    }


    public class tTimer extends CountDownTimer
    {
        public tTimer(long startTime, long interval )
        {
            super(startTime, interval);

        }

        @Override
        public void onFinish()
        {
        }

        @Override
        public void onTick(long millisUntilFinished)
        {
            LinearLayoutManager layoutManager = ((LinearLayoutManager)mrcView.getLayoutManager());
//            int firstVisiblePosition = layoutManager.scrollToPositionWithOffset();

            int firstVisiblePosition = layoutManager.findFirstCompletelyVisibleItemPosition();
          if(firstVisiblePosition==6)
          {
              firstVisiblePosition=-1;
          }
//         layoutManager.smoothScrollToPosition(mrcView , mrcView.SCROLL_STATE_IDLE,firstVisiblePosition+1);
            layoutManager.scrollToPositionWithOffset(firstVisiblePosition+1,75);
        }
    }

}
