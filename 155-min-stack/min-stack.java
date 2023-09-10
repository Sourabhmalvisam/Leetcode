class MinStack {
  static Stack<Long> stack;
    static long minEle;
    public MinStack() {
        stack= new Stack<>();
    }
    
    public void push(int val) {
         if (stack.size() == 0) {
            stack.push((long) val);
            minEle = (long) val;
        } else {
            if ((long) val >= minEle) {
                stack.push((long) val);
            } else {
                stack.push(2 * (long) (val) - minEle);
                minEle = (long) val;
            }

        }
    }
    
    public void pop() {
        if (stack.size() == 0)
            return;
        else {
            if (stack.peek() >= minEle) {
               stack.pop();
            } else {
                minEle = 2 * minEle - stack.peek();
                stack.pop();
            }

        } 
    }
    
    public int top() {
         if (stack.size() == 0)
            return -1;
        else {
            long top = stack.peek();
            if (stack.peek() >= minEle)
                return (int) top;
            else {
                return (int) minEle;
            }
        }
        
    }
    
    public int getMin() {
         if (stack.size() == 0)
            return -1;
        else
            return (int) minEle;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */