/**   
* @Title: MyApplication.java
* @Package com.yj.ecard
* @Description: TODO(用一句话描述该文件做什么)
* @author YangMingGuang
* @date 2015-5-24 下午3:18:41
* @version V1.0   
*/

package com.leying.quik;

import android.app.Application;
import android.content.Context;

import com.leying.quik.publics.utils.ImageLoaderUtil;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
* @ClassName: MyApplication
* @Description: TODO(这里用一句话描述这个类的作用)
* @author YangMingGuang
* @date 2015-5-24 下午3:18:41
* 
*/
public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		initUIL(this);
	}

	/**
	 * 
	* @Title: initUIL 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param context    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void initUIL(Context context) {
		// This configuration tuning is custom. You can tune every option, you may tune some of them,
		// or you can create default configuration by
		//  ImageLoaderConfiguration.createDefault(this);
		// method.
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
				.threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO)
				.memoryCache(new LruMemoryCache(ImageLoaderUtil.calculateMemoryCacheSize(context))).threadPoolSize(5)
				/*.memoryCache(new WeakMemoryCache())*/
				.discCacheFileCount(100).memoryCacheSize(ImageLoaderUtil.calculateMemoryCacheSize(context))
				.discCacheSize(50 * 1024 * 1024).memoryCacheExtraOptions(320, 480)/*.writeDebugLogs()*/// Remove for release app
				.build();
		ImageLoader.getInstance().init(config);
	}

}
