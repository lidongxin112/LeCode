package com.SQL;

public class lc197 {
    /**
     * 上升的温度
     * 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。
     */
    /*
    SELECT a.id
    from Weather a,Weather b as
    where a.Temperature > b.Temperature
    and DATEDIFF(w2.RecordDate, w1.RecordDate) = 1
     */

    //DATEDIFF 比较两个日期之间的差值
}
