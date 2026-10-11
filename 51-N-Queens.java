class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(ans, current, 0, n);

        return ans;
    }

    public void backtrack(List<List<String>> ans,
                          List<Integer> current,
                          int row, int n) {

        if (row == n) {

            List<String> board = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                char[] arr = new char[n];
                Arrays.fill(arr, '.');

                arr[current.get(i)] = 'Q';

                board.add(new String(arr));
            }

            ans.add(board);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(current, row, col)) {

                current.add(col);

                backtrack(ans, current, row + 1, n);

                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isSafe(List<Integer> current,
                          int row, int col) {

        for (int i = 0; i < current.size(); i++) {

            int previousCol = current.get(i);
            int previousRow = i;

            if (previousCol == col) {
                return false;
            }

            if (Math.abs(previousRow - row) ==
                Math.abs(previousCol - col)) {
                return false;
            }
        }

        return true;
    }
}
