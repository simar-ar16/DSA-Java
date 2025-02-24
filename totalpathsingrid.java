/*Given a point ina grid and we need to find maximum paths to reach that point by moving in down or right direction */
import java.util.*;
public class totalpathsingrid {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int i=in.nextInt();
        int j=in.nextInt();
        int res=path(i,j);
        System.out.println(res);
        in.close();
    }
    static int path(int i,int j)
    {
        if(i == 0 && j == 0)
        return 0;
        if(i == 0 || j == 0)
        return 1;
        return path(i,j-1)+path(i-1,j);
    }
}
