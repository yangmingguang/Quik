package com.leying.quik;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.leying.quik.R;
import com.leying.quik.ui.activity.home.HomeFragment;
import com.leying.quik.ui.activity.mine.MineFragment;
import com.leying.quik.ui.activity.order.OrderFragment;

/**
 * @ClassName: MainActivity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author YangMingGuang
 * @date 2015-5-24 下午3:18:41
 */
public class MainActivity extends FragmentActivity {

	private Fragment mCurrentFragment, homeFragement, orderFragment, mineFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_main);
		initView();
	}

	/** 
	* @Title: initView 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param
	* @return void    返回类型 
	* @throws 
	*/
	private void initView() {
		RadioGroup mRgHost = (RadioGroup) findViewById(R.id.mf_tab_rg);
		mRgHost.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				// 首页
				case R.id.mf_home_tab_rb:
					if (null == homeFragement)
						homeFragement = HomeFragment.newInstance(null);
					switchFragments(homeFragement);
					break;

				// 订单
				case R.id.mf_order_tab_rb:
					if (null == orderFragment)
						orderFragment = OrderFragment.newInstance(null);
					switchFragments(orderFragment);
					break;

				// 我的
				case R.id.mf_mine_tab_rb:
					if (null == mineFragment)
						mineFragment = MineFragment.newInstance(null);
					switchFragments(mineFragment);
					break;

				default:
					break;
				}
			}
		});
		mRgHost.getChildAt(0).performClick();
	}

	/**
	 * 
	* @Title: switchFragments 
	* @Description: 切换当前fragment
	* @param @param homeFragement    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void switchFragments(Fragment fragment) {
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();
		if (mCurrentFragment == null && !fragment.isAdded()) {
			ft.add(R.id.fsh_content_fl, fragment, fragment.getClass().toString()).commitAllowingStateLoss();
		} else {
			if (fragment.isAdded()) {
				ft.hide(mCurrentFragment).show(fragment).commitAllowingStateLoss();
			} else {
				ft.hide(mCurrentFragment).add(R.id.fsh_content_fl, fragment, fragment.getClass().toString())
						.commitAllowingStateLoss();
			}
		}
		mCurrentFragment = fragment;
	}
}
