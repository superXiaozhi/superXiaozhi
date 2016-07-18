package com.fuyunxing.pad.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fuyunxing.pad.R;
import com.fuyunxing.pad.fragment.BackHandledFragment;
import com.fuyunxing.pad.fragment.BaseFragment;
import com.fuyunxing.pad.fragment.FragmentA;
import com.fuyunxing.pad.fragment.FragmentB;
import com.fuyunxing.pad.fragment.FragmentC;
import com.fuyunxing.pad.fragment.FragmentD;
import com.fuyunxing.pad.fragment.FragmentHelp;
import com.fuyunxing.pad.fragment.FragmentHome;
import com.fuyunxing.pad.fragment.FragmentHos;
import com.fuyunxing.pad.fragment.FragmentLogin;


public class HomeActivity extends FragmentActivity implements BaseFragment.OnFragmentInteractionListener, BackHandledFragment.BackHandledInterface {

    public FragmentManager mFragmentManager;

    //定义四条路径
    public final static String ATOB = "atob";
    public final static String BTOC = "btoc";
    public final static String CTOD = "ctod";
    public final static String DTOA = "dtoa";


    public final static String FRAGMENT_HOME_YYXX = "fragmet_yyxx";//主页的医院信息
    public final static String FRAGMENT_HOME_PERSONMSG = "fragmet_personmsg";//主页病人信息


    public final static String FRAGMENT_HOME_HOME = "fragmet_home";//主页
    public final static String FRAGMENT_HOME_HELP = "fragmet_help";//帮助
    public final static String FRAGMENT_HOME_SETTING = "fragmet_setting";//设置

    public final static String FRAGMENT_HOME_LOGIN = "fragmet_login";//主页的医院信息

    private BackHandledFragment mBackHandedFragment;
    private TextView tv_home_home;
    private TextView tv_home_setting;
    private TextView tv_home_help;
    private Button btn_login;//登录

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addFragmentContent(FragmentHome.newInstance("", ""));
        tv_home_home = (TextView) findViewById(R.id.tv_home_home);
        tv_home_setting = (TextView) findViewById(R.id.tv_home_setting);
        tv_home_help = (TextView) findViewById(R.id.tv_home_help);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addFragmentContent(FragmentLogin.newInstance("", ""));
            }
        });
        tv_home_home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addFragmentContent(FragmentHome.newInstance("", ""));
            }
        });
        tv_home_help.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addFragmentContent(FragmentHelp.newInstance("", ""));
            }
        });
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
        } else if (FRAGMENT_HOME_YYXX.equals(intent)) {
            addFragmentContent(FragmentHos.newInstance("", ""));
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
