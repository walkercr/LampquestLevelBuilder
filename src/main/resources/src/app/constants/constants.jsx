/**
 * newDragTypes identify draggable items that are dragged from the
 * dungeonBuilderMenu onto the dungeonGrid.
 */
export const newDragTypes = {
    NEW_ROOM: 'new_room',
    NEW_ITEM: 'new_item',
    NEW_MONSTER: 'new_monster',
    NEW_STAIRS: 'new_stair'
};

/**
 * existingDragTypes identify draggable items that currently exist on
 * the dungeonGrid.
 */
export const existingDragTypes = {
    ROOM: 'room',
    ITEM: 'item',
    MONSTER: 'monster',
    STAIRS: 'stair'
};

/**
 * Represents the size (in px) of 1 scalar unit for draggables and 
 * grid cells. ex: a room has a width: 3, height: 5, applying the unitSize
 * we get width: 3 * 25 px, height: 5 * 25 px.
 */
export const unitSize = 15;