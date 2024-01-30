class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int r, int c, int t){
            row=r;
            col=c;
            time=t;
        }

    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][]vis=new int[m][n];
        Queue<Pair> q=new LinkedList<>();

        int countFresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    countFresh++;
                   
                }
                else if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
            }
        }
        int maxTime=0;
        int [][]dir={{0,1},{0,-1},{1,0},{-1,0}};
        int count=0;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            int time=curr.time;
            maxTime=Math.max(time, maxTime);
            for(int [] d: dir){
                int newR=row+d[0];
                int newC=col+d[1];
                if(newR>=0&newC>=0&&newR<m&&newC<n&&vis[newR][newC]==0&&grid[newR][newC]==1){
                    vis[newR][newC]=2;
                    q.add(new Pair(newR,newC,time+1));
                    count++;

                }
            }
        }
        if(count==countFresh) return maxTime;
        return -1;
    }
}