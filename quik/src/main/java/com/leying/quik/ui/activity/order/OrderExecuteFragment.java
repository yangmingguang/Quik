/**   
* @Title: OrderExecuteFragment.java
* @Package com.leying.quik.ui.activity.order
* @Description: TODO(用一句话描述该文件做什么)
* @author YangMingGuang
* @date 2015-12-22 下午10:37:29
* @version V1.0   
*/

package com.leying.quik.ui.activity.order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leying.quik.R;
import com.leying.quik.ui.activity.base.BaseFragment;

/**
 * @ClassName: OrderExecuteFragment
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author YangMingGuang
 * @date 2015-12-22 下午10:37:29
*/

public class OrderExecuteFragment extends BaseFragment {

	private View rootView;

	public static Fragment newInstance(Bundle bundle) {
		OrderExecuteFragment fragment = new OrderExecuteFragment();
		if (bundle != null)
			fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fm_order_common, null);
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

	}

}
