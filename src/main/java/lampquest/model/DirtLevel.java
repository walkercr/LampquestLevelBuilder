package lampquest.model;

import javax.persistence.*;

/**
 * RoomsLevels entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/2/2016
 */
@Entity
@Table(name = "DirtLevels")
public class DirtLevel {

    /**
     * composite key (all columns)
     */
    @EmbeddedId
    private DirtLevelKey key;

    /**
     * Constructs an empty DirtLevel.
     */
    public DirtLevel() {}

    /**
     * Constructs a DirtLevel with the given composite key.
     * @param key a composite key (all rows in table)
     */
    public DirtLevel(DirtLevelKey key) {
        setKey(key);
    }

    /**
     * Returns the composite key.
     * @return composite key
     */
    public DirtLevelKey getKey() {
        return key;
    }

    /**
     * Sets the composite key.
     * @param key composite key
     */
    public void setKey(DirtLevelKey key) {
        this.key = key;
    }
}
