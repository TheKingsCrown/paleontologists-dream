package tkc.paleontologistsdream;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tkc.paleontologistsdream.items.EmptySyringeItem;

public class ModItems {

    public static void initialize() {}

    public static final Item AMBER = register(new Item(new FabricItemSettings().group(ItemGroup.MISC)),
            "amber");
    public static final Item EMPTY_SYRINGE = register(new EmptySyringeItem(new FabricItemSettings().group(ItemGroup.MISC)),
            "empty_syringe");
    public static final Item ARTIODACTYL_SYRINGE = register(new Item(new Item.Settings().group(ItemGroup.MISC)),
            "artiodactyl_syringe");
    public static final Item PERISSODACTYL_SYRINGE = register(new Item(new Item.Settings().group(ItemGroup.MISC)),
            "perissodactyl_syringe");

    // Method to Register Items
    public static Item register(Item item, String id) {

        Identifier itemID = Identifier.of(PaleontologistsDream.MOD_ID, id);

        Item registeredItem = Registry.register(Registry.ITEM, itemID, item);

        return registeredItem;
    }
}
