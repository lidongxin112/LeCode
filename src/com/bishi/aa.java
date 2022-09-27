package com.bishi;

import java.util.*;

public class aa {

    public static double  aa(double a,double b){
        double c = 200;
        for (int i=0;i<10;i++){
            c /= 2;
        }
        System.out.println(c);
        double [] a1 = new double[(int) (b+1)];
        a1[1] = 200;
        for(int i=2;i<=b;i++){
            a1[i] = a1[i-1] / 2;
        }
        return a1[(int) b+1];
    }

    public static void main(String[] args) {
        double height = 200;
        int n = 10;
        int mi = 200;
        for (int i=0;i<10;i++){
            height /= 2;
            mi += 2 * height;
        }
        mi -= height;
        System.out.println(height);
        System.out.println(mi);
        }
        /*
        0.1953125
        0.390625
         */

    /***
     *
     *
     *

      select a.s_name as Student
      from Student a where a.s_id =( select s.s_id as Score
            from Score s where s.c_id != (select c.c_id as Course from Course c
            where c.t_id = (select b.t_id as Teacher from Teacher b where b.t_name = "张三"))
      ) order by a_s_id desc;
     *
     *
     *
     */
}
