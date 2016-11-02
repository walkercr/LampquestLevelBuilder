package lampquest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rooms entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
@Entity
@Table(name = "Rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    
    private String roomName;
    private int roomWidth;
    private int roomHeight;

    public int getRoomId() {
        return roomId;
    }
    
    public String getRoomName() {
        return roomName;
    }
    
    public int getRoomWidth() {
        return roomWidth;
    }
    
    public int getRoomHeight() {
        return roomHeight;
    }
}

