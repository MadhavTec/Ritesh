import java.io.IOException;
import java.util.Scanner;

public class InTheFuture {


        public static int minNum(int A, int K, int P){
            if(A>K || A==K)
                return -1;
            else
                return (P/(K-A)+(P%(K-A)==0?1:P%(K-A)));
        }

        public static void main(String args[]) throws IOException{

    		Scanner scanner = new Scanner(System.in);
    		System.out.println("Enter Inputs ");
    		int A, K , P;
    		A = scanner.nextInt();
    		K = scanner.nextInt();
    		P = scanner.nextInt();
            System.out.print(minNum(A,K,P));
        }
}
