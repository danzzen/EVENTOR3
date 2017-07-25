package com.eventor.eventor.tabfragments;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eventor.eventor.R;

import org.w3c.dom.Text;

/**
 * Created by lenovo on 11-03-2017.
 */

public class CollageFragment extends Fragment {
    TextView myText;
    Image img;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.collage_fragment,container,false);
        return rootView;
    }
}
