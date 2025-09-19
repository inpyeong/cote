class Solution {

    static int M, N;
    static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean answer = false;
    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        M = board.length;
        N = board[0].length;
        visited = new boolean[M][N];
        answer = false;

        // DFS for all cells
        for (int y = 0; y < M; ++y) {
            for (int x = 0; x < N; ++x) {
                visited[y][x] = true;
                dfs(board, word, y, x, board[y][x] + "");
                visited[y][x] = false;
            }
        }

        return answer;
    }

    void dfs(char[][] board, String word, int y, int x, String constructed) {

        // Base conditions
        if (word.equals(constructed)) {
            answer = true;
            return;
        }
        if (answer == true) {
            return;
        }
        if (constructed.length() > word.length()) {
            return;
        }
        if (constructed.charAt(constructed.length() - 1) != word.charAt(constructed.length() - 1)) {
            return;
        }


        for (int i = 0; i < DIRECTIONS.length; ++i) {
            int ny = y + DIRECTIONS[i][0];
            int nx = x + DIRECTIONS[i][1];

            // Skip if coordinate is out of board
            if (ny < 0 || ny >= M || nx < 0 || nx >= N) {
                continue;
            }

            // Skip if next cell was already visited
            if (visited[ny][nx] == true) {
                continue;
            }

            visited[ny][nx] = true;
            dfs(board, word, ny, nx, constructed + board[ny][nx]);
            visited[ny][nx] = false;
        }
    }
}
