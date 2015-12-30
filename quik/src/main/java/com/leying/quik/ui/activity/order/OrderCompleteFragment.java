/**   
* @Title: OrderCompleteFragment.java
* @Package com.leying.quik.ui.activity.order
* @Description: TODO(用一句话描述该文件做什么)
* @author YangMingGuang
* @date 2015-12-22 下午10:37:29
* @version V1.0   
*/

package com.leying.quik.ui.activity.order;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * @ClassName: OrderCompleteFragment
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author YangMingGuang
 * @date 2015-12-22 下午10:37:29
*/

public class OrderCompleteFragment extends OrderExecuteFragment {

	public static Fragment newInstance(Bundle bundle) {
		OrderCompleteFragment fragment = new OrderCompleteFragment();
		if (bundle != null)
			fragment.setArguments(bundle);
		return fragment;
	}

}
