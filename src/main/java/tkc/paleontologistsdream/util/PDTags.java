package tkc.paleontologistsdream.util;

import net.minecraft.entity.EntityType;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tkc.paleontologistsdream.PaleontologistsDream;

public class PDTags {
    public static class Entities {
        public static final TagKey<EntityType<?>> ENTITY_FAMILY_BOVIDAE =
                createTag("entity_family_BOVIDAE");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.of(Registry.ENTITY_TYPE_KEY, new Identifier(PaleontologistsDream.MOD_ID, name));
        }
    }
}
