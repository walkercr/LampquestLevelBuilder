package lampquest.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * RoomsLevels entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/2/2016
 */
@Entity
@Table(name = "ItemsLevels")
public class ItemLevel {

    @EmbeddedId
    private ItemLevelKey key;

    private int numberInstances;

    public ItemLevel() {}

    public ItemLevel(ItemLevelKey key, int numberInstances) {
        setKey(key);
        setNumberInstances(numberInstances);
    }

    public ItemLevelKey getKey() {
        return key;
    }

    public void setKey(ItemLevelKey key) {
        this.key = key;
    }

    public int getNumberInstances() {
        return numberInstances;
    }

    public void setNumberInstances(int numberInstances) {
        this.numberInstances = numberInstances;
    }
}
