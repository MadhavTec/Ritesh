import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PsychometricTesting {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[] inputs = new int[in.nextInt()];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = in.nextInt();
		}

		int[] lowerLimits = new int[in.nextInt()];

		for (int i = 0; i < lowerLimits.length; i++) {
			lowerLimits[i] = in.nextInt();
		}

		int[] upperLimits = new int[in.nextInt()];
		for (int i = 0; i < upperLimits.length; i++) {
			upperLimits[i] = in.nextInt();

		}
		for (int i : jobOffers(inputs, lowerLimits, upperLimits)) {
			System.out.println(i);
		}

	}

	private static int[] jobOffers(int[] inputs, int[] lowerLimits, int[] upperLimits) {
		// TODO Auto-generated method stub
		int count = 0;

		List<Long> list = new ArrayList<Long>();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < upperLimits.length; i++)
			stringBuilder.append(lowerLimits[i]).append(",").append(upperLimits[i]).append(",").append(" ");
		int i = 0;
		for (String string : stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1).split(" ")) {
			for (int input : inputs) {
				if (Long.valueOf(input) != null && !Long.valueOf(input).equals("")) {
					if (input >= Integer.parseInt(string.split(",")[0])
							&& input <= Integer.parseInt(string.split(",")[1])) {
						count++;
					}
				}

			}
			list.add((long) count);
			count = 0;
			i++;

		}
		int[] ls = new int[list.size()];
		for (i = 0; i < list.size(); i++) {
			ls[i] = Integer.parseInt(list.get(i).toString());
		}

		return ls;
	}
}
