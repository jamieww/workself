package com.demo.example.grpc.bl.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 后端费率结算方式常量
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public class BackSettlementWayConstant {
	/**
	 * 未定义
	 */
	public static final int NON = 0;
	/**
	 * 成立结算
	 */
	public static final int ESTABLISH_SETTLEMENT = 1;
	/**
	 * 项目募满结算
	 */
	public static final int RAISE_FULL_SETTLEMENT = 2;

	public static final Map<Integer, String> BACK_SETTLEMENT_WAY_DESC_MAP;

	static {
		Map map = new HashMap<Integer, String>();
		map.put(NON, "未定义");
		map.put(ESTABLISH_SETTLEMENT, "成立结算");
		map.put(RAISE_FULL_SETTLEMENT, "项目募满结算");
		BACK_SETTLEMENT_WAY_DESC_MAP = Collections.unmodifiableMap(map);
	}
}
