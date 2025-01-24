import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class InventorySaver {
    public static void saveInventory(List<Item> inventory, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Item item : inventory) {
                writer.write(item.getName() + "," + item.getRarity() + "," + item.getUpgradeCount() + "\n");
            }
        }
    }
}
