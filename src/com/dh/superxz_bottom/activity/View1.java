package com.dh.superxz_bottom.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.dh.superxz_bottom.R;

public class View1 extends Activity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view1);

        editText = (EditText) findViewById(R.id.editText1);
    }

    @Override
    protected void onResume() {
        editText.clearFocus();
        super.onResume();
    }

}
