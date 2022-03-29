package com.SQL;

public class lc181 {
    /*
    select a.name as Employee
    from employee a,employee b
    where a.ManagerId=b.id
    and a.Salary>b.Salary

    select a.name as Employee
    From employee a
    where salary>(select salary from employee where Id = a.ManagerId)
     */
    public static void main(String[] args) {
         System.out.println(Integer.parseInt(String.valueOf('.')));



    }
}
