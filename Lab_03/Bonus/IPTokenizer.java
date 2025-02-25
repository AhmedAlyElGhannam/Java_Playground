import java.util.StringTokenizer;

public class IPTokenizer {
	public static void main(String[] args) {
		if (args.length == 1) {
			String[] result = args[0].split("[.]");
			System.out.println("String Split:");
			for (int iter = 0; iter < result.length; iter++) {
				System.out.println(result[iter]);
			}

			System.out.println("String Tokenizer: ");
			StringTokenizer st = new StringTokenizer(args[0], ".");
     			while (st.hasMoreTokens()) {
         			System.out.println(st.nextToken());
     			}
		}	
	}
}
