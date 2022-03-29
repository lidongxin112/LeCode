package simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 299. 猜数字游戏
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * <p>
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 * <p>
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 * <p>
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 * <p>
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 *
 * @author 东鑫
 */
/*
hash 统计出现的次数
 */
public class lc299 {
    public String getHint(String secret, String guess) {
        int num1 = 0;
        int num2 = 0;
        int[] aa = new int[10];
        int[] bb = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                num1++;
            } else {
                ++aa[secret.charAt(i)- '0'];
                ++bb[guess.charAt(i)- '0'];
            }
        }

        for (int i=0;i<10;i++){
            num2+= Math.min(aa[i],bb[i]);
        }
        String sa = num1 + "A" + num2 + "B";

        return sa;
    }

    public static void main(String[] args) {
        String sercet = "1122";
        String guess = "0001";
        String hint = new lc299().getHint(sercet, guess);
        System.out.println(hint);
    }
}
