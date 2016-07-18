package com.fuyunxing.pad.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.fuyunxing.pad.R;
import com.fuyunxing.pad.constant.Constant;


/**
 * Description: (这里用一句话描述这个类的作用)
 * Author:veidy
 * Date: 2015-03-20
 * Time: 15:18
 */
public class FragmentHos extends BackHandledFragment implements View.OnClickListener {
    private WebView webview_pub;
    private Button btn_yyjj;
    private Button btn_ksjs;
    private Button btn_msmy;
    private Button btn_zyzn;
    private Button btn_cyzn;
    private String title;

    private String URL_YYJJ = Constant.UrlIp + "flat/html/hospital/introduction.html";
    private String URL_KSJS = Constant.UrlIp + "flat/html/hospital/department.html";
    private String URL_MYMS = Constant.UrlIp + "flat/html/hospital/doctor.html";
    private String URL_ZYZN = Constant.UrlIp + "flat/html/hospital/hospitalguide.html";
    private String URL_CYZN = Constant.UrlIp + "flat/html/hospital/dischargeguide.html";
    private String webUrl = URL_YYJJ;

    // TODO: Rename and change types and number of parameters
    public static FragmentHos newInstance(String param1, String param2) {
        FragmentHos fragment = new FragmentHos();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hos, container, false);
        btn_yyjj = (Button) view.findViewById(R.id.btn_yyjj);
        btn_ksjs = (Button) view.findViewById(R.id.btn_ksjs);
        btn_msmy = (Button) view.findViewById(R.id.btn_msmy);
        btn_zyzn = (Button) view.findViewById(R.id.btn_zyzn);
        btn_cyzn = (Button) view.findViewById(R.id.btn_cyzn);
        btn_yyjj.setOnClickListener(this);
        btn_ksjs.setOnClickListener(this);
        btn_msmy.setOnClickListener(this);
        btn_zyzn.setOnClickListener(this);
        btn_cyzn.setOnClickListener(this);
        setselecter(btn_yyjj);
        webview_pub = (WebView) view.findViewById(R.id.webview_pub);
        // 设置WebView属性，能够执行Javascript脚本
        webview_pub.getSettings().setJavaScriptEnabled(true);

        // 设置不用webView缓存
        webview_pub.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        showWebView();
        return view;
    }

    private void setselecter(Button btn) {
        btn_yyjj.setSelected(false);
        btn_ksjs.setSelected(false);
        btn_msmy.setSelected(false);
        btn_zyzn.setSelected(false);
        btn_cyzn.setSelected(false);
        btn.setSelected(true);
    }

    private void showWebView() {
        // 加载需要显示的网页
        if (!TextUtils.isEmpty(webUrl)) {
            webview_pub.loadUrl(webUrl);
        }
        // 设置Web视图
        webview_pub.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url); // 在当前的webview中跳转到新的url;
                return true;
            }

        });
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_yyjj:
                setselecter(btn_yyjj);
                webUrl = URL_YYJJ;
                showWebView();
                break;
            case R.id.btn_ksjs:
                setselecter(btn_ksjs);
                webUrl = URL_KSJS;
                showWebView();
                break;
            case R.id.btn_msmy:
                setselecter(btn_msmy);
                webUrl = URL_MYMS;
                showWebView();
                break;
            case R.id.btn_zyzn:
                setselecter(btn_zyzn);
                webUrl = URL_ZYZN;
                showWebView();
                break;
            case R.id.btn_cyzn:
                setselecter(btn_cyzn);
                webUrl = URL_CYZN;
                showWebView();
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
