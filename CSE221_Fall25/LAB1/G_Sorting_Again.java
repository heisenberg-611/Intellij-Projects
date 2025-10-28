package LAB1;
import java.util.*;

public class G_Sorting_Again {

    static class Student {
        int id, mark, originalIndex;
        Student(int id, int mark, int originalIndex) {
            this.id = id;
            this.mark = mark;
            this.originalIndex = originalIndex;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            Student[] students = new Student[N];
            for (int i = 0; i < N; i++) students[i] = new Student(sc.nextInt(), 0, i);
            for (int i = 0; i < N; i++) students[i].mark = sc.nextInt();


            for (int i = 0; i < N - 1; i++) {
                int maxIdx = i;
                for (int j = i + 1; j < N; j++) {
                    if (students[j].mark > students[maxIdx].mark) maxIdx = j;
                    else if (students[j].mark == students[maxIdx].mark && students[j].id < students[maxIdx].id)
                        maxIdx = j;
                }
                if (i != maxIdx) {
                    Student temp = students[i];
                    students[i] = students[maxIdx];
                    students[maxIdx] = temp;
                }
            }

            int[] indexMap = new int[N];
            for (int i = 0; i < N; i++) indexMap[students[i].originalIndex] = i;

            boolean[] visited = new boolean[N];
            int swaps = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i] || indexMap[i] == i) continue;
                int cycleSize = 0;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = indexMap[j];
                    cycleSize++;
                }
                if (cycleSize > 1) swaps += cycleSize - 1;
            }

            System.out.println("Minimum swaps: " + swaps);
            for (int i = 0; i < N; i++) {
                System.out.println("ID: " + students[i].id + " Mark: " + students[i].mark);
            }
        }
    }
}
