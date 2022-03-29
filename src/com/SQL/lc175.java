package com.SQL;

/**
 * 表1: Person
 * <p>
 * +-------------+---------+
 * | 列名         | 类型     |
 * +-------------+---------+
 * | PersonId    | int     |
 * | FirstName   | varchar |
 * | LastName    | varchar |
 * +-------------+---------+
 * PersonId 是上表主键
 * 表2: Address
 * <p>
 * +-------------+---------+
 * | 列名         | 类型    |
 * +-------------+---------+
 * | AddressId   | int     |
 * | PersonId    | int     |
 * | City        | varchar |
 * | State       | varchar |
 * +-------------+---------+
 * AddressId 是上表主键
 */
public class lc175 {
    /*
    SELECT a.FirstName,a.LastName,b.City,b.State
    from Person a left join Address b on a.PersonId = b.PersonId

     */
}
