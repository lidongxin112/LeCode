package com.SQL;


public class lc596 {
    /*
    SELECT
    class
    FROM
    (SELECT
     class,count(DISTINCT student) AS num
     FROM
     courses
     GROUP BY class)AS temp_table
     WHERE
     num>=5;


     SELECT
     class
     FROM
     courses
     GROUP BY class
     HAVING COUNT(DISTINCT student) >= 5
     */
}
