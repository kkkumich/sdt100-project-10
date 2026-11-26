package common;
import java.util.Scanner;
/** Read complete lines to avoid the nextInt/nextLine newline problem. */
public final class Input {
    private static final Scanner IN = new Scanner(System.in);
    private Input() { }
    public static String text(String prompt) {
        System.out.print(prompt);
        if (!IN.hasNextLine()) throw new IllegalStateException("Input ended before the dialog finished");
        return IN.nextLine().trim();
    }
    public static int integer(String prompt, int min, int max) {
        while (true) {
            try { int n = Integer.parseInt(text(prompt));
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException ignored) { }
            System.out.println("Enter a whole number from " + min + " to " + max + ".");
        }
    }
    public static double number(String prompt) {
        while (true) {
            try { double n = Double.parseDouble(text(prompt));
                if (Double.isFinite(n)) return n;
            } catch (NumberFormatException ignored) { }
            System.out.println("Enter a finite number; use a dot for decimals.");
        }
    }
    public static boolean again() { return text("Continue? (Y/N): ").equalsIgnoreCase("y"); }
}
