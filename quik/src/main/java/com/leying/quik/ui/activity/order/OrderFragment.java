/**   
* @Title: OrderFragment.java
* @Package com.leying.quik.ui.activity.order
* @Description: TODO(用一句话描述该文件做什么)
* @author YangMingGuang
* @date 2015-12-22 下午10:50:19
* @version V1.0   
*/

package com.leying.quik.ui.activity.order;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leying.quik.R;
import com.leying.quik.publics.utils.ResourceUtil;
import com.leying.quik.ui.activity.base.BaseFragment;
import com.viewpagerindicator.TabPageIndicator;

/**
 * @ClassName: OrderFragment
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author YangMingGuang
 * @date 2015-12-22 下午10:50:19
*/

public class OrderFragment extends BaseFragment {

	private View rootView;
	private ViewPager mViewPager;
	private TabPageIndicator indicator;
	private MyFragmentPagerAdapter mFragmentPagerAdapter;

	public static Fragment newInstance(Bundle bundle) {
		OrderFragment fragment = new OrderFragment();
		if (bundle != null)
			fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.StyledIndicators);
		// clone the inflater using the ContextThemeWrapper
		LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
		rootView = localInflater.inflate(R.layout.fm_tab_order, container, false);
		//rootView = inflater.inflate(R.layout.fm_tab_order, null);
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
		tvTitle.setText(R.string.order_title);

		// ViewPager
		String[] titles = { ResourceUtil.getString(mActivity, R.string.tab_order_execute),
				ResourceUtil.getString(mActivity, R.string.tab_order_complete),
				ResourceUtil.getString(mActivity, R.string.tab_order_cancel) };
		mFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), titles);
		mViewPager = (ViewPager) rootView.findViewById(R.id.vpi_content_pager);
		mViewPager.setAdapter(mFragmentPagerAdapter);
		mViewPager.setOffscreenPageLimit(3);
		indicator = (TabPageIndicator) rootView.findViewById(R.id.vpi_indicator);
		indicator.setViewPager(mViewPager);
	}

	/**
	 * 
	 * @ClassName: MyFragmentPagerAdapter
	 * @Description: TODO(这里用一句话描述这个类的作用)
	 * @author YangMingGuang
	 * @date 2015-7-9 上午10:43:42
	 * 
	 */
	public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

		String titles[];

		public MyFragmentPagerAdapter(FragmentManager fm, String[] titles) {
			super(fm);
			this.titles = titles;
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = null;
			switch (position) {
			case 0:
				fragment = OrderExecuteFragment.newInstance(null);
				break;

			case 1:
				fragment = OrderCompleteFragment.newInstance(null);
				break;

			case 2:
				fragment = OrderCancelFragment.newInstance(null);
				break;

			default:
				break;

			}
			return fragment;
		}

		@Override
		public int getCount() {
			return titles.length;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}
	}
}
