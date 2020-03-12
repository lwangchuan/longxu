package likou;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Compare {
    public static int compare(int m, int n, char[] num1,  char[] num2) {
    //black->1, white->2, 平局->3
        if (m < n)
            return 1;
        else if (m > n)
            return 2;
        int[] nums1 = new int[5];
        for (int i = 0; i < num1.length; i++) {
            if(num1[i]=='T')
                nums1[i] = 10;
            else if(num1[i]=='J')
                nums1[i] = 11;
            else if(num1[i]=='Q')
                nums1[i] = 12;
            else if(num1[i]=='K')
                nums1[i] = 13;
            else if(num1[i]=='A')
                nums1[i] = 14;
            else
                nums1[i] = num1[i] - 48;
        }
        Arrays.sort(nums1);

        int[] nums2 = new int[5];
        for (int i = 0; i < num1.length; i++) {
            if(num2[i]=='T')
                nums2[i] = 10;
            else if(num2[i]=='J')
                nums2[i] = 11;
            else if(num2[i]=='Q')
                nums2[i] = 12;
            else if(num2[i]=='K')
                nums2[i] = 13;
            else if(num2[i]=='A')
                nums2[i] = 14;
            else
                nums2[i] = num2[i] - 48;
        }
        Arrays.sort(nums2);

        //同花顺，顺子
        if(m==0 || m==4){
            if(nums1[4] > nums2[4])
                return 1;
            else if(nums1[4] < nums2[4])
                return 2;
            else
                return 3;

        }
        //铁支
        else if(m==1){
            if(nums1[1] > nums2[1])
                return 1;
            else
                return 2;
        }
        //葫芦, 三条
        else if(m==2 || m==5){
            if(nums1[2] > nums2[2])
                return 1;
            else
                return 2;
        }
        //同花
        else if(m==3){
            for(int i=4; i>=0; i--){
                if(nums1[i] > nums2[i])
                    return 1;
                else if(nums1[i] < nums2[i])
                    return 2;
            }
            return 3;
        }
        //两对
        else if(m==6){
            Set<Integer> set3 = new HashSet<>();
            Set<Integer> set4 = new HashSet<>();
            Set<Integer> set5 = new HashSet<>();
            Set<Integer> set6 = new HashSet<>();
            int c=0, d=0, e=0, f=0, g=0, h=0;
            for(int i= 4; i >1; i--){
                if(set3.contains(nums1[i]))
                    c = nums1[i];
                if(set4.contains(nums2[i]))
                    d = nums2[i];
                set3.add(nums1[i]);
                set4.add(nums2[i]);
            }
            if(c > d)
                return 1;
            else if(c < d)
                return 2;
            else{
                for(int i=0; i<2; i++){
                    if(set5.contains(nums1[i]))
                        e = nums1[i];
                    if(set6.contains(nums2[i]))
                        f = nums2[i];
                    set5.add(nums1[i]);
                    set6.add(nums2[i]);
                }
                if(e > f)
                    return 1;
                else if(e < f)
                    return 2;
                else{
                    for(int i=0; i<5; i++){
                        if(nums1[i]!=c && nums1[i]!=e)
                            g = nums1[i];
                        if(nums2[i]!=d && nums2[i]!=f)
                            h = nums2[i];
                    }
                    if(g > h)
                        return 1;
                    else if(g < h)
                        return 2;
                    else
                        return 3;
                }
            }
        }
        //对子
        else if(m==7){
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            int c=0, d=0;
            for (int i = 0; i < 5; i++) {
                if(set1.contains(nums1[i]))
                    c = nums1[i];
                if(set2.contains(nums2[i]))
                    d = nums2[i];
                set1.add(nums1[i]);
                set2.add(nums2[i]);
            }
            if(c > d)
                return 1;
            else if(c < d)
                return 2;
            else{
                for(int i=4; i>=0; i--){
                    if(nums1[i] > nums2[i])
                        return 1;
                    else if(nums1[i] < nums2[i])
                        return 2;
                }
                return 3;
            }
        }
        //散牌
        else{
            for(int i=4; i>=0; i--){
                if(nums1[i] > nums2[i])
                    return 1;
                else if(nums1[i] < nums2[i])
                    return 2;
            }
            return 3;
        }
    }
}
