public class Calculator {
        private double result; //                      Private variable to store result + could be stored in a different file

        public double getResult() {
            return result; //   Public method to access result
        }

        protected void setResult(double value) {
            this.result = value; // Protected method to set result
        }

    // need to add NaN (not a Number special constant) that doesn't represent real number

    // shared input validation  + method for loop to implement to eaxch method
    protected void validateInputs(double...values){   // to allowed to be used by child classes  , not used elsewhere
        for(double val : values) {
            if(Double.isNaN(val)) {
                throw new IllegalArgumentException("Input can not be any else than number");

            }

        }
    }

}
