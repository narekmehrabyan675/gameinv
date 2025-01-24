import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryLoader {
    public static List<Item> loadInventory(String fileName) throws IOException {
        List<Item> inventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                Item.Rarity rarity = Item.Rarity.valueOf(parts[1]);
                int upgradeCount = Integer.parseInt(parts[2]);
                Item item = new Item(name, rarity);
                item.setUpgradeCount(upgradeCount);
                inventory.add(item);
            }
        }
        return inventory;
    }
}
