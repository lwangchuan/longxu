package likou;

import java.util.Scanner;

public class PuKe {
    public String puke(String black, String white) {
        String[] str1 = black.split(" ");
        char[] num1 = new char[5];
        char[] char1 = new char[5];
        for (int i = 0; i < 5; i++) {
            num1[i] = (str1[i].charAt(0));
            char1[i] = str1[i].charAt(1);
        }

        String[] str2 = white.split(" ");
        char[] num2 = new char[5];
        char[] char2 = new char[5];
        for (int i = 0; i < 5; i++) {
            num2[i] = (str2[i].charAt(0));
            char2[i] = str2[i].charAt(1);
        }

        int[] select1 = Type.select(num1, char1);
        int[] select2 = Type.select(num2, char2);
        int i, j;
        for (i = 0; i < select1.length; i++) {
            if (select1[i] == 1)
                break;
        }
        for (j = 0; j < select2.length; j++) {
            if (select2[j] == 1)
                break;
        }
        int result = Compare.compare(i, j, num1, num2);
        String pk;
        if (result == 1)
            pk = "Black win!";
        else if (result == 2)
            pk = "White win!";
        else
            pk = "Tie!";
        return pk;

    }
}
