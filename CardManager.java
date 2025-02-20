import java.util.*;

class CardCollection {
    private Map<String, List<String>> cardMap;

    public CardCollection() {
        cardMap = new HashMap<>();
    }

    public void addCard(String symbol, String cardName) {
        cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(cardName);
        System.out.println("Card added successfully!");
    }

    public void findCardsBySymbol(String symbol) {
        if (cardMap.containsKey(symbol)) {
            System.out.println("Cards with symbol '" + symbol + "': " + cardMap.get(symbol));
        } else {
            System.out.println("No cards found with this symbol.");
        }
    }

    public void displayAllCards() {
        if (cardMap.isEmpty()) {
            System.out.println("No cards available!");
            return;
        }
        System.out.println("All Cards:");
        for (Map.Entry<String, List<String>> entry : cardMap.entrySet()) {
            System.out.println("Symbol: " + entry.getKey() + " -> Cards: " + entry.getValue());
        }
    }
}

public class CardManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();

        while (true) {
            System.out.println("\n1. Add Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Card Symbol: ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter Card Name: ");
                    String name = scanner.nextLine();
                    collection.addCard(symbol, name);
                }
                case 2 -> {
                    System.out.print("Enter Symbol to Search: ");
                    String symbol = scanner.nextLine();
                    collection.findCardsBySymbol(symbol);
                }
                case 3 -> collection.displayAllCards();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
