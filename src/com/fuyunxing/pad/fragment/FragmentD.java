package com.fuyunxing.pad.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fuyunxing.pad.R;


/**
 * Description: (这里用一句话描述这个类的作用)
 * Author:veidy
 * Date: 2015-03-23
 * Time: 15:08
 */
public class FragmentD extends BackHandledFragment implements View.OnClickListener {
    public static FragmentD newInstance(String param1, String param2) {
        FragmentD fragment = new FragmentD();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d, container, false);
        view.findViewById(R.id.btn_d).setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch ( v.getId() ) {
            case R.id.btn_d:
                String uri = MainActivity1.DTOA;
                onButtonPressed(uri);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onBackPressed() {

        return false;
    }
}
