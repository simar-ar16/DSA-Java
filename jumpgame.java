//leetcode 55
public class jumpgame {
    public static void main(String[] args) {
        int[] arr={2,3,1,1,4};
        Boolean[] memo=new Boolean[arr.length];
        System.out.println(jump(arr,0,memo));
    }

    static boolean jump(int[] arr,int start, Boolean[] memo)
    {
        if(start == arr.length -1)
        return true;

        if (memo[start] != null)
        return memo[start];

        for(int i=1;i<=arr[start];i++)
        {
            if(jump(arr,start+i,memo))
            {
                memo[start]=true;
                return true;
            }
        }
        memo[start]=false;
        return false;
    }
}
