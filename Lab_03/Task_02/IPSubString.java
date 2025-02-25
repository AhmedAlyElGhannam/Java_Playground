public class IPSubString {

	static void separateIP(String IP) {
		int beginIndex = 0;
		int endIndex = IP.indexOf(".");
		int iter = 0;
		boolean isNotLastSegment = true
		while (isNotLastSegment) {
			System.out.println(IP.substring(beginIndex, endIndex));
			beginIndex = endIndex + 1;
			endIndex = IP.indexOf(".", beginIndex);
			if (endIndex == -1) {
				isNotLastSegment = true;
			}
			iter++;
		}

		System.out.println(IP.substring(beginIndex));

	}

	public static void main(String[] args) {
		IPSubString.separateIP(args[0]);
	}
}
