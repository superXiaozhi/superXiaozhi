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
public class FragmentHelp extends BackHandledFragment implements View.OnClickListener {
    private WebView webview_pub;
    private Button btn_sybz;
    private Button btn_ywwt;
    private Button btn_zxbz;
    private Button btn_qt;
    private Button btn_tab5;
    private String title;

    private String URL_SYBZ = Constant.UrlIp + "flat/html/hospital/introduction.html";

    private String webUrl = URL_SYBZ;

    // TODO: Rename and change types and number of parameters
    public static FragmentHelp newInstance(String param1, String param2) {
        FragmentHelp fragment = new FragmentHelp();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help, container, false);
        btn_sybz = (Button) view.findViewById(R.id.btn_sybz);
        btn_ywwt = (Button) view.findViewById(R.id.btn_ywwt);
        btn_zxbz = (Button) view.findViewById(R.id.btn_zxbz);
        btn_qt = (Button) view.findViewById(R.id.btn_qt);
        btn_tab5 = (Button) view.findViewById(R.id.btn_tab5);
        btn_sybz.setOnClickListener(this);
        btn_ywwt.setOnClickListener(this);
        btn_zxbz.setOnClickListener(this);
        btn_qt.setOnClickListener(this);
        btn_tab5.setOnClickListener(this);
        setselecter(btn_sybz);
        webview_pub = (WebView) view.findViewById(R.id.webview_pub);
        // 设置WebView属性，能够执行Javascript脚本
        webview_pub.getSettings().setJavaScriptEnabled(true);

        // 设置不用webView缓存
        webview_pub.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        showWebView();
        return view;
    }

    private void setselecter(Button btn) {
        btn_sybz.setSelected(false);
        btn_ywwt.setSelected(false);
        btn_zxbz.setSelected(false);
        btn_qt.setSelected(false);
        btn_tab5.setSelected(false);
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
            case R.id.btn_sybz:
                setselecter(btn_sybz);
                webUrl = "http://sports.sina.com.cn/";
                showWebView();
                break;
            case R.id.btn_ywwt:
                setselecter(btn_ywwt);
                webUrl = "http://2016.sina.com.cn/";
                showWebView();
                break;
            case R.id.btn_zxbz:
                setselecter(btn_zxbz);
                webUrl = "https://www.tmall.com/";
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
