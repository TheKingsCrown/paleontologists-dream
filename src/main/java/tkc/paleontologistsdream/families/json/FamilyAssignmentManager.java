package tkc.paleontologistsdream.families.json;

import com.google.gson.Gson;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import tkc.paleontologistsdream.PaleontologistsDream;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class FamilyAssignmentManager implements SimpleSynchronousResourceReloadListener {
    private static final String RESOURCE_LOCATION = "entity_assignment";
    private final FamilyAssignmentSerializer SERIALIZER = new FamilyAssignmentSerializer();
    public static Map<Identifier, Identifier> FamilyAssignments = new HashMap<>();


    @Override
    public Identifier getFabricId() {
        return new Identifier(PaleontologistsDream.MOD_ID, RESOURCE_LOCATION);
    }

    @Override
    public void reload(ResourceManager manager) {
        FamilyAssignments.clear();
        manager.findResources(RESOURCE_LOCATION, path -> path.getPath().endsWith(".json")).forEach((id,resource) -> {
            try (InputStream stream = resource.getInputStream()) {
                Reader reader = new InputStreamReader(stream);
                FamilyAssignments.putAll(SERIALIZER.read(id,new Gson().fromJson(reader,FamilyAssignmentJson.class)));
            } catch (Exception e) {
                PaleontologistsDream.LOGGER.error("error while loading json", e);
            }
        });
    }
}
