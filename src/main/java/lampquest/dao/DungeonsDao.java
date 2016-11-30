package lampquest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import lampquest.model.Dungeon;

/**
 * Data access object implementation for the Dungeon entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public class DungeonsDao extends LampquestDao<Dungeon>
                         implements IDungeonsDao {

    /**
     * Creates a new DungeonsDaoImpl with the given database session factory.
     *
     * @param sessionFactory database session factory
     */
    public DungeonsDao(SessionFactory sessionFactory) {
        super(sessionFactory, Dungeon.class);
    }

    /**
     * Updates boss-specific values for the dungeon with the given dungeon id.
     *
     * @param dungeonId dungeon id of dungeon to be updated
     * @param boss update value of boss
     * @param bossX update value of bossX
     * @param bossY update value of bossY
     * @param bossZ update value of bossZ
     */
    @Override
    @Transactional
    public void updateBoss(int dungeonId, int boss, int bossX, int bossY,
                           int bossZ) {

        // load current value of dungeon with the given dungeon id
        Session session = sessionFactory.getCurrentSession();
        Dungeon dungeon = session.load(Dungeon.class, dungeonId);

        // set update values on loaded dungeon
        dungeon.setBoss(boss);
        dungeon.setBossX(bossX);
        dungeon.setBossY(bossY);
        dungeon.setBossZ(bossZ);

        // save updated dungeon to database
        session.update(dungeon);
    }
}
