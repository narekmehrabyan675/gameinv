import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomItemGenerator {
    private static final Random random = new Random();

    public static Item generateRandomItem() {
        int chance = random.nextInt(100) + 1;

        Item.Rarity rarity;
        if (chance <= 50) {
            rarity = Item.Rarity.COMMON; // 50%
        } else if (chance <= 75) {
            rarity = Item.Rarity.GREAT; // 25%
        } else if (chance <= 90) {
            rarity = Item.Rarity.RARE; // 15%
        } else if (chance <= 98) {
            rarity = Item.Rarity.EPIC; // 8%
        } else {
            rarity = Item.Rarity.LEGENDARY; // 2%
        }


        String name = getNameByRarity(rarity);


        return new Item(name, rarity);
    }


    private static String getNameByRarity(Item.Rarity rarity) {
        switch (rarity) {
            case COMMON:
                return "Sword";
            case GREAT:
                return "Shield";
            case RARE:
                return "Wand";
            case EPIC:
                return "Bow";
            case LEGENDARY:
                return "Staff";
            default:
                return "Unknown";
        }
    }
    //After update rarity we change name of sword
    public static void updateItemNameByRarity(Item item) {
        switch (item.getRarity()) {
            case COMMON:
                item.setName("Sword");
                break;
            case GREAT:
                item.setName("Shield");
                break;
            case RARE:
                item.setName("Wand");
                break;
            case EPIC:
                item.setName("Bow");
                break;
            case LEGENDARY:
                item.setName("Staff");
                break;
            default:
                item.setName("Unknown");
        }
    }
}
