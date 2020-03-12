package likou;

import java.util.*;

public class Type {

        public static int[] select(char[] num, char[] chars){
            int[] arr = {0,0,0,0,0,0,0,0,0};//同花顺，铁支，葫芦，同花，顺子，三条，两对，对子，散牌
            int link = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (char c : num) {
                if(map.containsKey(c)==false)
                    map.put(c,1);
                else{
                    Integer value = map.get(c);
                    value++;
                    map.put(c,value);
                }
            }

            //铁支
            if(map.size()==2 &&(map.get(num[0])==1 || map.get(num[0])==4))
                arr[1] = 1;

            //三条
            else if(map.size()==3 && ( map.get(num[0])==3 && map.get(num[1])==1) || (map.get(num[1])==3 && map.get(num[2])==1) || (map.get(num[2])==3 && map.get(num[0])==1))
               arr[5] = 1;

            //两对
            else if(map.size()==3 &&(map.get(num[0])==2 && map.get(num[1])==1) || (map.get(num[1])==2 && map.get(num[2])==1) || (map.get(num[2])==2 && map.get(num[0])==1))
                arr[6] = 1;

            //对子
            else if(map.size()==4)
                arr[7] = 1;

            //葫芦
            else if(map.size()==2 &&(map.get(num[0])==2  || map.get(num[0])==3))
                arr[2] = 1;

            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 5; i++) {
                set.add(num[i]);
            }
            if(set.size()==5){
                    int[] nums = new int[5];
                    for (int i = 0; i < num.length; i++) {
                        if(num[i]=='T')
                           nums[i] = 10;
                        else if(num[i]=='J')
                            nums[i] = 11;
                        else if(num[i]=='Q')
                            nums[i] = 12;
                        else if(num[i]=='K')
                            nums[i] = 13;
                        else if(num[i]=='A')
                            nums[i] = 14;
                        else
                            nums[i] = num[i] - 48;
                    }
                    Arrays.sort(nums);
                    if(nums[4]-nums[0]==4)
                        link = 1;
            }

            //同花
            int count = 0;
            for (int i = 1; i < 5; i++) {
                if(chars[i-1]==chars[i])
                    count++;
            }
            if(count==4 && link==0)
                 arr[3] = 1;

            //顺子
            else if(count!=4 && link==1)
                 arr[4] = 1;

            //同花顺
            else if(count==4 && link==1)
                arr[0] = 1;

            //散牌
            if(arr[0]==0 && arr[1]==0 && arr[2]==0 && arr[3]==0 && arr[4]==0 && arr[5]==0 && arr[6]==0 && arr[7]==0 )
                arr[8] = 1;
            return arr;

        }


}
