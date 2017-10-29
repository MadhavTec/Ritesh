import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

public class TwoCircles {

	public static void main(String args[]) throws IOException {

		Scanner in = new Scanner(System.in);
		String[] input = new String[in.nextInt() + 1];

		for (int i = 0; i < input.length; i++) {
			if (input.equals(""))
				input[0] = in.nextLine();
			else
				input[i] = in.nextLine();
		}

		for(String string :circle(input) ) {
			System.out.println(string);
		}

	}

	static String[] circle(String[] info) {
		int x1, x2, y1, y2, r1, r2, k = 0;
		String[] result = new String[info.length-1];
		for (String string : info) {
			if (string != null && !string.equals("")) {
				x1 = NumberUtils.toInt(string.split(" ")[0]);
				y1 = NumberUtils.toInt(string.split(" ")[1]);
				x2 = NumberUtils.toInt(string.split(" ")[3]);
				y2 = NumberUtils.toInt(string.split(" ")[4]);
				r1 = NumberUtils.toInt(string.split(" ")[2]);
				r2 = NumberUtils.toInt(string.split(" ")[5]);
				int distSq = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
				double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

				if (x1 == x2 && y1 == y2) {
					result[k] = "Concentric";
				} else if (distance == Math.abs(r1 - r2) || distance == Math.abs(r1 + r2)) {
					result[k] = "Touching";
				} else if (distance > Math.abs(r1 - r2) || distance < Math.abs(r1 + r2)) {
					result[k] = "Intersecting";
				} else if (distance < Math.max(r1, r2)) {
					result[k] = "Disjoint‐Inside";
				} else if (distance > Math.abs(r1 + r2)) {
					result[k] = "Disjoint‐Outside";
				}
				k++;
			}
		}

		return result;

	}

}