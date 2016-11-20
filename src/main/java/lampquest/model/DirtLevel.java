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
    @EmbeddedId
    private DirtLevelKey key;

    public DirtLevel() {}

    public DirtLevel(DirtLevelKey key) {
        setKey(key);
    }

    public DirtLevelKey getKey() {
        return key;
    }

    public void setKey(DirtLevelKey key) {
        this.key = key;
    }
}
