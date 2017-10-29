import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedOrNot {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		String[] inputs = new String[in.nextInt() + 1];
		for (int i = 0; i < inputs.length; i++) {
			if (inputs.equals(""))
				inputs[0] = in.nextLine();
			else
				inputs[i] = in.nextLine();
		}

		int[] maxReplacement = new int[in.nextInt()];
		for (int i = 0; i < maxReplacement.length; i++) {
				maxReplacement[i] = in.nextInt();
		}

		for(int i:balancedOrNot(inputs, maxReplacement)){
			System.out.println(i);
		}
	}

	private static int[] balancedOrNot(String[] inputs, int[] maxReplacement) {
		int j = 0;
		int[] ls = new int[maxReplacement.length];
		for (String input : inputs) {
			if (input != null && !input.equals("")) {

				Stack<String> stackOpen = new Stack<String>();
				Stack<String> stackClose = new Stack<String>();
				boolean isBalanaced = false;
				int totalOpen = 0;
				int totalClose = 0;

				boolean flag = false;
				for (int i = 0; i < input.length(); i++) {
					String s = "" + input.charAt(i);
					if((input.charAt(0) + "").equals(">")) {
						isBalanaced = false;
						break;
					}
					if (s.equals("<")  && !flag) {
						stackOpen.push(s);
					} else {
						stackClose.push(s);
						flag = true;
					}
				}
				if (stackOpen.size() != 0 && stackClose.size() != 0 && stackOpen.size() == stackClose.size()) {
					isBalanaced = true;
				} else if (stackOpen.size() < stackClose.size()) {
					totalOpen = stackOpen.size() + maxReplacement[j];
					totalClose = stackClose.size();
				} else if(stackOpen.size() != 0 && stackClose.size() != 0){
					totalClose = stackClose.size() + maxReplacement[j];
					totalOpen = stackOpen.size();
				}
				if (stackOpen.size() != 0 && stackClose.size() != 0 && totalOpen == totalClose) {
					isBalanaced = true;
				}
				
				if (isBalanaced) {
					ls[j] = 1;
				} else {
					ls[j] = 0;
				}
				j++;
			}
		}
		return ls;
	}
}