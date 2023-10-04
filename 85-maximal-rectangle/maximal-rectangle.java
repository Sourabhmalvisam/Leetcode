class Solution {

    public int histogram_area(int[] arr)
    {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] left_small=new int[n];
        int[] right_small=new int[n];
        
        //Populating the left small 
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[i]<=arr[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                left_small[i]=0;
            }
            else
            {
                left_small[i]=st.peek()+1;

            }
            st.push(i);
        }
        //popping out the stack to clear it.
        while(!st.isEmpty()) 
        {
            st.pop();
        }

        //Populating the right small
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[i]<=arr[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                right_small[i]=n-1;
            }
            else
            {
                right_small[i]=st.peek()-1;

            }
            st.push(i);
        }
        int maxi=0;
        for(int i=0;i<n;i++)
        {
            int area=(right_small[i]-left_small[i]+1)*arr[i];
            maxi=Math.max(maxi,area);
        }
        return maxi;
        
    }


    public int maximalRectangle(char[][] matrix) {
        int maxi=0;
        int[] arr=new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++)
        {
            arr[i]=0;
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='1')
                {
                    arr[j]++;

                }
                else
                {
                    arr[j]=0;
                }

            }
            maxi=Math.max(maxi,histogram_area(arr));
        }
        return maxi;
        
    }
}