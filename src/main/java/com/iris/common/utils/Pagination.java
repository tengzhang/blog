package com.iris.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 分页工具类
 * 
 * @author zhouxichao maya
 * 
 * @update qianqi yangbolin
 * @date 2010-5-11
 * 
 * 添加content
 * @update sundp
 * @date 2012-8-28
 */
@SuppressWarnings("unused")
public class Pagination {
	
	/**
	 * 返回内容，为了使两次查询变成一次查询而增加
	 */
	private Object content ;

    /**
     * 当前页数,默认为第一页
     */
    private int currentPage = 1;

    /**
     * 总记录条数
     */
    private int recordCount;

    /**
     * 总页数
     */
    private int pageCount;

    /**
     *  每页记录条数
     */
    private int pageSize;

    /**
     * 当前的页面的记录在总的记录中的起始位置
     */
    private int currentFristPosition; 

    /**
     * 根据当前页码 返回在当前页面下显示的其他页码列表(默认为当前页面的前3后3)
	 *	假设总共为100页
	 *	如当前是第四页 那么 列表的值为 {1，2，3，4，5，6，7}
	 *	如果当前页码为第9页 列表的值为{ 6, 7, 8, 9, 10, 11, 12 }
	* 如果当前页码为第98页 列表的值为{ 94, 95, 96, 97, 98, 99, 100 }
     */
    private List<Integer> pageList;

    /******************************* 构造函数 ****************************************/

    /**
     * 传入总记录数，传入每页显示条数，传入当前页码
     * @param recordCount 总记录条数
     * @param pageSize  每页记录条数
     * @param currentPage 当前的页面的记录在总的记录中的起始位置
     */
    public Pagination(int recordCount, int pageSize, int currentPage) {
        this.recordCount = recordCount;
        this.pageSize = pageSize;
        this.pageCount = calculatePageCount();
        this.currentPage = calculateCurrentPage(currentPage);
        this.pageList = calculatePageList();
        this.currentFristPosition = calculateRecordPosition();
        this.content = new Object();
    }

    /******************************* 构造函数 ****************************************/

    /**
     * 计算总页数
     * 
     * @return
     */
    public int calculatePageCount() {
        int pageCount = 1;
        if (recordCount % pageSize == 0) {
            pageCount = recordCount / pageSize;
        } else {
            pageCount = (int) (recordCount / pageSize) + 1;
        }
        pageCount = pageCount < 1 ? 1 : pageCount;
        return pageCount;
    }

    public int calculateRecordPosition() {
        return (currentPage - 1) * pageSize;
    }

    /**
     * 计算当前页码
     * 
     * @param currentPage
     * @return
     */
    private int calculateCurrentPage(int currentPage) {
        if (currentPage < 1) currentPage = 1;
        else if (currentPage > pageCount) currentPage = pageCount;
        return currentPage;
    }

    /**
     * 根据当前页码 返回在当前页面下显示的其他页码列表(默认为当前页面的前3后3) 假设总共为100页 如当前是第四页 那么 列表的值为
     * {1，2，3，4，5，6，7} 如果当前页码为第9页 列表的值为{ 6, 7, 8, 9, 10, 11, 12 }
     * 如果当前页码为第98页 列表的值为{ 94, 95, 96, 97, 98, 99, 100 } pageList
     * 
     * @return
     */
    private List<Integer> calculatePageList() {
        List<Integer> pageTmpList = new ArrayList<Integer>();
        if (pageCount < 7) {
            for (int i = 0; i < pageCount; i++) {
                pageTmpList.add(i + 1);
            }
        } else {
            if (currentPage < 4) {
                pageTmpList = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
            } else if (currentPage > pageCount - 4) {
                for (int i = pageCount - 6; i < pageCount + 1; i++) {
                    pageTmpList.add(i);
                }
            } else {
                pageTmpList = Arrays.asList(new Integer[] { currentPage - 3, currentPage - 2,
                        currentPage - 1, currentPage, currentPage + 1, currentPage + 2,
                        currentPage + 3 });
            }
        }
        return pageTmpList;
    }

    /********************** 首页，上一页，下一页，末页 *****************************/
    /**
     * 第一页
     */
    private int firstPage;

    /**
     * 上一页
     */
    private int prevPage;

    /**
     * 下一页
     */
    private int nextPage;

    /**
     * 最后一页
     */
    private int lastPage;

    public int getFirstPage() {
        return 1;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getPrevPage() {
        return currentPage > 1 ? (currentPage - 1) : 1;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getNextPage() {
        return currentPage < pageCount ? (currentPage + 1) : pageCount;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getLastPage() {
        return pageCount;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    /***************************************************************/

    public List<Integer> getPageList() {
        return pageList;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getCurrentFristPosition() {
        return currentFristPosition;
    }


	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public void setCurrentFristPosition(int currentFristPosition) {
        this.currentFristPosition = currentFristPosition;
    }
    public int getCurrentLastPosition(){
    	int curreentLast = currentFristPosition + pageSize;
    	if(curreentLast > recordCount){
    		return recordCount;
    	}
    	else{
    		return curreentLast;
    	}
    	
    }

}
