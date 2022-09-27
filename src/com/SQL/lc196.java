package com.SQL;

public class lc196 {
    /**
     * 删除重复的电子邮箱
     * 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
     */

    /*
    DELETE from Person
    where Id not in(
    Select Id from(
    Select MIN(id) as id from Person
    Group by Email
    )t
    )

     */
}
