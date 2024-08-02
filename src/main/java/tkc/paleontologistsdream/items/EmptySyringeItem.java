package tkc.paleontologistsdream.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tkc.paleontologistsdream.families.json.FamilyAssignmentManager;

public class EmptySyringeItem extends Item {
    public EmptySyringeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(hand.equals(Hand.MAIN_HAND) && entity.isLiving()) {
            /* user.sendMessage(Text.of(Registry.ENTITY_TYPE.getId(entity.getType()).toString()));
            user.sendMessage(Text.of(Registry.ITEM.getId(stack.getItem()).toString()));
            Identifier identifier = Registry.ITEM.getId(ModItems.AMBER.asItem()); */
            Identifier entityID = new Identifier(Registry.ENTITY_TYPE.getId(entity.getType()).toString());
            ItemStack itemStack = getSyringeType(entityID);
            if (itemStack == null) {
                user.sendMessage(Text.of("Cannot extract blood from subject"), true);
            }
            ItemUsage.exchangeStack(stack, user, itemStack);

            return super.useOnEntity(stack, user, entity, hand);

        }
        else {
            return ActionResult.FAIL;
        }
    }
    private static ItemStack getSyringeType(Identifier entityID) {
        if (FamilyAssignmentManager.FamilyAssignments.containsKey(entityID)) {
            // TODO: Fix crash when right clicking LivingEntity that has no family assigned, with the empty syringe.
            Identifier syringeID = new Identifier(FamilyAssignmentManager.FamilyAssignments.get(entityID).toString());
            return new ItemStack(Registry.ITEM.get(syringeID));
        } else {
            return null;
        }
    }
}
