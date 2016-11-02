package lampquest.exceptions;

/**
 * Thrown when an attempt is made to add a dungeon level that already exists in
 * the database.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public class DungeonLevelExistsException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new DungeonLevelExistsException with the given detail message.
     *
     * @param message detail message
     */
    public DungeonLevelExistsException(String message) {
        super(message);
    }
}
