import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
class BuyingShowTickets
{
    public static void main (String[] args)
    {
        
		Scanner in = new Scanner(System.in);
		int[] inputs = new int[in.nextInt() + 1];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = in.nextInt();
		}
		int p = inputs[inputs.length - 1];
		System.out.println(waitingTime(inputs, p));
    }

	private static long waitingTime(int[] inputs, int p) {
		
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < inputs.length-1; i++) {
			stringBuilder.append(inputs[i]).append(",");
		}
		
		if(p == 0) {
			return 1;
		}
		
		List<Long> list= new ArrayList<Long>();
		
		
		for (String input : stringBuilder.toString().split(",")) {
			if (input != null && !input.equals("")) {
				list.add(Long.valueOf(input));
			}
		}
		
		List<Long> elementToIterate = new ArrayList<Long>();
		elementToIterate.addAll(list);
		int a = Integer.parseInt(list.get(p).toString());
		
		int count=0;
		while(a>0) {
			for(int i=0; i<elementToIterate.size(); i++) {
				if(elementToIterate.get(i) != 0) {
					list.set(i, (list.get(i)-1));
					count++;
					if(list.get(p) == 0) {
						return count;
					}
				}
			}
			elementToIterate.clear();
			elementToIterate.addAll(list);
			a--;
		}
		return 1;
	}
 
}