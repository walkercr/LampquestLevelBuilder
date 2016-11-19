package lampquest.dao;

import lampquest.model.StaticMonster;

import java.util.List;

/**
 * Created by Craig on 11/18/2016.
 */
public interface IStaticMonstersDao {

    List<StaticMonster> getStaticMonsters(int dungeonId);
    void deleteStaticMonsters(int dungeonId, int level);
    void insertStaticMonsters(List<StaticMonster> staticMonsters);
}
