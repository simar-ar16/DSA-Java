class bananas {
    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        int hours=8;
        System.out.println(minEatingSpeed(piles,hours));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for(int i=1;i<piles.length;i++)
        {
            if(piles[i] > max)
            max=piles[i];
        }
    return eat(piles,h,max);
    }
    static int eat(int[] piles, int h, int max)
    {
        int start=1;
        int end=max;
        while(start <= end)
        {
            int mid = (start + end)/2;
            int t=hour(piles,mid);
            if(t <= h)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return start;
    }
    static int hour(int[] piles,int mid)
    {
        int count=0;
        for(int i:piles)
        {
            count += Math.ceil((double)i / (double)mid);
        }
        return count;
    }
}