package com.fuyunxing.pad.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.fuyunxing.pad.R;
import com.fuyunxing.pad.xutils.sample.utils.PubUtils;
import com.fuyunxing.pad.xutils.view.ViewUtils;
import com.fuyunxing.pad.xutils.view.annotation.ViewInject;
import com.fuyunxing.pad.yinzldemo.VehicleActivity;

public class AboutActivity extends VehicleActivity {
	//
	@ViewInject(R.id.tv_version)
	private TextView tv_version;
	@ViewInject(R.id.tv_xieyi)
	private TextView tv_xieyi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		ViewUtils.inject(this);
		super.initTop();




		setTitle("关于");
		tv_version.setText(PubUtils.getAppVersionName(AboutActivity.this));

	}

}
