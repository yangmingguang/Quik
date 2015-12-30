/**   
* @Title: SettingsActivity.java
* @Package com.leying.quik.ui.activity.mine
* @Description: TODO(用一句话描述该文件做什么)
* @author YangMingGuang
* @date 2015-12-26 下午10:56:05
* @version V1.0   
*/

package com.leying.quik.ui.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.leying.quik.R;
import com.leying.quik.publics.utils.ToastUtil;
import com.leying.quik.ui.activity.base.BaseActivity;

/**
 * @ClassName: SettingsActivity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author YangMingGuang
 * @date 2015-12-26 下午10:56:05
*/

public class SettingsActivity extends BaseActivity implements OnClickListener {

	private static final int[] btns = { R.id.btn_modify_password, R.id.btn_clear_cache, R.id.btn_about, R.id.btn_exit };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_settings);

		for (int btn : btns) {
			findViewById(btn).setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_modify_password:
			ToastUtil.show(context, R.string.modify_password, ToastUtil.LENGTH_SHORT);
			break;

		case R.id.btn_clear_cache:
			ToastUtil.show(context, R.string.clear_cache, ToastUtil.LENGTH_SHORT);
			break;

		case R.id.btn_about:
			ToastUtil.show(context, R.string.about, ToastUtil.LENGTH_SHORT);
			break;

		case R.id.btn_exit:
			ToastUtil.show(context, R.string.exit, ToastUtil.LENGTH_SHORT);
			break;

		default:
			break;
		}

	}

}
