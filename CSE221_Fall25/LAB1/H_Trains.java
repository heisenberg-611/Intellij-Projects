package LAB1;
import java.util.*;
public class H_Trains {
    static class Train {
    String name;
    String description;
    int timeInMinutes;
    int originalIndex;

    Train(String description, int index) {
        this.description = description;
        this.originalIndex = index;

        String[] parts = description.split(" ");
        this.name = parts[0];

        String timeStr = parts[parts.length - 1];
        String[] hm = timeStr.split(":");
        this.timeInMinutes = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); 

        Train[] trains = new Train[N];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            trains[i] = new Train(line, i);
        }

        Arrays.sort(trains, (a, b) -> {
            int cmp = a.name.compareTo(b.name);
            if (cmp != 0) return cmp; 
            cmp = Integer.compare(b.timeInMinutes, a.timeInMinutes); 
            if (cmp != 0) return cmp;
            return Integer.compare(a.originalIndex, b.originalIndex); 
        });


        for (Train t : trains) {
            System.out.println(t.description);
        }
    }
}
