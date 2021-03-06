package com.fuyunxing.pad.yinzldemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fuyunxing.pad.R;
import com.fuyunxing.pad.event.ApptestEvent;
import com.fuyunxing.pad.event.EventBus;
import com.fuyunxing.pad.xutils.sample.utils.Preference;
import com.fuyunxing.pad.xutils.sample.utils.ToastUtil;
import com.fuyunxing.pad.xutils.view.ViewUtils;
import com.fuyunxing.pad.xutils.view.annotation.ViewInject;
import com.fuyunxing.pad.xutils.view.annotation.event.OnClick;

/**
 * Author: wyouflf Date: 13-10-9 Time: 下午5:26
 */
public class EventBusActivity extends VehicleActivity {

	@ViewInject(R.id.et_input)
	private EditText et_input;
	@ViewInject(R.id.btn_ok)
	private Button btn_ok;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		ViewUtils.inject(this);
		super.initTop();
		setTitle("eventbus");
		Preference.putString("test_shareprefence", "哈哈，shareprefence是这么用的");
		Preference.getString("test_shareprefence");
		if (!TextUtils.isEmpty(Preference.getString("test_shareprefence"))) {
			ToastUtil.showLong(EventBusActivity.this,
					Preference.getString("test_shareprefence"));
		}

	}

	@OnClick(R.id.btn_ok)
	public void postEvent(View view) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				// 推送一个事件
				ApptestEvent appevent = new ApptestEvent(1);
				String str = et_input.getText().toString().trim();
				if (TextUtils.isEmpty(str))
					appevent.setStr("你倒是写点文字呀");
				else
					appevent.setStr(str);
				EventBus.getDefault().post(appevent);

			}
		}).start();
		this.finish();
	}
}