import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        boolean[][] visited = new boolean[n][n];
        
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Cell(0, 0, grid[0][0]));
        
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            int y = curr.y, x = curr.x, cost = curr.cost;
            
            if (y == n - 1 && x == n - 1) {
                return cost;
            }
            
            if (visited[y][x]) {
                continue;
            }
            visited[y][x] = true;
            
            for (int[] d : dirs) {
                int ny = y + d[0];
                int nx = x + d[1];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx]) {
                    continue;
                }
                
                int newCost = Math.max(cost, grid[ny][nx]);
                pq.offer(new Cell(ny, nx, newCost));
            }
        }
        return -1;
    }
    
    static class Cell {
        int y, x, cost;
        Cell(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}

