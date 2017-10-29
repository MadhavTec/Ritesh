import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class LargeResponse {

	public static void main(String args[]) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String inputFilename = scanner.nextLine();
		StringBuilder outputFileName =  new StringBuilder();
		outputFileName.append("bytes_").append(inputFilename);
		
		BufferedReader br = new BufferedReader(new FileReader(inputFilename));
		try {
			in = new FileInputStream(inputFilename);
			out = new FileOutputStream(outputFileName.toString());
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			String[] splitStr;
			int totalCount = 0;
			long totalSize = 0;
			while (line != null) {
				splitStr = sb.append(line).toString().split(" ");
				int a = splitStr.length;
				line = br.readLine();
				if (Long.valueOf(splitStr[a - 1]) > 5000) {
					totalSize += Long.valueOf(splitStr[a - 1]);
					totalCount++;
				}

			}
			final PrintStream printStream = writeDataToFile(out, totalCount, totalSize);
			printStream.close();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	private static PrintStream writeDataToFile(FileOutputStream out, int totalCount, long totalSize) {
		String content = totalCount + "\n" + totalSize;
		final PrintStream printStream = new PrintStream(out);
		printStream.print(content);
		return printStream;
	}
}