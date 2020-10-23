package org.aurorus.furryrp.objects;

import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.UUID;

public class SelectedEntity {
    public static ArrayList<SelectedEntity> selectedEntity = new ArrayList<>();
    public UUID id;
    public Entity selected;
    public String selectedName;

    public SelectedEntity(UUID id, Entity selected, String selectedName){
        this.id = id;
        this.selected = selected;
        this.selectedName = selectedName;
    }
}
