package com.dh.superxz_bottom.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;


/**
 * Description: (这里用一句话描述这个类的作用)
 * Author:veidy
 * Date: 2015-03-20
 * Time: 15:18
 */
public class BaseFragment extends Fragment implements View.OnClickListener {
    public OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onButtonPressed(String uri) {
        if(null==mListener){
            mListener=new OnFragmentInteractionListener() {
                @Override
                public void onFragmentInteraction(String uri) {

                }
            };
        }
        mListener.onFragmentInteraction(uri);
    }

    @Override
    public void onClick(View v) {

    }


    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String uri);
    }


}
