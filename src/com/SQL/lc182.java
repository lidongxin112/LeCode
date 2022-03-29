package com.SQL;

public class lc182 {

    /*
    1.
    select Email from Person group by Email having count(Email)>1
    2.
    select email from (select count(1) as a.email from)

    3.
    select distinct (a.email) from Person a join Person b on b.email = a.email AND b.Id != a.Id
     */
}
