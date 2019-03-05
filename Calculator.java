public class Calculator {

    private static double[] makeDoubleArray(String[] nums){
        double[] doubleArray = new double[nums.length];
        for (int i = 0; i < nums.length; i++){
            try{
                doubleArray[i] = Double.parseDouble(nums[i]);
            }
            catch(NumberFormatException e){
                System.out.println(e.getMessage());
                doubleArray[i] = 0;
            }
        }
        return doubleArray;
    }

    /**
     * Performs the operation of adding a sequence of numbers
     * @param nums a sequence of numbers
     * @return result of adding
     */
    private static double add(double[] nums) {
        double sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            sum += nums[i];
        }
        return sum;
    }

    /**
     * Performs a subtraction operation on a sequence of numbers
     * @param nums a sequence of numbers
     * @return result of subtraction
     */
    private static double sub(double[] nums) {
        double subtraction = nums[0];
        for (int i = 1; i < nums.length; i++){
            subtraction -= nums[i];
        }
        return subtraction;
    }

    /**
     * Performs a multiplication operation on a sequence of numbers
     * @param nums a sequence of numbers
     * @return result of multiplication
     */
    private static double multiply(double[] nums) {
        double multiplication = nums[0];
        for (int i = 1; i < nums.length; i++){
            multiplication *= nums[i];
        }
        return multiplication;
    }

    /**
     * Performs a division operation on a sequence of numbers
     * @param nums a sequence of numbers
     * @return result of division
     */
    private static double divide(double[] nums) {
        double division = nums[0];
        for (int i = 1; i < nums.length; i++){
            try {
                if (nums[i] == 0){
                    throw new IllegalArgumentException("Attempt to divide by zero!");
                }
                else {
                    division /= nums[i];
                }
            }
            catch (IllegalArgumentException e){
                division = 0;
                System.out.println(e.getMessage());
            }
        }
        return division;
    }

    public static double calculate(String operation, String[] nums){
        double result = 0;
        double[] array = makeDoubleArray(nums);
        try {
            if (nums.length == 1){
                throw new NumbersException("Can not perform operation with only one number");
            }
            switch (operation) {
                case "+":
                    result = add(array);
                    break;
                case "-":
                    result = sub(array);
                    break;
                case "*":
                    result = multiply(array);
                    break;
                case "/":
                    result = divide(array);
                    break;
                default:
                    throw new OperationException("Unknown operation");
            }
        }
        catch (OperationException e){
            System.out.println(e.getMessage());
        }
        catch (NumbersException e){
            System.out.println(e.getMessage());
        }
        return result;
    }

}
