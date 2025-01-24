public class Item {

    // Enum to define the rarity levels
    public enum Rarity {
        COMMON,
        GREAT,
        RARE,
        EPIC,
        LEGENDARY
    }

    private String name; // Name of the item
    private Rarity rarity; // Rarity of the item
    private int upgradeCount; // Upgrade count for EPIC items

    // Constructor
    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0; // Default upgrade count
    }

    // Getters
    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    // Increment upgrade count (specific to EPIC items)
    public void incrementUpgradeCount() {
        if (this.rarity == Rarity.EPIC) {
            this.upgradeCount++;
        } else {
            this.upgradeCount = 0; // Reset count for non-EPIC items
        }
    }

    // Display item details
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", rarity=" + rarity +
                ", upgradeCount=" + (rarity == Rarity.EPIC ? upgradeCount : "N/A") +
                '}';
    }
}
