/**   
* @Title: HomeFragment.java
* @Package com.leying.quik.ui.activity.home
* @Description: TODO(用一句话描述该文件做什么)
* @author YangMingGuang
* @date 2015-12-22 下午10:37:29
* @version V1.0   
*/

package com.leying.quik.ui.activity.home;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leying.quik.R;
import com.leying.quik.publics.model.BannerInfoBean;
import com.leying.quik.publics.utils.ToastUtil;
import com.leying.quik.ui.activity.base.BaseFragment;
import com.leying.quik.ui.activity.mine.SettingsActivity;
import com.leying.quik.ui.views.viewflow.BannerViewFlow;

/**
 * @ClassName: HomeFragment
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author YangMingGuang
 * @date 2015-12-22 下午10:37:29
*/

public class HomeFragment extends BaseFragment implements OnClickListener {

	private View rootView;
	private BannerViewFlow bannerViewFlow;
	private static final int[] btns = { R.id.tv_city, R.id.btn_menu_settings, R.id.btn_send, R.id.btn_receive };

	public static Fragment newInstance(Bundle bundle) {
		HomeFragment fragment = new HomeFragment();
		if (bundle != null)
			fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fm_tab_home, null);
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
		TextView tvTitle = (TextView) rootView.findViewById(R.id.tv_title);
		tvTitle.setText(R.string.home_title);
		rootView.findViewById(R.id.tv_city).setVisibility(View.VISIBLE);
		rootView.findViewById(R.id.btn_menu_settings).setVisibility(View.VISIBLE);
		bannerViewFlow = new BannerViewFlow(mActivity, rootView, R.id.fb_viewflow, R.id.fb_viewflowindic, null);

		for (int btn : btns)
			rootView.findViewById(btn).setOnClickListener(this);

		// test 
		List<BannerInfoBean> list = new ArrayList<BannerInfoBean>();
		BannerInfoBean bean = new BannerInfoBean(1,
				"http://img2.imgtn.bdimg.com/it/u=3105248416,2364233462&fm=21&gp=0.jpg", "");
		BannerInfoBean bean1 = new BannerInfoBean(2,
				"http://img5.imgtn.bdimg.com/it/u=1552850494,2926593515&fm=21&gp=0.jpg", "");
		BannerInfoBean bean2 = new BannerInfoBean(2,
				"http://img2.imgtn.bdimg.com/it/u=2191300738,1017108688&fm=21&gp=0.jpg", "");
		list.add(bean);
		list.add(bean1);
		list.add(bean2);
		bannerViewFlow.creatMyViewFlow(list);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_city:
			ToastUtil.show(mActivity, "深圳", ToastUtil.LENGTH_SHORT);
			break;

		case R.id.btn_menu_settings:
			startActivity(new Intent(mActivity, SettingsActivity.class));
			break;

		case R.id.btn_send:
			ToastUtil.show(mActivity, R.string.send_order_text, ToastUtil.LENGTH_SHORT);
			break;

		case R.id.btn_receive:
			ToastUtil.show(mActivity, R.string.receive_order_text, ToastUtil.LENGTH_SHORT);
			break;

		default:
			break;
		}

	}

}
