public class Calculator {

    public static float calculator(float firstOpenrand, float secondOpenrand,String operator) {
        switch (operator) {
            case "addition" :
                    return firstOpenrand + secondOpenrand;
            case "subtraction" :
                return firstOpenrand - secondOpenrand;
            case "multiplication" :
                return firstOpenrand * secondOpenrand;
            case "division":
                if ( secondOpenrand != 0) {
                    return firstOpenrand / secondOpenrand;
                } else {
                    throw new RuntimeException("Can't devide by zero");
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
