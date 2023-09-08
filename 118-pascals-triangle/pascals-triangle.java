class Solution { //Striver //Fraz //Neetcode
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> row = null;
		List<Integer> prevRow = null;
		for (int i = 0; i<numRows; i++) {
			row = new ArrayList<>();
			for (int j = 0; j<= i; j++) {
				if (j == 0 || i == j) row.add(1);
				else row.add(prevRow.get(j - 1) + prevRow.get(j));
			}
			prevRow = row;
			res.add(row);
		}
		return res;

	}
}
