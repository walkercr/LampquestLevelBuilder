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

    @EmbeddedId
    private StaticMonsterKey key;

    public StaticMonster() {}

    public StaticMonster(StaticMonsterKey key) {
       setKey(key);
    }

    public StaticMonsterKey getKey() {
        return key;
    }

    public void setKey(StaticMonsterKey key) {
        this.key = key;
    }
}
