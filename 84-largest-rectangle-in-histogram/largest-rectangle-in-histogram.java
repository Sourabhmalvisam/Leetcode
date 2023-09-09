class Solution {
     Stack<Integer> s=new Stack<>();
    public int largestRectangleArea(int[] a) {
        int[] right=nsr(a);
        s.clear();
        int[] left=nsl(a);
        int max=Integer.MIN_VALUE;
        int[] width=new int[a.length];
        int[] area=new int[a.length];
        for(int i=0;i<a.length;i++){
            width[i]=right[i]-left[i]-1;
            area[i]=a[i]* width[i];
            max=Math.max(area[i],max);
        }
        return max;
    }
    
    public int[] nsr(int[] a){
        int[] b=new int[a.length];
        int index=b.length-1;
       

        int pseudo=a.length;
        for(int i=a.length-1;i>=0;i--){
            if(s.isEmpty())
                b[index]=pseudo;
            else if(s.size()>0 && a[s.peek()]<a[i])
                b[index]=s.peek();
            else if(s.size()>0 && a[s.peek()]>=a[i]){
                while(s.size()>0 && a[s.peek()]>=a[i])
                    s.pop();
                if(s.size()==0)
                    b[index]=pseudo;
                else
                    b[index]=s.peek();
            }
            s.push(i);
            index--;
        }
        return b;
    }

    public int[] nsl(int[] a){

        int[] b=new int[a.length];
        int index=0;

         
        for(int i=0;i<b.length;i++){
            if(s.isEmpty())
                b[index]=-1;
            else if(s.size()>0 && a[s.peek()]<a[i])
                b[index]=s.peek();
            else if(s.size()>0 && a[s.peek()]>=a[i]){
                while(s.size()>0 && a[s.peek()]>=a[i])
                    s.pop();
                if(s.size()==0)
                    b[index]=-1;
                else
                    b[index]=s.peek();
            }
            s.push(i);
            index++;
        }
        return b;

    }
}