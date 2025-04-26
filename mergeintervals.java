import java.util.Arrays;
import java.util.Comparator;

class mergeintervals{
    public static void main(String[] args) {
        int[][] arr={{1,3},{2,6},{8,10},{15,18}};
        merge(arr);
    }
    static void merge(int[][] intervals)
    {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int l=intervals.length;
        int j=0;
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[j][1] < intervals[i][0])
            {
                j=i;
            }
            else
            {
                if(intervals[j][1] >= intervals[i][1])
                {
                intervals[i][0]=0;
                intervals[i][1]=0;
                l--;
                }
                else
                {
                intervals[j][1] = intervals[i][1];
                intervals[i][0]=0;
                intervals[i][1]=0;
                l--;
                }
            }
        }
        int[][] result=new int[l][2];
        int t=0;
        for(int i=0;i<intervals.length;i++)
        {
            if(intervals[i][0] != 0 || intervals[i][1] != 0)
            {
                result[t][0]=intervals[i][0];
                result[t][1]=intervals[i][1];
                t++;
            }
        }
        for(int i=0;i<intervals.length;i++)
        {
            System.out.println("{"+result[i][0]+","+result[i][1]+"}");
        }
    }
}