package lampquest.dao;

import lampquest.dto.StairsDto;
import lampquest.model.StairsLevel;

import java.util.List;

/**
 * Data access object interface for the StairsLevels table.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/18/2016
 */
public interface IStairsLevelsDao {

    List<StairsLevel> getStairsLevels(int dungeonId);
    void deleteStairsLevels(int dungeonId, int level);
    void insertStairsLevels(List<StairsLevel> stairs);
}
