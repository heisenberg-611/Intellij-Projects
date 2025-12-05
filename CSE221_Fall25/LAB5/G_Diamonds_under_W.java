/**
 *    author:  kabir_singh
 *    created: 2025.12.05 13:01:38
 **/
import java.io.*;
import java.util.*;

public class G_Diamonds_under_W{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        char[][] grid = new char[R][H];
        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[R][H];
        int maxDiamonds = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < H; j++) {
                if (grid[i][j] != '#' && !visited[i][j]) {
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});
                    visited[i][j] = true;
                    int diamondCount = 0;

                    while (!stack.isEmpty()) {
                        int[] cell = stack.pop();
                        int r = cell[0], c = cell[1];
                        if (grid[r][c] == 'D') {
                            diamondCount++;
                        }

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (nr >= 0 && nr < R && nc >= 0 && nc < H
                                && grid[nr][nc] != '#' && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                stack.push(new int[]{nr, nc});
                            }
                        }
                    }
                    if (diamondCount > maxDiamonds) {
                        maxDiamonds = diamondCount;
                    }
                }
            }
        }

        pw.println(maxDiamonds);
        pw.flush();
        pw.close();
        br.close();
    }
}