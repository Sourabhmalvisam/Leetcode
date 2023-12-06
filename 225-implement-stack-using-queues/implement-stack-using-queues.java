class MyStack {
  //only one queue is needed to solve this.
	Queue<Integer> q;
	public MyStack() {
		q = new LinkedList<>();
	}

	public void push(int x) {
		q.add(x);
		for (int i = 0; i<q.size() - 1; i++) {
			q.add(q.remove());
		}
	}

	public int pop() {
		return q.remove();
	}

	public int top() {
		return q.peek();
	}

	public boolean empty() {
		if (q.size() == 0) return true;
		return false;
	}
}
