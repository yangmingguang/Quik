/**   
* @Title: BaseFragment.java
* @Package com.leying.quik.ui.activity.base
* @Description: TODO(用一句话描述该文件做什么)
* @author YangMingGuang
* @date 2015-12-22 下午10:27:18
* @version V1.0   
*/

package com.leying.quik.ui.activity.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * @ClassName: BaseFragment
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author YangMingGuang
 * @date 2015-12-22 下午10:27:18
*/

public class BaseFragment extends Fragment {

	protected FragmentActivity mActivity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivity = this.getActivity();
	}
}
