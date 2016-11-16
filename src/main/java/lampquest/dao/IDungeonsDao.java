package lampquest.dao;

import lampquest.model.Dungeon;

import java.util.List;

/**
 * Data access object interface for the Dungeons table.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public interface IDungeonsDao {

    /**
     * Returns a list of the dungeons in the database.
     *
     * @return list of dungeons in database
     */
    List<Dungeon> getAllDungeons();

    /**
     * Returns the dungeon associated with the given id
     *
     * @param dungeonId the dungeon id of the intended dungeon
     *
     * @return the dungeon associated with the given id
     */
    Dungeon getDungeon(int dungeonId);
}
