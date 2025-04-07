public class Calculator {
        private double result; //                      Private variable to store result + could be stored in a different file

        public double getResult() {
            return result; //   Public method to access result
        }

        protected void setResult(double value) {
            this.result = value; // Protected method to set result
        }

}
