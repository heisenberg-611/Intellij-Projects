package LAB1;
import java.util.Scanner;
public class A643746{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 1; i <= T; i++){
            int N = scanner.nextInt();
            if(N%2 == 0){
                System.out.println(N + " is an Even number.");
            } else {
                System.out.println(N + " is an Odd number.");
            }
        }
    }
}