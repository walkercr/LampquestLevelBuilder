package lampquest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Items entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 12/1/2016
 */
@Entity
@Table(name = "Items")
public class Item {

    /**
     * itemId column (primary key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    /**
     * itemName column
     */
    private String itemName;
    /**
     * itemChar column
     */
    private Character itemChar;
    /**
     * itemColor column
     */
    private String itemColor;
    /**
     * edible column
     */
    private Character edible;
    /**
     * wearable column
     */
    private Character wearable;
    /**
     * wieldable column
     */
    private Character wieldable;

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
     * Returns the item name.
     * @return item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the item name.
     * @param itemName item name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Returns the item character.
     * @return item character
     */
    public Character getItemChar() {
        return itemChar;
    }

    /**
     * Sets the item character.
     * @param itemChar item character
     */
    public void setItemChar(Character itemChar) {
        this.itemChar = itemChar;
    }

    /**
     * Returns the item color.
     * @return item color
     */
    public String getItemColor() {
        return itemColor;
    }

    /**
     * Sets the item color.
     * @param itemColor item color
     */
    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    /**
     * Returns the edible status of the item.
     * @return edible status
     */
    public Character getEdible() {
        return edible;
    }

    /**
     * Sets the edible status of the item.
     * @param edible edible status
     */
    public void setEdible(Character edible) {
        this.edible = edible;
    }

    /**
     * Returns the wearable status of the item.
     * @return wearable status
     */
    public Character getWearable() {
        return wearable;
    }

    /**
     * Sets the wearable status of the item.
     * @param wearable wearable status
     */
    public void setWearable(Character wearable) {
        this.wearable = wearable;
    }

    /**
     * Returns the wieldable status of the item.
     * @return wieldable status of the item
     */
    public Character getWieldable() {
        return wieldable;
    }

    /**
     * Sets the wieldable status of the item.
     * @param wieldable wieldable status
     */
    public void setWieldable(Character wieldable) {
        this.wieldable = wieldable;
    }
}
