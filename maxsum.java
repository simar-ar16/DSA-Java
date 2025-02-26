/*You are given a 2D integer matrix grid of size n x m, an integer array limits of length n, and an integer k. 
The task is to find the maximum sum of at most k elements from the matrix grid such that:
The number of elements taken from the ith row of grid does not exceed limits[i].
Return the maximum sum. */

import java.util.Arrays;
import java.util.Scanner;

public class maxsum {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[][] grid=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                grid[i][j]=in.nextInt();
            }
        }
        int[] limits=new int[n];
        for(int i=0;i<n;i++)
        {
            limits[i]=in.nextInt();
        }
        int k=in.nextInt();
        long sum=maxSum(grid, limits, k);
        System.out.println(sum);
        in.close();
    }
    public static long maxSum(int[][] grid, int[] limits, int k) {
     for(int i=0;i<grid.length;i++)
     {
        Arrays.sort(grid[i]);
     }   
     int s=0;
     for(int i:limits)
        s+=i;
     int[] arr=new int[s];
     int l=0;
    for(int i=0;i<grid.length;i++)
    {
        for(int j=grid[i].length-1;limits[i]>0 && j>=0;j--)
        {
            arr[l]=grid[i][j];
            limits[i]--;
            l++;
        }
    }
    Arrays.sort(arr);
    long sum=0;
    for(int i=arr.length-1;i>=0;i--)
    {
        if(k == 0)
        break;
        sum+=arr[i];
        k--;
    }
    return sum;
    }
}
