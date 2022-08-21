package leetcode.T500_T600;

public class T576 {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return (int)helper(startRow,startColumn,maxMove,m,n,new Long[maxMove+1][m][n]);
    }
    public long helper(int i,int j,int maxMove,int m,int n,Long[][][] dp){
        if((i<0 || i==m || j<0 || j==n) && maxMove>=0)
            return 1L;
        else if(maxMove==0)
            return 0L;
        else if(dp[maxMove][i][j]!=null)
            return dp[maxMove][i][j];
        return dp[maxMove][i][j] = (helper(i-1,j,maxMove-1,m,n,dp) +
                helper(i+1,j,maxMove-1,m,n,dp)+
                helper(i,j-1,maxMove-1,m,n,dp)+
                helper(i,j+1,maxMove-1,m,n,dp))%1000000007;
    }

}
