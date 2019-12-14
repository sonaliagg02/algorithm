import java.util.*;
class SnakeCoup {
    public static void main(String []args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int ans;

        while(t-->0)
        {
            int n=in.nextInt();
            char[] s=in.next().toCharArray();
            char[] a=in.next().toCharArray();
            int i;

            int[] count=new int[2];

            for(i=0;i<n;i++)
            {
                if(s[i]=='*')
                    count[0]++;
                if(a[i]=='*')
                    count[1]++;
            }
            if(count[0]>0 && count[1]>0)
            {
                ans=1;
                count[0]=0;
                count[1]=0;

                for(i=0;i<n;i++)
                {
                    if(s[i]=='*')
                        count[0]++;
                    if(a[i]=='*')
                        count[1]++;
                    if(count[0]>1 || count[1]>1)
                    {
                        ans++;
                        count[0]=0;
                        count[1]=0;
                        i--;
                    }
                }
            }
            else if(count[0]==0 && count[1]>1 || count[0]>1 && count[1]==0)
                ans=Math.max(count[0],count[1])-1;
            else
                ans=0;
            System.out.println(ans);
        }
    }
}