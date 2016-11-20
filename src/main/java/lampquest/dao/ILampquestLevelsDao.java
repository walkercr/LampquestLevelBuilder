package lampquest.dao;

import java.util.List;

/**
 * Data access object interface for lampquest levels-type entities.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/19/2016
 */
public interface ILampquestLevelsDao<T> {

    /**
     * Returns all rows that contain the given dungeon id.
     *
     * @param dungeonId dungeon id of rows to be retrieved
     *
     * @return list of rows containing the given dungeon id
     */
    List<T> getRows(int dungeonId);

    /**
     * Deletes all rows that contain the given dungeon id and level.
     *
     * @param dungeonId dungeon id of rows to be deleted
     * @param level level of rows to be deleted
     */
    void deleteRows(int dungeonId, int level);

    /**
     * Inserts the given rows.
     *
     * @param rows rows to be inserted
     */
    void insertRows(List<T> rows);
}
