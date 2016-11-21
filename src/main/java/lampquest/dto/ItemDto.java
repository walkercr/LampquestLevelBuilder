package lampquest.dto;

/**
 * Created by Craig on 11/20/2016.
 */
public class ItemDto {

    private int itemId;
    private Integer itemX;
    private Integer itemY;
    private int numberInstances;

    public ItemDto() {}

    public ItemDto(int itemId, Integer itemX, Integer itemY,
                   int numberInstances) {
        setItemId(itemId);
        setItemX(itemX);
        setItemY(itemY);
        setNumberInstances(numberInstances);
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Integer getItemX() {
        return itemX;
    }

    public void setItemX(Integer itemX) {
        this.itemX = itemX;
    }

    public Integer getItemY() {
        return itemY;
    }

    public void setItemY(Integer itemY) {
        this.itemY = itemY;
    }

    public int getNumberInstances() {
        return numberInstances;
    }

    public void setNumberInstances(int numberInstances) {
        this.numberInstances = numberInstances;
    }
}
