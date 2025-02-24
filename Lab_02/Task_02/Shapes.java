abstract class Geoshape {
	protected int dim1;
	protected int dim2;
	Geoshape(int _dim1, int _dim2) {
		this.dim1 = _dim1;
		this.dim2 = _dim2;
	}
	abstract public double calcArea();
}

class Circle extends Geoshape {
	
	Circle(int radius) {
		super(radius, radius);
	}

	public double calcArea() {
		return (this.dim1 * this.dim2 * 3.14);
	}
}

class Rectangle extends Geoshape {
	Rectangle(int length, int width) {
		super(length, width);
	}

	public double calcArea() {
		return (this.dim1 * this.dim2);
	}
}

class Triangle extends Geoshape {
	Triangle(int base, int height) {
		super(base, height);
	}

	public double calcArea() {
		return (0.5 * this.dim1 * this.dim2);
	}
}

class Shapes {
	public static double sumAreas(Geoshape s1, Geoshape s2, Geoshape s3) {
		return (s1.calcArea() + s2.calcArea() + s3.calcArea());
	}
	public static void main(String[] args) {
		Geoshape s1 = new Circle(10);
		Geoshape s2 = new Rectangle(5, 2);
		Geoshape s3 = new Triangle(10, 1);

		System.out.println(Shapes.sumAreas(s1, s2, s3));
	}
}
