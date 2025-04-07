
    // Step2: Abstraction (  Hiding implementation detals and providing a clear interface )
    class BasicOperations extends Calculator {
        public double add(double a, double b) {
            setResult(a + b);
            return getResult();
        }

        public double subtract(double a, double b) {
            setResult(a - b);
            return getResult();
        }

        public double multiply(double a, double b) {
            setResult(a * b);
            return getResult();
        }

        public double divide(double a, double b) {
            if (b != 0) {
                setResult(a / b);
            } else {
                System.out.println("Error: Division by zero");
                setResult(Double.NaN);
            }
            return getResult();
        }
    }

