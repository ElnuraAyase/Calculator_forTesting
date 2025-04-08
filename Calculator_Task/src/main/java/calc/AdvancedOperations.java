package calc;

// Step 3: Inheritance (Reusing code through class hierarchy)
public class AdvancedOperations extends BasicOperations {  // extras to addition i  order to use OOP princciples
    public double power(double base, double exponent) {
        setResult(Math.pow(base, exponent));
        return getResult();
    }

    public double modulo(double a, double b) {
        setResult(a % b);
        return getResult();
    }
}
