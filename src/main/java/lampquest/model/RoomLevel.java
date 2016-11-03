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
@Table(name = "RoomsLevels")
public class RoomLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomPK;

    private int dungeonId;
    private int depth;
    private int roomId;
    private int startX;
    private int startY;

    public int getRoomPK() {
        return roomPK;
    }

    public int getDungeonId() {
        return dungeonId;
    }

    public int getDepth() {
        return depth;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
}
