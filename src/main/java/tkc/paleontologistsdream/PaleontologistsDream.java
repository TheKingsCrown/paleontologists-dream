package tkc.paleontologistsdream;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tkc.paleontologistsdream.families.json.FamilyAssignmentManager;

public class PaleontologistsDream implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("paleontologists-dream");
	public static final String MOD_ID = "paleontologists-dream";

	@Override
	public void onInitialize() {

		ModItems.initialize();
		ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new FamilyAssignmentManager());
	}
}