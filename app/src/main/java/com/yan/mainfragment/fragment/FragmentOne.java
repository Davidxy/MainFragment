package com.yan.mainfragment.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yan.mainfragment.R;
import com.yan.mainfragment.ui.MessageCountActivity;
import com.yan.mainfragment.ui.TextSizeActivity;
import com.yan.mainfragment.ui.VariousViewActivity;
import com.yan.mainfragment.ui.WhatYourLoveActivity;

/**
 * Created by 黄艳武 on 2016/1/12.
 * Function:
 */
public class FragmentOne extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_textview, container, false);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText(getArguments().getString("args"));
        tv_title.setOnClickListener(this);
        view.findViewById(R.id.btn_various_size).setOnClickListener(this);
        view.findViewById(R.id.btn_various_view).setOnClickListener(this);
        view.findViewById(R.id.btn_normal).setOnClickListener(this);
        view.findViewById(R.id.btn_abnormal).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_title:
                getActivity().startActivity(new Intent(getActivity(), VariousViewActivity.class));
                break;
            case R.id.btn_various_size:
                getActivity().startActivity(new Intent(getActivity(), TextSizeActivity.class));
                break;
            case R.id.btn_various_view:
                getActivity().startActivity(new Intent(getActivity(), VariousViewActivity.class));
                break;
            case R.id.btn_normal:
                getActivity().startActivity(new Intent(getActivity(), MessageCountActivity.class));
                break;
            case R.id.btn_abnormal:
                getActivity().startActivity(new Intent(getActivity(), WhatYourLoveActivity.class));
                break;
        }
    }
}
