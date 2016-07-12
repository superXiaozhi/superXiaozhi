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
public class FragmentC extends BackHandledFragment implements View.OnClickListener {
    // TODO: Rename and change types and number of parameters
    public static FragmentC newInstance(String param1, String param2) {
        FragmentC fragment = new FragmentC();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        view.findViewById(R.id.btn_c).setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch ( v.getId() ) {
            case R.id.btn_c:
                String uri = MainActivity1.CTOD;
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
