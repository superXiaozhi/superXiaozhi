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
 * Date: 2015-03-20
 * Time: 15:18
 */
public class FragmentB extends BackHandledFragment implements View.OnClickListener {
    // TODO: Rename and change types and number of parameters
    public static FragmentB newInstance(String param1, String param2) {
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        view.findViewById(R.id.btn_b).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch ( v.getId() ) {
            case R.id.btn_b:
                String uri = MainActivity1.BTOC;
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
