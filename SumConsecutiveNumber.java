import java.util.Scanner;
public class SumConsecutiveNumber 
{ 
	static int consecutive(int num)
	{
		int count = 0;
		long k,j;
		
		 for (long i = 1; i <= num / 2; i++) {
	            k = 2 * num + i * (i - 1);
	            j = (long) ((-1 + Math.sqrt(1 + 4 * k)) / 2);
	            if (j * (j + 1) == k) {
	                count++;
	            }
	        }
		 
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.println(consecutive(num));
        
	}
}