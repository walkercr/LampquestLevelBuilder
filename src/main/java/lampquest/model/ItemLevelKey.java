package lampquest.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Composite key for ItemLevel entity object.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/20/2016
 */
@Embeddable
public class ItemLevelKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * item id (ItemsLevels itemId column)
     */
    private int itemId;
    /**
     * dungeon id (ItemsLevels dungeonId column)
     */
    private int dungeonId;
    /**
     * item x-position (ItemsLevels itemX column)
     */
    private Integer itemX;
    /**
     * item y-position (ItemsLevels itemY column)
     */
    private Integer itemY;
    /**
     * item z-position (ItemsLevels itemZ column)
     */
    private Integer itemZ;

    /**
     * Constructs an empty ItemLevelKey.
     */
    public ItemLevelKey() {}

    /**
     * Constructs an ItemLevelKey with the given input.
     *
     * @param itemId item id
     * @param dungeonId dungeon id
     * @param itemX item x-position
     * @param itemY item y-position
     * @param itemZ item z-position
     */
    public ItemLevelKey(int itemId, int dungeonId, Integer itemX,
                        Integer itemY, Integer itemZ) {
        setItemId(itemId);
        setDungeonId(dungeonId);
        setItemX(itemX);
        setItemY(itemY);
        setItemZ(itemZ);
    }

    /**
     * Returns the item id.
     * @return item id
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets the item id.
     * @param itemId item id
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * Returns the dungeon id.
     * @return dungeon id
     */
    public int getDungeonId() {
        return dungeonId;
    }

    /**
     * Sets the dungeon id.
     * @param dungeonId dungeon id
     */
    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    /**
     * Returns the item x-position.
     * @return item x-position
     */
    public Integer getItemX() {
        return itemX;
    }

    /**
     * Sets the item x-position.
     * @param itemX item x-position
     */
    public void setItemX(Integer itemX) {
        this.itemX = itemX;
    }

    /**
     * Returns the item y-position.
     * @return item y-position
     */
    public Integer getItemY() {
        return itemY;
    }

    /**
     * Sets the item y-position.
     * @param itemY item y-position
     */
    public void setItemY(Integer itemY) {
        this.itemY = itemY;
    }

    /**
     * Returns the item z-position.
     * @return item z-position
     */
    public Integer getItemZ() {
        return itemZ;
    }

    /**
     * Sets the item z-position.
     * @param itemZ item z-position
     */
    public void setItemZ(Integer itemZ) {
        this.itemZ = itemZ;
    }

    /**
     * Compares this and the given object for equality.
     * @param obj object to be compared
     * @return true for identical shallow comparison, otherwise false
     */
    @Override
    public boolean equals(Object obj) {

        // return false if given object is not a DItemLevelKey
        if (!(obj instanceof ItemLevelKey)) {
            return false;
        }

        // otherwise, return boolean result of shallow comparison
        ItemLevelKey key = (ItemLevelKey) obj;
        return (itemId == key.itemId)
                && (dungeonId == key.dungeonId)
                && (isEqual(itemX, key.itemX))
                && (isEqual(itemY, key.itemY))
                && (isEqual(itemZ, key.itemZ));
    }

    /**
     * Returns true if Integer a is equal to Integer b.
     *
     * @param a an Integer to be compared for equality
     * @param b an Integer to be compared for equality
     *
     * @return true if a is equal to b, otherwise false
     */
    private boolean isEqual(Integer a, Integer b) {

        // if a and b are both null, return true
        if ((a == null) && (b == null)) {
            return true;

        // otherwise, if only one is null, return false
        } else if ((a == null) || (b == null)) {
            return false;

        // otherwise, both are non-null, so return equality value-comparison
        } else {
            return a.equals(b);
        }
    }

    /**
     * Returns a computed hash code for this ItemLevelKey.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return 13 * itemId + 17 * dungeonId + itemX.hashCode()
                + itemY.hashCode() + itemZ.hashCode();
    }
}
