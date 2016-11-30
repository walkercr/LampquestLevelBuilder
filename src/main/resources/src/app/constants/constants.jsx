/**
 * newDragTypes identify draggable items that are dragged from the
 * dungeonBuilderMenu onto the dungeonGrid.
 */
export const newDragTypes = {
    NEW_ROOM: 'new_room',
    NEW_ITEM: 'new_item',
    NEW_MONSTER: 'new_monster',
    NEW_STAIRS: 'new_stairs'
};

/**
 * existingDragTypes identify draggable items that currently exist on
 * the dungeonGrid.
 */
export const existingDragTypes = {
    ROOM: 'room',
    ITEM: 'item',
    MONSTER: 'monster',
    STAIRS: 'stairs'
};

/**
 * Represents the default size (px) of grid cells on the dungeonGrid. Also
 * acts as a scalar value for determining the height/width of 
 * rooms/monsters/items/stairs.
 */
export const DEFAULT_CELL_SIZE = 25;

/**
 * The offset from the top left corner where the draggable item
 * should anchor to the mouse.
 */
export const DRAG_ANCHOR_OFFSET = 25 / 12;