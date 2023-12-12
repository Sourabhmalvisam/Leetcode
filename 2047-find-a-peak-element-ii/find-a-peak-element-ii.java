class Solution {
    public int maxElementInRow(int[][] mat, int mid)
    {
        int maxi=0;
        int row_number=0;
        for(int i=0;i<mat.length;i++)
        {
            if(maxi < mat[i][mid])
           { 
               
               maxi=mat[i][mid];
               row_number=i;

           }


        }
        //Returns row number with the maximum element
        return row_number;
    }
    public int[] findPeakGrid(int[][] mat) {
        int start=0;
        int end=mat[0].length-1;

        while(start<=end)
        {
            int mid=(start+end)/2;
            int row=maxElementInRow(mat,mid);

            int left= mid-1 >=0 ? mat[row][mid-1] : -1;
            int right=mid+1 <mat[0].length ? mat[row][mid+1] : -1;

            if(mat[row][mid]>left && mat[row][mid]>right)
            {
                return (new int[] {row,mid});
            }
            else if(mat[row][mid]<left)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }


        }
        return (new int[] {0,0});
        
    }
}