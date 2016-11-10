package lampquest.dao;

import lampquest.model.Monster;

import java.util.List;

/**
 * Data access object interface for the Monsters table.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/9/2016
 */
public interface IMonstersDao {

    /**
     * Returns a list of all monsters in the database.
     *
     * @return a list of all monsters in the database
     */
    List<Monster> getAllMonsters();
}
