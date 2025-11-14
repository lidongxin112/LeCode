package com.SQL;

/**
 * 177. 第N高的薪水
 * SQL架构
 * 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
 *
 * +----+--------+
 * | Id | Salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 */
public class lc177 {
   /*
   CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N :=N-1;
  RETURN (
  select
   salary
  from
   employee
   group by salary
   order by salary desc
   limit N,1
  );
END
    */


    /**
     *    CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
     * BEGIN
     *   RETURN (
     *   select distinct e.salary
     *   from employee e
     *   where
     *   (select count(DISTINCT salary) from employee where salary>e.salary) = N -1
     *   );
     * END
     */


    /*
       CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
  select
  e1.salary
  from
  employee e1 JOIN employee e2 on e1.salary > e2.salary
  group by
  e1.salary
  Having
  count(DISTINCT e2.salary) = N
  );
END
     */

    /**
     *
     *   CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
     * BEGIN
     *   RETURN (
     *   select
     *   e1.salary
     *   from
     *   employee e1,employee e2
     *   where
     *   e1.salary<=e2.salary
     *   group by
     *   e1.salary
     *   HAVING
     *   count(DISTINCT e2.salary) = N
     *   );
     * END
     *
     */
}
