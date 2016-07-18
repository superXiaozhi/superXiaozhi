package com.fuyunxing.pad.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fuyunxing.pad.R;


/**
 * Description: (这里用一句话描述这个类的作用)
 * Author:veidy
 * Date: 2015-03-20
 * Time: 15:18
 */
public class FragmentLogin extends BackHandledFragment implements View.OnClickListener {
    private EditText et_username;//用户名
    private EditText et_pass;//密码
    private TextView tv_forgetpass;//忘记密码
    private Button btn_login;//登录
    private Button btn_cancle;//取消

    public static FragmentLogin newInstance(String param1, String param2) {
        FragmentLogin fragment = new FragmentLogin();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        et_username = (EditText) view.findViewById(R.id.et_username);
        et_pass = (EditText) view.findViewById(R.id.et_pass);
        tv_forgetpass = (TextView) view.findViewById(R.id.tv_forgetpass);
        btn_login = (Button) view.findViewById(R.id.btn_login);
        btn_cancle = (Button) view.findViewById(R.id.btn_cancle);
        btn_login.setOnClickListener(this);
        btn_cancle.setOnClickListener(this);
        tv_forgetpass.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_login:
                break;
            case R.id.btn_cancle:
                break;
            case R.id.tv_forgetpass:
                break;

        }
    }

    @Override
    public boolean onBackPressed() {
        return true;
    }
}
