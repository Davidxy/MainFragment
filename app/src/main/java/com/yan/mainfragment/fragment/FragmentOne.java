package com.yan.mainfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yan.mainfragment.R;

/**
 * Created by 黄艳武 on 2016/1/12.
 * Function:
 */
public class FragmentOne extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_textview, container, false);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText(getArguments().getString("args"));
        return view;
    }
}
