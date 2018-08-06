package com.demo.example.grpc.utils;

import com.demo.example.grpc.api.entity.PagingInfo;

/**
 * 分页工具类
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public class PagingUtil {

	/**
	 * 获取分页的开始位置
	 *
	 * @param pageNumber 页码
	 * @param pageSize   每页显示的条数
	 * @return
	 */
	public static int getStartNumber(int pageNumber, int pageSize) {
		if (pageNumber <= 0) {
			throw new IllegalArgumentException("当前页码一定得大于0");
		}
		if (pageSize <= 0) {
			throw new IllegalArgumentException("记录条数一定得大于0");
		}
		return pageNumber * pageSize - pageSize;
	}

	/**
	 * 获取总页数
	 *
	 * @param pageSize
	 * @param totalNumber
	 * @return
	 */
	public static int getTotalPage(int pageSize, int totalNumber) {
		int page = totalNumber / pageSize;
		return totalNumber % pageSize == 0 ? page : page + 1;
	}

	/**
	 * 获取App接口分页信息
	 *
	 * @param pageNumber
	 * @param pageSize
	 * @param totalCount
	 * @return
	 */
	public static PagingInfo getPagingInfo(int pageNumber, int pageSize, int totalCount) {
		// 分页大小
		int pageSizeNew = pageSize <= 0 ? 10 : pageSize;
		int totalPage = getTotalPage(pageSizeNew, totalCount);
		// 页码
		int pageNumberNew = pageNumber <= 0 ? 1 : pageNumber;

		PagingInfo.Builder pagingInfo = PagingInfo.newBuilder();
		pagingInfo.setPageNumber(pageNumberNew);
		pagingInfo.setPageSize(pageSizeNew);
		// 总页数
		pagingInfo.setTotalPage(totalPage);
		// 总条数
		pagingInfo.setTotalCount(totalCount);
		return pagingInfo.build();
	}
}
