import java.util.Scanner;

/**
 * The program asks the user which lunch item they want to heat,
 * and the quantity (1 to 3).
 * It then calculates and displays the heating time based on the quantity.
 * Heating times increase by 50% for 2 items, and 100% for 3 items.
 * Valid items are: sub, pizza, soup.
 *
 * @author Angel
 * @version 1.0
 * @since 2025-09-22
 */
public final class Microwave {

    /** Base heating time for sub in seconds. */
    static final int SUB_TIME = 60;

    /** Base heating time for pizza in seconds. */
    static final int PIZZA_TIME = 45;

    /** Base heating time for soup in seconds. */
    static final int SOUP_TIME = 105;

    // Private constructor to prevent instantiation
    private Microwave() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main method that runs the microwave reheating program.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Available items: sub, pizza, soup");
        System.out.print("Enter the item you want to heat: ");
        final String itemInput = scanner.nextLine().trim().toLowerCase();

        int baseTime = 0;
        boolean validItem = true;

        // Determine base time based on item input using if-else
        if (itemInput.equals("sub")) {
            baseTime = SUB_TIME;
        } else if (itemInput.equals("pizza")) {
            baseTime = PIZZA_TIME;
        } else if (itemInput.equals("soup")) {
            baseTime = SOUP_TIME;
        } else {
            validItem = false;
        }

        if (!validItem) {
            System.out.println("Invalid item.");
            System.out.println(" Please choose from: sub, pizza, soup.");
            scanner.close();
            return;
        }

        System.out.print("Enter the quantity (1 to 3): ");
        final String quantityInput = scanner.nextLine().trim();

        int quantity;

        try {
            quantity = Integer.parseInt(quantityInput);

            if (quantity < 1 || quantity > 3) {
                System.out.println("Invalid quantity.");
                System.out.println("Must be between 1 and 3.");
                scanner.close();
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            System.out.println("Please enter a numeric value for quantity.");
            scanner.close();
            return;
        }

        // Calculate total heating time
        double totalTime = baseTime;

        if (quantity == 2) {
            totalTime = totalTime * 1.5; // increase by 50%
        } else if (quantity == 3) {
            totalTime = totalTime * 2.0; // increase by 100%
        }

        // Convert totalTime (seconds) into minutes and seconds
        final int totalSeconds = (int) totalTime;
        final int minutes = totalSeconds / 60;
        final int seconds = totalSeconds % 60;

        // Print the heating time with quantity, item name,
                // minutes, and seconds using concatenation
        System.out.println("Heating time for " + quantity
                + " " + itemInput + "(s): " + minutes + " minute(s) and "
        + seconds + " second(s).");

        // Close the scanner to release resources
        scanner.close();
    }
}
