package lampquest.dto;

import lampquest.model.ItemLevel;
import lampquest.model.ItemLevelKey;

/**
 * Data transfer object for item level to mask model key attribute.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/26/2016
 */
public class ItemLevelDto {
    /**
     * item id
     */
    private int itemId;
    /**
     * dungeon id
     */
    private int dungeonId;
    /**
     * item x-position
     */
    private Integer itemX;
    /**
     * item y-position
     */
    private Integer itemY;
    /**
     * item z-position
     */
    private Integer itemZ;
    /**
     * number of item instances
     */
    private int numberInstances;

    /**
     * Constructs a new ItemLevelDto with the given ItemLevel.
     * @param itemLevel an item level entity
     */
    public ItemLevelDto(ItemLevel itemLevel) {
        ItemLevelKey key = itemLevel.getKey();
        this.itemId = key.getItemId();
        this.dungeonId = key.getDungeonId();
        this.itemX = key.getItemX();
        this.itemY = key.getItemY();
        this.itemZ = key.getItemZ();
        this.numberInstances = itemLevel.getNumberInstances();
    }

    /**
     * Returns the item id.
     * @return item id
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Returns the dungeon id.
     * @return dungeon id
     */
    public int getDungeonId() {
        return dungeonId;
    }

    /**
     * Returns the item x-position.
     * @return item x-position
     */
    public Integer getItemX() {
        return itemX;
    }

    /**
     * Returns the item y-position.
     * @return item y-position
     */
    public Integer getItemY() {
        return itemY;
    }

    /**
     * Returns the item z-position.
     * @return item z-position
     */
    public Integer getItemZ() {
        return itemZ;
    }

    /**
     * Returns the number of item instances.
     * @return number of item instances
     */
    public int getNumberInstances() {
        return numberInstances;
    }
}
