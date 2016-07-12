package com.fuyunxing.pad.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fuyunxing.pad.R;


/**
 * Description: (这里用一句话描述这个类的作用)
 * Author:veidy
 * Date: 2015-03-20
 * Time: 15:18
 */
public class FragmentA extends BackHandledFragment implements View.OnClickListener{

    // TODO: Rename and change types and number of parameters
    public static FragmentA newInstance(String param1, String param2) {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        view.findViewById(R.id.btn_a).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_a:
                String uri = MainActivity1.ATOB;
                onButtonPressed(uri);
                break;
        }
    }

    @Override
    public boolean onBackPressed() {
        Toast.makeText(getActivity(), "别点了，再点就退出", Toast.LENGTH_LONG).show();
        getActivity().finish();
        return true;
    }
}
