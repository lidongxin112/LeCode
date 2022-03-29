package com.SQL;

/**
 * 627. 变更性别
 * SQL架构
 * Salary 表：
 *
 * +-------------+----------+
 * | Column Name | Type     |
 * +-------------+----------+
 * | id          | int      |
 * | name        | varchar  |
 * | sex         | ENUM     |
 * | salary      | int      |
 * +-------------+----------+
 * id 是这个表的主键。
 * sex 这一列的值是 ENUM 类型，只能从 ('m', 'f') 中取。
 * 本表包含公司雇员的信息。
 */
public class lc627 {
    /*
    update Salary set sex = if(sex='m','f','m')
     */
}
