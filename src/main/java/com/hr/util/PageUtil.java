package com.hr.util;

import com.hr.entity.PageInfo;

public class PageUtil {
    //获取PageInfo对象
    public static PageInfo getPage(int pageSize , int rowCount, int pageIndex){
        PageInfo page = new PageInfo();

        page.setPageSize(pageSize);
        page.setPageIndex(pageIndex);
        page.setRowCount(rowCount);
        page.setBeginRow(pageSize*(pageIndex-1));
        page.setPageCount((rowCount+pageSize-1)/pageSize);
        page.setHasPre(!(rowCount==0 || pageIndex==1));   //判断是否有上一页
        page.setHasNext(!(pageIndex == page.getPageCount()));  //是否有下一页

        return page;
    }

}
