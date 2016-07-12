package com.fuyunxing.pad.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.fuyunxing.pad.R;
import com.fuyunxing.pad.activity.LoginActivity;
import com.fuyunxing.pad.event.ApptestEvent;
import com.fuyunxing.pad.event.EventBus;
import com.fuyunxing.pad.xutils.view.ViewUtils;
import com.fuyunxing.pad.xutils.view.annotation.ViewInject;
import com.fuyunxing.pad.xutils.view.annotation.event.OnClick;
import com.fuyunxing.pad.yinzldemo.DatePickerActivity;
import com.fuyunxing.pad.yinzldemo.EventBusActivity;
import com.fuyunxing.pad.yinzldemo.VehicleFragment;


/**
 * @author 超级小志
 *
 */
public class EventBusFragment extends VehicleFragment {

	// private HttpHandler handler;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.event_fragment, container, false);
		ViewUtils.inject(this, view);
		// 注册订阅事件
		if (null != EventBus.getDefault()) {
			EventBus.getDefault().unregister(this);
		}
		EventBus.getDefault().register(this);

		return view;
	}

	@ViewInject(R.id.download_addr_edit)
	private EditText downloadAddrEdit;

	@ViewInject(R.id.download_btn)
	private Button downloadBtn;
	
	@ViewInject(R.id.btn_date_picker)
	private Button btn_date_picker;
	
	@ViewInject(R.id.btn_login)
	private Button btn_login;
	
	
	
	@OnClick(R.id.btn_date_picker)
	public void showDatePicker(View view) {
		Intent intent = new Intent(this.getActivity(), DatePickerActivity.class);
		this.getActivity().startActivity(intent);
	}
	
	@OnClick(R.id.download_btn)
	public void download(View view) {
		Intent intent = new Intent(this.getActivity(), EventBusActivity.class);
		this.getActivity().startActivity(intent);
	}
	@OnClick(R.id.btn_login)
	public void onClickLogin(View view) {
		Intent intent = new Intent(this.getActivity(), LoginActivity.class);
		this.getActivity().startActivity(intent);
	}
	

	public void onEventMainThread(ApptestEvent event) {
		System.out.println("onEventMainThread:"
				+ Thread.currentThread().getId());
		if (event.getType() == ApptestEvent.TEST) {
			Log.e("yinzl", "apptestevent 接受");
			if (!TextUtils.isEmpty(event.getStr()))
				downloadAddrEdit.setText(event.getStr());
		}
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		// 注销订阅事件
		EventBus.getDefault().unregister(this);
		super.onDestroy();
	}
	public void refreshData(boolean showDialog) {
	}
}
