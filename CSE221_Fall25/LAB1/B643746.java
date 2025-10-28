package LAB1;
import java.util.*;

public class B643746 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < T; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            
            double a = Double.parseDouble(parts[1]);
            String op = parts[2];
            double b = Double.parseDouble(parts[3]);
            double result = 0;

            switch (op) {
                case "+": result = a + b; break;
                case "-": result = a - b; break;
                case "*": result = a * b; break;
                case "/": result = a / b; break;
            }

            System.out.printf("%.6f\n", result);
        }
        sc.close();
    }
}
