import java.util.ArrayList;
import java.util.List;

public class ItemUpgradeSystem {

    // Method to upgrade an item
    public static boolean upgradeItem(List<Item> inventory, Item targetItem) {
        Item.Rarity rarity = targetItem.getRarity();

        if (rarity == Item.Rarity.COMMON || rarity == Item.Rarity.GREAT || rarity == Item.Rarity.RARE) {
            return upgradeToNextRarity(inventory, targetItem, 2);
        } else if (rarity == Item.Rarity.EPIC) {
            return upgradeEpicItem(inventory, targetItem);
        } else {
            return false; // LEGENDARY items cannot be upgraded
        }
    }

    // Upgrade Common, Great, or Rare items to the next rarity
    private static boolean upgradeToNextRarity(List<Item> inventory, Item targetItem, int requiredItems) {
        // Check if there are enough items of the same rarity and name
        long count = inventory.stream()
                .filter(item -> item.getName().equals(targetItem.getName())
                        && item.getRarity() == targetItem.getRarity())
                .count();

        if (count >= requiredItems + 1) { // +1 for the target item itself
            // Remove the required items from inventory
            int removed = 0;
            for (int i = 0; i < inventory.size() && removed < requiredItems; i++) {
                Item item = inventory.get(i);
                if (item != targetItem && item.getName().equals(targetItem.getName())
                        && item.getRarity() == targetItem.getRarity()) {
                    inventory.remove(i);
                    i--; // Adjust index after removal
                    removed++;
                }
            }
            // Upgrade the target item
            targetItem.setRarity(Item.Rarity.values()[targetItem.getRarity().ordinal() + 1]);
            RandomItemGenerator.updateItemNameByRarity(targetItem);
            return true;
        }
        return false;
    }

    private static boolean upgradeEpicItem(List<Item> inventory, Item targetItem) {
        if (targetItem.getRarity() == Item.Rarity.EPIC) {
            // Собираем все подходящие предметы EPIC
            List<Item> epicItems = new ArrayList<>();
            for (Item item : inventory) {
                if (item != targetItem && item.getRarity() == Item.Rarity.EPIC && item.getUpgradeCount()!=2) {
                    epicItems.add(item);
                }
            }

            // Улучшение от EPIC → EPIC 1
            if (targetItem.getUpgradeCount() == 0 && epicItems.size() >= 1) {
                // Удаляем текущий предмет и один использованный предмет
                inventory.remove(targetItem);
                inventory.remove(epicItems.get(0));

                // Создаём новый предмет EPIC 1
                Item upgradedItem = new Item(targetItem.getName(), Item.Rarity.EPIC);
                upgradedItem.setUpgradeCount(1);
                inventory.add(upgradedItem);

                System.out.println("Улучшение: EPIC → EPIC 1");
                return true;
            }

            // Улучшение от EPIC 1 → EPIC 2
            if (targetItem.getUpgradeCount() == 1 && epicItems.size() >= 1) {
                // Удаляем текущий предмет и один использованный предмет
                inventory.remove(targetItem);
                inventory.remove(epicItems.get(0));

                // Создаём новый предмет EPIC 2
                Item upgradedItem = new Item(targetItem.getName(), Item.Rarity.EPIC);
                upgradedItem.setUpgradeCount(2);
                inventory.add(upgradedItem);

                System.out.println("Улучшение: EPIC 1 → EPIC 2");
                return true;
            }

            // Улучшение от EPIC 2 → LEGENDARY
            List<Item> epic2Items = new ArrayList<>();
            for (Item item : inventory) {
                if (item != targetItem && item.getRarity() == Item.Rarity.EPIC && item.getUpgradeCount() == 2) {
                    epic2Items.add(item);
                }
            }

            if (targetItem.getUpgradeCount() == 2 && epic2Items.size() >= 2) {
                // Удаляем текущий предмет и два предмета EPIC 2
                inventory.remove(targetItem);
                inventory.remove(epic2Items.get(0));
                inventory.remove(epic2Items.get(1));

                // Создаём новый предмет LEGENDARY
                Item upgradedItem = new Item(targetItem.getName(), Item.Rarity.LEGENDARY);
                inventory.add(upgradedItem);

                System.out.println("Улучшение: EPIC 2 → LEGENDARY");
                return true;
            }
        }
        return false; // Если предмет не может быть улучшен
    }


}
