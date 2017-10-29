import java.util.Scanner;
 
class LargestSubsetSum
{
    public static void main (String[] args)
    {
        
		Scanner in = new Scanner(System.in);
		int[] inputs = new int[in.nextInt()];
		for (int i = 0; i < inputs.length; i++) {
				inputs[i] = in.nextInt();
		}
		for(long i:maxSubsetSum(inputs)){
			System.out.println(i);
		}
		
    }

	private static long[] maxSubsetSum(int[] inputs) {
		long[] ls = new long[inputs.length];
		int sum = 0;
		for (int i=0;i<=inputs.length-1;i++) {
			for(int j=1; j<=inputs[i]; j++)
	            if (Long.valueOf(inputs[i]) != null && !Long.valueOf(inputs[i]).equals("") && (inputs[i]%j)==0)
	            	sum = sum + j;
			ls[i] = sum;
			sum=0;
		}
		return ls;
	}

}