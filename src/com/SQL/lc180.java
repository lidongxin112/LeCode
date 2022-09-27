package com.SQL;

/**
 *
 * 180. 连续出现的数字
 * SQL架构
 * 表：Logs
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | num         | varchar |
 * +-------------+---------+
 * id 是这个表的主键。
 *
 *
 * 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
 *
 * 返回的结果表中的数据可以按 任意顺序 排列。
 */

public class lc180 {

    /*
    select DISTINCT
    l.Num as ConsecutiveNums
    from Logs l1,
    Logs l2,
    Logs l3
    where
    l1.Id = l2.Id-1 AND
    l2.Id = l3.Id-1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num
     */

}
