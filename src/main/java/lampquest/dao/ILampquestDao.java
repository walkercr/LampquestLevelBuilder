package lampquest.dao;

import java.util.List;

/**
 * Data access object interface for lampquest entities.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/19/2016
 */
public interface ILampquestDao<T> {

    /**
     * Returns all rows in a mapped entity class table.
     *
     * @return list of all rows in the table
     */
    List<T> getAllRows();
}
