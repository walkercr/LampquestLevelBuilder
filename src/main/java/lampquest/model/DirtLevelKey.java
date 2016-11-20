package lampquest.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Composite key for DirtLevel entity object.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/18/2016
 */
@Embeddable
public class DirtLevelKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private int dungeonId;
    private int dirtX;
    private int dirtY;
    private int dirtZ;

    public DirtLevelKey() {}

    public DirtLevelKey(int dungeonId, int dirtX, int dirtY, int dirtZ) {
        this.dungeonId = dungeonId;
        this.dirtX = dirtX;
        this.dirtY = dirtY;
        this.dirtZ = dirtZ;
    }

    public int getDungeonId() {
        return dungeonId;
    }

    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    public int getDirtX() {
        return dirtX;
    }

    public void setDirtX(int dirtX) {
        this.dirtX = dirtX;
    }

    public int getDirtY() {
        return dirtY;
    }

    public void setDirtY(int dirtY) {
        this.dirtY = dirtY;
    }

    public int getDirtZ() {
        return dirtZ;
    }

    public void setDirtZ(int dirtZ) {
        this.dirtZ = dirtZ;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DirtLevelKey)) {
            return false;
        }
        DirtLevelKey key = (DirtLevelKey) obj;

        return (dungeonId == key.dungeonId) && (dirtX == key.dirtX)
                && (dirtY == key.dirtY) && (dirtZ == key.dirtZ);
    }

    @Override
    public int hashCode() {
        return 13 * dungeonId + 17 * dirtX + 23 * dirtY + 31 * dirtZ;
    }
}
