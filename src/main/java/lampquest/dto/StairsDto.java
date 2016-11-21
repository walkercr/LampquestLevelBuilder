package lampquest.dto;

/**
 * Data transfer object for stairs contained in a dungeon level.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/9/2016.
 */
public class StairsDto {

    /**
     * stairs x-position
     */
    private int stairsX;
    /**
     * stairs y-position
     */
    private int stairsY;

    /**
     * Constructs an empty StairsDto.
     */
    public StairsDto() {}

    /**
     * Constructs a StairsDto with the given input.
     *
     * @param stairsX stairs x-position
     * @param stairsY stairs y-position
     */
    public StairsDto(int stairsX, int stairsY) {
        setStairsX(stairsX);
        setStairsY(stairsY);
    }

    /**
     * Returns the stairs x-position
     * @return stairs x-position
     */
    public int getStairsX() {
        return stairsX;
    }

    /**
     * Sets the stairs x-position.
     * @param stairsX stairs x-position
     */
    public void setStairsX(int stairsX) {
        this.stairsX = stairsX;
    }

    /**
     * Returns the stairs y-position.
     * @return stairs y-position
     */
    public int getStairsY() {
        return stairsY;
    }

    /**
     * Sets the stairs y-position.
     * @param stairsY stairs y-position
     */
    public void setStairsY(int stairsY) {
        this.stairsY = stairsY;
    }
}
