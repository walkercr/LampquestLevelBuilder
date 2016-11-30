package lampquest.model;

import javax.persistence.*;

/**
 * StaticMonsters entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/18/2016
 */
@Entity
@Table(name = "StaticMonsters")
public class StaticMonster {

    /**
     * composite key (all columns)
     */
    @EmbeddedId
    private StaticMonsterKey key;

    /**
     * Constructs an empty StaticMonster.
     */
    public StaticMonster() {}

    /**
     * Constructs a StaticMonster with the given key.
     *
     * @param key composite key
     */
    public StaticMonster(StaticMonsterKey key) {
       setKey(key);
    }

    /**
     * Returns the composite key.
     * @return composite key
     */
    public StaticMonsterKey getKey() {
        return key;
    }

    /**
     * Sets the composite key
     * @param key composite key
     */
    public void setKey(StaticMonsterKey key) {
        this.key = key;
    }
}
