/**   
* @Title: MineFragment.java
* @Package com.leying.quik.ui.activity.mine
* @Description: TODO(用一句话描述该文件做什么)
* @author YangMingGuang
* @date 2015-12-22 下午10:43:57
* @version V1.0   
*/

package com.leying.quik.ui.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.leying.quik.R;
import com.leying.quik.publics.utils.ToastUtil;
import com.leying.quik.ui.activity.base.BaseFragment;

/**
 * @ClassName: MineFragment
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author YangMingGuang
 * @date 2015-12-22 下午10:43:57
*/

public class MineFragment extends BaseFragment implements OnClickListener {

	private View rootView;
	private static final int[] btns = { R.id.iv_header, R.id.btn_apply_quiker, R.id.btn_order_manager,
			R.id.btn_message, R.id.btn_settings, R.id.btn_feedback, R.id.btn_check_version };

	public static Fragment newInstance(Bundle bundle) {
		MineFragment fragment = new MineFragment();
		if (bundle != null)
			fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fm_tab_mine, null);
		initView();
		return rootView;
	}

	/** 
	* @Title: initView 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	private void initView() {
		for (int btn : btns) {
			rootView.findViewById(btn).setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_header:
			ToastUtil.show(mActivity, "header", ToastUtil.LENGTH_SHORT);
			break;

		case R.id.btn_apply_quiker:
			ToastUtil.show(mActivity, R.string.apply_quiker_title, ToastUtil.LENGTH_SHORT);
			break;

		case R.id.btn_order_manager:
			ToastUtil.show(mActivity, R.string.order_manager_title, ToastUtil.LENGTH_SHORT);
			break;

		case R.id.btn_message:
			ToastUtil.show(mActivity, R.string.message_title, ToastUtil.LENGTH_SHORT);
			break;

		case R.id.btn_settings:
			startActivity(new Intent(mActivity, SettingsActivity.class));
			break;

		case R.id.btn_feedback:
			ToastUtil.show(mActivity, R.string.feedback_title, ToastUtil.LENGTH_SHORT);
			break;

		case R.id.btn_check_version:
			ToastUtil.show(mActivity, R.string.check_version, ToastUtil.LENGTH_SHORT);
			break;

		default:
			break;
		}

	}
}
