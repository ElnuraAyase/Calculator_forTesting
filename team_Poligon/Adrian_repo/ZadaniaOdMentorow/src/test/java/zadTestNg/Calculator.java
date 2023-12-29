package zadTestNg;




public class Calculator {
        public int sum(int num1, int num2){
            return num1+num2;
        }
        public int subtract(int num1, int num2){
            return num1-num2;
        }
        public int multiply(int num1, int num2){
            return num1*num2;
        }
        public double divide(double num1, double num2){
            if(num2 != 0){
                return num1/num2;
            }else{
                throw new IllegalArgumentException("Division by zero is not permitted");
            }
        }





    }



