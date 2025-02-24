
class Complex {
	protected int real;
	protected int img;
	Complex() {
		this.real = 0;
		this.img = 0;
	}

	Complex(int _real, int _img) {
		this.real = _real;
		this.img = _img;
	}

	// setters
	public void setReal(int _real) {
		this.real = _real;
	}
	public void setImg(int _img) {
		this.img = _img;
	}
	// getters
	public int getReal() {
		return this.real;
	}
	public int getImg() {
		return this.img;
	}

	// static methods
	public static Complex calcSum(Complex c1, Complex c2) {
		Complex complexSum = new Complex(c1.real + c2.real, c1.img + c2.img);
		return complexSum;
	}

	public static Complex calcSub(Complex c1, Complex c2) {
		Complex complexSub = new Complex(c1.real - c2.real, c1.img - c2.img);
		return complexSub;
	}

	private static boolean isPositive(int num) {
		return (num > 0);
	}
	private static boolean isNegative(int num) {
		return (num < 0);
	}
	private static boolean isZero(int num) {
		return (num == 0);
	}
	public static void printComplex(Complex c1) {
		if (Complex.isPositive(c1.real) || Complex.isNegative(c1.real)) {
			System.out.print(c1.real);
			if (Complex.isPositive(c1.img)) {
				System.out.print(" + " + c1.img + "i\n");
			}
			else if (Complex.isNegative(c1.img)) {
				System.out.print(" - " + (c1.img * -1) + "i\n");
			}
			
		}
		else if (Complex.isZero(c1.real)) {
			if (Complex.isPositive(c1.img)) {
				System.out.print(c1.img + "i\n");
			}
			else if (Complex.isNegative(c1.img)) {
				System.out.print("-" + (c1.img * -1) + "i\n");
			}
		}	
	}	
}




class MainComplex {

	public static void main(String[] args) {
		Complex c1 = new Complex(1, 2);
		Complex c2 = new Complex(1, 4);
		Complex.printComplex(c1);
		Complex.printComplex(c2);
		Complex.printComplex(Complex.calcSum(c1, c2));
		Complex.printComplex(Complex.calcSub(c1, c2));
	}
}
