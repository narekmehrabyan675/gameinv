import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create inventor
        List<Item> inventory = new ArrayList<>();

        // Add items on intventor on hand
//        inventory.add(new Item("Iron Sword", Item.Rarity.COMMON));
//        inventory.add(new Item("Iron Sword", Item.Rarity.COMMON));
//        inventory.add(new Item("Iron Sword", Item.Rarity.COMMON));
//        inventory.add(new Item("Magic Wand", Item.Rarity.GREAT));
//        inventory.add(new Item("Magic Wand", Item.Rarity.GREAT));
//        inventory.add(new Item("Magic Wand", Item.Rarity.GREAT));
//        inventory.add(new Item("Tur", Item.Rarity.EPIC));
//        inventory.add(new Item("Tur", Item.Rarity.EPIC));
//        inventory.add(new Item("Tur", Item.Rarity.EPIC));
//        inventory.add(new Item("Tur", Item.Rarity.EPIC));
//        inventory.add(new Item("Tur", Item.Rarity.EPIC));
//        inventory.add(new Item("Tur", Item.Rarity.EPIC));

        System.out.println("Generation items...");
        for (int i = 0; i < 10; i++) {
            inventory.add(RandomItemGenerator.generateRandomItem());
        }

// Print Inventory after generation
        System.out.println("Inventor after generation:");
        displayInventory(inventory);




        // Print inentory before updates
        System.out.println("Inventor before updates:");
        displayInventory(inventory);

        try {
            InventorySaver.saveInventory(inventory, "inventory.txt");
            System.out.println("Inventory saved in inventory.txt!");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
//      For testing upload
        inventory.clear();

        try {
            inventory = InventoryLoader.loadInventory("inventory.txt");
            System.out.println("Inventory uploaded via file inventory.txt!");
            displayInventory(inventory);
        } catch (IOException e) {
            System.out.println("Error loading inventory " + e.getMessage());
        }

        // Trying to do all updates
        upgradeAllItems(inventory);

        // Print inentory after updates
        System.out.println("\nIntventory after updates:");
        displayInventory(inventory);
    }


    // Method for update all items on inventory
    // Method to upgrade all items in the inventory
    private static void upgradeAllItems(List<Item> inventory) {
        boolean upgradesPerformed;
        do {
            upgradesPerformed = false; // Reset the flag at the start of each iteration

            // Create a copy of the current inventory for safe iteration
            List<Item> itemsToUpgrade = new ArrayList<>(inventory);

            for (Item item : itemsToUpgrade) {
                boolean success = ItemUpgradeSystem.upgradeItem(inventory, item);
                if (success) {
                    // If an upgrade is performed, print the intermediate inventory
                    System.out.println("\nInventory after upgrade:");
                    displayInventory(inventory);

                    // Set the flag to true to repeat the cycle
                    upgradesPerformed = true;

                    // Restart the cycle after the inventory is modified
                    break;
                }
            }
        } while (upgradesPerformed); // Repeat while upgrades are being performed
    }


    // method for print inventory
    private static void displayInventory(List<Item> inventory) {
        inventory.stream()
                .sorted((item1, item2) -> item1.getRarity().compareTo(item2.getRarity()))
                .forEach(System.out::println);
    }
}
