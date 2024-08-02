package tkc.paleontologistsdream.families.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.Identifier;
import tkc.paleontologistsdream.PaleontologistsDream;

import java.util.HashMap;
import java.util.Map;

public class FamilyAssignmentSerializer {
    Map<Identifier, Identifier> read(Identifier id, FamilyAssignmentJson faJson) {

        if  (faJson.syringe == null) {
            throw new JsonSyntaxException("Family Assignment " + id + " must have a syringe item");
        }
        if (faJson.entities == null) {
            throw new JsonSyntaxException("Family Assignment " + id + " has no entities in list");
        }

        Map<Identifier, Identifier> assignments = new HashMap<>();
        Identifier family = new Identifier(faJson.syringe);
        int i = 0;
        for (JsonElement entry : faJson.entities) {

            try {
                assignments.put(new Identifier(entry.getAsString()), family);
            } catch (Exception e) {
                PaleontologistsDream.LOGGER.error("Error parsing entry no. " + i + " in " + id.toString() + "'s entity list");
            }
        }
        return assignments;
    }
}
