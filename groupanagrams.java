//group anagrams. Leetcode 49

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupanagrams {

    public static void main(String[] args) {
        String[] str={"act","pots","tops","cat","stop","hat"};
        List<List<String>> st=groupAnagrams(str);
        System.out.println(st);
        
    }

        static List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String,List<String>> ans=new HashMap<>(); //in this map key is the sorted string and value is the list of original strings
            for(String str:strs)
            {
                char[] ch=str.toCharArray();
                Arrays.sort(ch);
                String s=new String(ch);
                if(!ans.containsKey(s))
                {
                    ans.put(s,new ArrayList<>());
                    
                }
                ans.get(s).add(str);
            }
            ArrayList res=new ArrayList<>(ans.values());
            return res;
        }
    }
