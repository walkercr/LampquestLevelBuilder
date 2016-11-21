package lampquest.dto;

/**
 * Data transfer object for dirt contained in a dungeon level.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/19/2016
 */
public class DirtDto {

    /**
     * dirt x-position
     */
    private int dirtX;
    /**
     * dirt y-position
     */
    private int dirtY;

    /**
     * Constructs an empty DirtDto.
     */
    public DirtDto() {}

    /**
     * Constructs a DirtDto with the given input.
     *
     * @param dirtX dirt x-position
     * @param dirtY dirt y-position
     */
    public DirtDto(int dirtX, int dirtY) {
        setDirtX(dirtX);
        setDirtY(dirtY);
    }

    /**
     * Returns the dirt x-position
     * @return dirt x-position
     */
    public int getDirtX() {
        return dirtX;
    }

    /**
     * Sets the dirt x-position
     * @param dirtX dirt x-position
     */
    public void setDirtX(int dirtX) {
        this.dirtX = dirtX;
    }

    /**
     * Returns the dirt y-position
     * @return dirt y-position
     */
    public int getDirtY() {
        return dirtY;
    }

    /**
     * Sets the dirt y-position
     * @param dirtY dirt y-position
     */
    public void setDirtY(int dirtY) {
        this.dirtY = dirtY;
    }
}
