public class NumLength {
    public static void main(String[] args) {
        int num = 12345;
        double length = Math.floor(Math.log10(num) + 1); // Math.log10() returns the log base 10 of num, and Math.floor() returns the largest integer less than or equal to the given value, so adding 1 to it gives the length of the number in digits.

        System.out.println("The number " + num + " has " + length + " digits.");
    }
}
