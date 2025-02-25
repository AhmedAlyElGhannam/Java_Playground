public class Calculator {
	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Insufficient Number of Arguments!");
		} else {
			int operand1 = Integer.parseInt(args[0]);
			int operand2 = Integer.parseInt(args[2]);
		
			switch (args[1])
			{
				case "+":
					System.out.println(operand1 + " + " + operand2 + " = " + (operand1 + operand2));
				break;

				case "-":
					System.out.println(operand1 + " - " + operand2 + " = " + (operand1 - operand2));
				break;

				case "x":
					System.out.println(operand1 + " x " + operand2 + " = " + (operand1 * operand2));
				break;

				case "/":
					if (operand2 == 0) {
						System.out.println("Cannot Divide By Zero!");
					} else {
						System.out.println(operand1 + " / " + operand2 + " = " + (operand1 / operand2));
					}
				break;

				default:
					System.out.println("Invalid Operation");
			}
		}
	}
}
