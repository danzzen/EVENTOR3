package com.eventor.eventor.tabfragments;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import com.eventor.eventor.R;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

public class CalanderFragment extends Fragment {
    CaldroidFragment caldroidFragment;
    ColorDrawable blue, green;

    ArrayList<Date> selectedDate;
    int count=0;
    Calendar calendar;
    String day , monthString;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.calander_fragment, container, false);

        caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        caldroidFragment.setArguments(args);


        selectedDate=new ArrayList<>();
       caldroidFragment.setRetainInstance(true);
        /*
        SETTING CALENDAR AS dIALOG BOX
        CaldroidFragment dialogCaldroidFragment = CaldroidFragment.newInstance("Select a date", 3, 2017);
        dialogCaldroidFragment.show(getChildFragmentManager(),"TAG");
       */
        android.support.v4.app.FragmentTransaction t = getChildFragmentManager().beginTransaction();
        t.replace(R.id.calendar, caldroidFragment);
        t.commit();
        caldroidFragment.getDateItemClickListener();

            Bundle arg1 = new Bundle();
//        args.putInt(CaldroidFragment.START_DAY_OF_WEEK, CaldroidFragment.TUESDAY); // Tuesday
//        caldroidFragment.setArguments(arg1);
            calendar = Calendar.getInstance();
            args.putBoolean(CaldroidFragment.ENABLE_CLICK_ON_DISABLED_DATES, false);
            caldroidFragment.setArguments(args);
            args.putBoolean(CaldroidFragment.ENABLE_CLICK_ON_DISABLED_DATES, true);
            caldroidFragment.setArguments(args);

            // *// lanscape mode me icon small karne ke liye
            args.putBoolean(CaldroidFragment.SQUARE_TEXT_VIEW_CELL, false);
            caldroidFragment.setArguments(args);



//
//        calendar.setTime(date);
//        calendar.set(Calendar.HOUR_OF_DAY, 6);// for 6 hour
//        calendar.set(Calendar.MINUTE, 0);// for 0 min
//        calendar.set(Calendar.SECOND, 0);// for 0 sec
//        java.util.Date greenDate=new java.util.Date();
//        calendar.set(Calendar.MONTH,3);
//        calendar.set(Calendar.DAY_OF_MONTH,3,2);
//        calendar.set(Calendar.YEAR,2017);


        blue = new ColorDrawable(getResources().getColor(R.color.colorAccent));
        green = new ColorDrawable(Color.GREEN);


        final SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");

//        try {
////            date1 = date_format.parse("2017-03-01");
////            date2 = date_format.parse("2017-04-17");
////            date3 = date_format.parse("2017-04-18");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        calendar.setTime(date1);
//        calendar.setTime(date2);
//        calendar.setTime(date3);
//        caldroidFragment.setBackgroundDrawableForDate(green, date1);
//        caldroidFragment.setBackgroundDrawableForDate(green, date2);
//        caldroidFragment.setBackgroundDrawableForDate(green, date3);

        if (savedInstanceState != null) {
            // Restore last state
            day =savedInstanceState.getString("mday");
            monthString =savedInstanceState.getString("mmonth");
        }

        else {
            Date d=new Date();
            day = (String) DateFormat.format("dd", d); // 20
            monthString = (String) DateFormat.format("MMMM", d);
        }



        final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {
                caldroidFragment.clearSelectedDates();
// String dayOfTheWeek = (String) DateFormat.format("EEEE", date); // Thursday
            day = (String) DateFormat.format("dd", date); // 20
                  monthString = (String) DateFormat.format("MMMM", date); // Jun
//                String monthNumber = (String) DateFormat.format("MM", date); // 06
//                String year = (String) DateFormat.format("yyyy", date); // 2013


                caldroidFragment.clearTextColorForDate(date);

                clearDrawable();
                caldroidFragment.setBackgroundDrawableForDate(green, date);
                selectedDate.add(date);
                caldroidFragment.refreshView();
                count++;
            }
            @Override
            public void onLongClickDate(Date date, View view) {
                caldroidFragment.clearBackgroundDrawableForDate(date);
                caldroidFragment.refreshView();
            }
        };
        caldroidFragment.setCaldroidListener(listener);
        return rootView;
    }
//    @Override
//    public void onDestroyView() {
//        if (caldroidFragment != null && getRetainInstance())
//            caldroidFragment.setRetainInstance(true);
//        super.onDestroyView();
//    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("mday",day);
        outState.putString("mmonth",monthString);
    }

    public void clearDrawable(){
    for (int i=0;i<selectedDate.size();i++){
        caldroidFragment.clearBackgroundDrawableForDate(selectedDate.get(i));
    }
}

}
