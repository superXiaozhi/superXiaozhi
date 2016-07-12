package com.fuyunxing.pad.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.fuyunxing.pad.R;


public class MainActivity1 extends FragmentActivity implements BaseFragment.OnFragmentInteractionListener, BackHandledFragment.BackHandledInterface {

    public FragmentManager mFragmentManager;

    //定义四条路径
    public final static String ATOB = "atob";
    public final static String BTOC = "btoc";
    public final static String CTOD = "ctod";
    public final static String DTOA = "dtoa";

    private BackHandledFragment mBackHandedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragmentContent(FragmentA.newInstance("", ""));

    }

    private void addFragmentContent(Fragment paramFragment) {

        this.mFragmentManager = getSupportFragmentManager();

        FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();

        localFragmentTransaction.replace(R.id.fragment_container, paramFragment);
        //记录commit一次操作，与mFragmentManager.popBackStack();匹配使用
        localFragmentTransaction.addToBackStack(null);
        //commitAllowingStateLoss 优于 commit 方法,当使用commit方法时，系统将进行状态判断，如果状态（mStateSaved）已经保存，将发生"Can not perform this action after onSaveInstanceState"错误。
        //如果mNoTransactionsBecause已经存在，将发生"Can not perform this action inside of " + mNoTransactionsBecause错误。
        localFragmentTransaction.commitAllowingStateLoss();
    }


    private void removeFragment() {
        if (this.mFragmentManager == null) {
            this.mFragmentManager = getSupportFragmentManager();
        }
        this.mFragmentManager.popBackStack();

    }

    @Override
    public void onBackPressed() {
        if (mBackHandedFragment == null || !mBackHandedFragment.onBackPressed()) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                super.onBackPressed();
            } else {
                removeFragment();
            }
        }
    }

    @Override
    public void setSelectedFragment(BackHandledFragment selectedFragment) {
        this.mBackHandedFragment = selectedFragment;
    }

    @Override
    public void onFragmentInteraction(String uri) {

        String intent = uri.toString();
        if (ATOB.equals(intent)) {
            addFragmentContent(FragmentB.newInstance("", ""));
        } else if (BTOC.equals(intent)) {
            addFragmentContent(FragmentC.newInstance("", ""));
        } else if (CTOD.equals(intent)) {
            addFragmentContent(FragmentD.newInstance("", ""));
        } else if (DTOA.equals(intent)) {
            addFragmentContent(FragmentA.newInstance("", ""));
        }
    }

    // CLEAR BACK STACK.
    private void clearBackStack() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        while (fragmentManager.getBackStackEntryCount() != 0) {
            fragmentManager.popBackStackImmediate();
        }
    }


}
