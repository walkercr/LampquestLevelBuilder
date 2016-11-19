package lampquest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RoomsLevels entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/2/2016
 */
@Entity
@Table(name = "StairsLevels")
public class StairsLevel {

    private int stairsX;
    private int stairsY;
    private int stairsZ;
    private int dungeonId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stairsPK;

    public StairsLevel() {}

    public StairsLevel(int stairsX, int stairsY, int stairsZ, int dungeonId) {
        this.stairsX = stairsX;
        this.stairsY = stairsY;
        this.stairsZ = stairsZ;
        this.dungeonId = dungeonId;
    }

    public StairsLevel(int stairsX, int stairsY, int stairsZ, int dungeonId,
                       int stairsPK) {
        this(stairsX, stairsY, stairsZ, dungeonId);
        this.stairsPK = stairsPK;
    }

    public int getStairsX() {
        return stairsX;
    }

    public void setStairsX(int stairsX) {
        this.stairsX = stairsX;
    }

    public int getStairsY() {
        return stairsY;
    }

    public void setStairsY(int stairsY) {
        this.stairsY = stairsY;
    }

    public int getStairsZ() {
        return stairsZ;
    }

    public void setStairsZ(int stairsZ) {
        this.stairsZ = stairsZ;
    }

    public int getDungeonId() {
        return dungeonId;
    }

    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    public int getStairsPK() {
        return stairsPK;
    }

    public void setStairsPK(int stairsPK) {
        this.stairsPK = stairsPK;
    }
}
