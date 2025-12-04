/**
 *    author:  kabir_singh
 *    created: 2025.12.04 21:30:06
 **/
import java.io.*;
import java.util.*;
public class F_The_King_of_Knigsberg {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        List<int[]> validMoves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                validMoves.add(new int[] { nx, ny });
            }
        }

        validMoves.sort((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        pw.println(validMoves.size());
        for (int[] move : validMoves) {
            pw.println(move[0] + " " + move[1]);
        }

        pw.flush();
        br.close();
        pw.close();
    }
}