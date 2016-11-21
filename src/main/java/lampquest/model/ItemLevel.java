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

    /**
     * composite key (all columns except numberInstances)
     */
    @EmbeddedId
    private ItemLevelKey key;
    /**
     * numberInstances column
     */
    private int numberInstances;

    /**
     * Constructs an empty ItemLevel.
     */
    public ItemLevel() {}

    /**
     * Constructs an ItemLevel with the given input.
     *
     * @param key composite key
     * @param numberInstances number of item instances
     */
    public ItemLevel(ItemLevelKey key, int numberInstances) {
        setKey(key);
        setNumberInstances(numberInstances);
    }

    /**
     * Returns the composite key.
     * @return composite key
     */
    public ItemLevelKey getKey() {
        return key;
    }

    /**
     * Sets the composite key.
     * @param key composite key
     */
    public void setKey(ItemLevelKey key) {
        this.key = key;
    }

    /**
     * Returns the number of item instances.
     * @return number of item instances
     */
    public int getNumberInstances() {
        return numberInstances;
    }

    /**
     * Sets the number of item instances.
     * @param numberInstances number of item instances
     */
    public void setNumberInstances(int numberInstances) {
        this.numberInstances = numberInstances;
    }
}
