package lampquest.exceptions;

/**
 * Thrown when an attempt is made to access a dungeon that does not exist.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public class DungeonNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new DungeonNotFoundException with the given detail message.
     *
     * @param message detail message
     */
    public DungeonNotFoundException(String message) {
        super(message);
    }
}
