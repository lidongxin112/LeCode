package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 638. 大礼包
 * 在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 *
 * 给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。另有一个整数数组 needs 表示购物清单，其中 needs[i] 是需要购买第 i 件物品的数量。
 *
 * 还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。
 *
 * 返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
 *
 *
 */
public class lc638 {
        private int min = Integer.MAX_VALUE;
        private List<Integer> price;
        private List<List<Integer>> special;

        public int shoppingOffers(List<Integer> _price, List<List<Integer>> _special, List<Integer> needs) {
            this.price = _price;
            this.special = _special;
            dfs(needs,0);
            return min;
        }

        public void dfs(List<Integer> needs,int money){
            //尝试每一种大礼包，看看哪一种符合就用哪一种
            for(int i = 0; i < special.size(); ++i){
                List<Integer> list = special.get(i);
                List<Integer> cur = new ArrayList<>();
                for(int j = 0; j < list.size(); ++j){
                    if(j==list.size()-1){
                        dfs(cur,money+list.get(j));
                    }else{
                        int num = needs.get(j);
                        if(num<list.get(j)) break;
                        cur.add(num-list.get(j));
                    }
                }
            }
            //走到这里说明没有符合的大礼包了，直接减去每个的单价就行
            int m = money;
            for(int i = 0; i < needs.size(); ++i){
                m += needs.get(i)*price.get(i);
            }
            min = Math.min(min,m);
        }
    }