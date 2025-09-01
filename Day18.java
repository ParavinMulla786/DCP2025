import java.util.Scanner;

public class DivisorCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        sc.close();
        
        int count = 0;
        long sqrt = (long)Math.sqrt(N);
        
        for (long i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                if (i == N / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        
        System.out.println(count);
    }
}
