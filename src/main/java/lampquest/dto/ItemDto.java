package lampquest.dto;

/**
 * Data transfer object for an item contained in a dungeon level.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/20/2016
 */
public class ItemDto {

    /**
     * item id
     */
    private int itemId;
    /**
     * item x-position
     */
    private Integer itemX;
    /**
     * item y-position
     */
    private Integer itemY;
    /**
     * number of item instances at given position
     */
    private int numberInstances;

    /**
     * Constructs an empty ItemDto .
     */
    public ItemDto() {}

    /**
     * Constructs an ItemDto with the given input.
     *
     * @param itemId item id
     * @param itemX item x-position
     * @param itemY item y-position
     * @param numberInstances number of item instances at given position
     */
    public ItemDto(int itemId, Integer itemX, Integer itemY,
                   int numberInstances) {
        setItemId(itemId);
        setItemX(itemX);
        setItemY(itemY);
        setNumberInstances(numberInstances);
    }

    /**
     * Returns the item id.
     * @return item id
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets the item id.
     * @param itemId item id
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * Returns the item x-position.
     * @return item x-position
     */
    public Integer getItemX() {
        return itemX;
    }

    /**
     * Sets the item x-position.
     * @param itemX item x-position
     */
    public void setItemX(Integer itemX) {
        this.itemX = itemX;
    }

    /**
     * Returns the item y-position.
     * @return item y-position
     */
    public Integer getItemY() {
        return itemY;
    }

    /**
     * Sets the item y-position.
     * @param itemY item y-position
     */
    public void setItemY(Integer itemY) {
        this.itemY = itemY;
    }

    /**
     * Returns the number of item instances at the given position.
     * @return number of item instances
     */
    public int getNumberInstances() {
        return numberInstances;
    }

    /**
     * Sets the number of item instances at the given position.
     * @param numberInstances number of item instances
     */
    public void setNumberInstances(int numberInstances) {
        this.numberInstances = numberInstances;
    }
}
