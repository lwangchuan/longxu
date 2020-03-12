package Junit;

import likou.PuKe;
import org.junit.Test;

import java.sql.SQLOutput;


public class PuKeTest {
    @Test
    public void test(){
        PuKe pk = new PuKe();
        System.out.println(pk.puke("3D 4D 5D 6D 7D","5S 6S 7S 8S 9S TS"));//同花顺  White win!
        System.out.println(pk.puke("6D 6S 6H 6C AD","8D 8S 8H 9C 8C"));//铁支 White win!
        System.out.println(pk.puke("9D 9S 9C JS JD","7S 7D 7C KS KD"));//葫芦 Black win!
        System.out.println(pk.puke("4D 2D AD 8D 5D","9S KS 2S 6S 5S"));//同花  Black win!
        System.out.println(pk.puke("4S 5D 6C 7D 8S","4D 5S 6H 7C 8D"));//顺子 Tie！
        System.out.println(pk.puke("JD JS JH AD KS","4D 4S 4H 8C 9D"));//三条 Black win!
        System.out.println(pk.puke("AD AS 3D 3H 5C","TD TH 7C 7H 8S"));//两对 Black win!
        System.out.println(pk.puke("6D 6H AS 4D 8C","3H 3D 2S 9C KS"));//对子 Black win!
        System.out.println(pk.puke("2S 3D 4H 5C 8S","2D 3S 4S 5D 8H"));//散牌 Tie!
        System.out.println(pk.puke("3D 4D 5D 6D 7D","4H 5S 6H 7C 8D"));//同花顺 vs 顺子 Black win!
        System.out.println(pk.puke("TD TH 7C 7H 8S","6D 6S 6H 6C AD"));//两对 vs 铁支 White win!
        System.out.println(pk.puke("AD 3H 3S 4D 8C","7S 7D 7C KS KD"));//对子 vs 葫芦 White win!
        System.out.println(pk.puke("2S 3D 4H 5C 8S","9S KS 7S 6S 5S"));//散牌 vs 同花 White win!
        System.out.println(pk.puke("5D JS 2H AD KS","6H 6D 2S 9C KH"));//散牌 vs 对子 White win!
    }
}
