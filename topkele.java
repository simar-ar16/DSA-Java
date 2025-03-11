//return top k frequent elements in array. Leetcode 347

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class topkele {
    public static void main(String[] args) {
        int[] arr={1,1,1,2,3,3};
        int[] ans=topKFrequent(arr, 2);
        System.out.println(Arrays.toString(ans));
    }

    static int[] topKFrequent(int[] nums, int k) {
     HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        {
            if(map.containsKey(i))
            {
                map.put(i,map.get(i)+1);
            }
            else
            {
                map.put(i,1);
            }
        }
        int[] arr=new int[k];
        int i=0;
        while(k > 0)
        {
            int m=-1;
            int v=-1;
            for(Map.Entry<Integer,Integer> e:map.entrySet())
            {
                if(e.getValue() > m)
                {
                    v=e.getKey();
                    m=e.getValue();
                }
            }
            map.put(v,0);
            arr[i]=v;
            i++;
            k--;
        }
        return arr;
   
    }
}
