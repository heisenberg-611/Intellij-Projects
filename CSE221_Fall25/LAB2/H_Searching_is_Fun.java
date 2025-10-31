import java.io.*;
import java.util.*;
public class H_Searching_is_Fun{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            String[] xd = br.readLine().split(" ");
            long k = Long.parseLong(xd[0]);
            long x = Long.parseLong(xd[1]);
            
            long ans = k + (k - 1) / (x - 1);
            pw.write(ans + "\n");
        }
        
        pw.flush();
        pw.close();
        br.close();
    }
}