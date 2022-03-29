package com.SQL;

public class lc626 {
    /**
     * 换座位
     *
     * 小美是一所中学的信息科技老师，她有一张 seat 座位表，平时用来储存学生名字和与他们相对应的座位 id。
     *
     * 其中纵列的id是连续递增的
     *
     * 小美想改变相邻俩学生的座位。
     */
    /*
SELECT
    (CASE
        WHEN MOD(id, 2) != 0 AND counts != id THEN id + 1
        WHEN MOD(id, 2) != 0 AND counts = id THEN id
        ELSE id - 1
    END) AS id,
    student
FROM
    seat,
    (SELECT
        COUNT(*) AS counts
    FROM
        seat) AS seat_counts
ORDER BY id ASC;

}
*/
}