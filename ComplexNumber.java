
public class ComplexNumber {

	private double real;
	private double imaginary;
	
	 public ComplexNumber(double real, double imaginary) {
	        this.real = real;
	        this.imaginary = imaginary;
	 }
	 
	 public ComplexNumber plus(ComplexNumber n) { 
		 return new ComplexNumber(real + n.real, imaginary + n.imaginary); 
	 }
	 
	 public ComplexNumber times(ComplexNumber n) {
	    return new ComplexNumber(real * n.real - imaginary * n.imaginary, real * n.imaginary + imaginary * n.real);
	 }
	 
	 public double absSquared() { 
	    return real * real + imaginary * imaginary; 
	 }
}
