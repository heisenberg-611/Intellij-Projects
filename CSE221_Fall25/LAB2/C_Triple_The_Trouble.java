import java.io.*;
import java.util.*;

public class C_Triple_The_Trouble{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        long[][] arri = new long[N][2];
        for(int i = 0; i < N; i++){
            arri[i][0] = arr[i];
            arri[i][1] = i;
        }

        Arrays.sort(arri,(u,v) -> Long.compare(u[0],v[0]));
        boolean found = false;
        for(int i = 0; i<N-2;i++){
            int left = i+1;
            int right = N-1;
            while(left<right){
                long sum = arri[i][0] + arri[left][0] + arri[right][0];
                if(sum == x){
                    long id1 = arri[i][1]+1;
                    long id2 = arri[left][1]+1;
                    long id3 = arri[right][1]+1;
                    pw.println(id1+" "+id2+" "+id3);
                    found = true;
                    break;
                }
                else if(sum<x){
                    left++;
                }
                else{
                    right--;
                }
            }
            if(found) break;
        }
        if(!found){
            pw.println(-1);
        }
        pw.flush();
        pw.close();
        br.close();
    }
} 