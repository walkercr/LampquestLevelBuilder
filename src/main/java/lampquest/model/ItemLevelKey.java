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

    private int itemId;
    private int dungeonId;
    private Integer itemX;
    private Integer itemY;
    private Integer itemZ;

    public ItemLevelKey() {}

    public ItemLevelKey(int itemId, int dungeonId, Integer itemX,
                        Integer itemY, Integer itemZ) {
        this.itemId = itemId;
        this.dungeonId = dungeonId;
        this.itemX = itemX;
        this.itemY = itemY;
        this.itemZ = itemZ;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getDungeonId() {
        return dungeonId;
    }

    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    public Integer getItemX() {
        return itemX;
    }

    public void setItemX(Integer itemX) {
        this.itemX = itemX;
    }

    public Integer getItemY() {
        return itemY;
    }

    public void setItemY(Integer itemY) {
        this.itemY = itemY;
    }

    public Integer getItemZ() {
        return itemZ;
    }

    public void setItemZ(Integer itemZ) {
        this.itemZ = itemZ;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ItemLevelKey)) {
            return false;
        }
        ItemLevelKey key = (ItemLevelKey) obj;

        return (itemId == key.itemId)
                && (dungeonId == key.dungeonId)
                && (isEqual(itemX, key.itemX))
                && (isEqual(itemY, key.itemY))
                && (isEqual(itemZ, key.itemZ));
    }

    private boolean isEqual(Integer a, Integer b) {
        if ((a == null) && (b == null)) {
            return true;
        } else if ((a == null) || (b == null)) {
            return false;
        } else {
            return a.equals(b);
        }
    }

    @Override
    public int hashCode() {
        return 13 * itemId + 17 * dungeonId + itemX.hashCode()
                + itemY.hashCode() + itemZ.hashCode();
    }
}
