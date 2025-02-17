public class castro {
    public static void main(String[] args) {
        int y = 0;
        int x = 1;
        int total = 0;

        while (x <= 10) {
            y = x * x;
            System.out.println("Value of y is, " + (y+=2));
            total += y;
            ++x;
        }

        System.out.println("\n" + "Total is, " + (total*=2));
        y = y * x;
        System.out.println("\n" + "Final value stored in y is, " + y);
    }
}