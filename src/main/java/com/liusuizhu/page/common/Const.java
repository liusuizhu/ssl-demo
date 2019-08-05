package com.liusuizhu.page.common;

/**
 *公共的静态常量类
 * @author John Liu
 */
public final class Const {

	public static final String OLDCAR_LIST_IMG = "?x-oss-process=image/resize,m_fill,h_200,w_284/format,png";

	public static final String OLDCAR_QUERY_IMG = "?x-oss-process=image/resize,m_fill,h_386,w_580/format,png";

	public static final int PARKING_TYPE_INTO = 0; // 驶入驶出类型：进场

	public static final int PARKING_TYPE_OUT = 1; // 驶入驶出类型：出场

	public interface RedisString {
		//设置数据字典缓存时间

		//设置redis 键名

	}
	
	public interface string {

		String MSG_ERROR_PARKING_INTO_ADD = "车辆进场添加失败！";

		String MSG_ERROR_PARKING_OUT_ADD = "车辆出场添加失败！";

		String MSG_ERROR_PARKING_ADD = "停车场信息添加失败！";

		String MSG_EXCEPTION_PARKING_ADD = "未能插入数据！";

	}
}