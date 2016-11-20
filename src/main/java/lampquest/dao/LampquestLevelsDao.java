package lampquest.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Data access object implementation for lampquest levels-type entities.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/19/2016
 */
public class LampquestLevelsDao<T> extends LampquestDao<T>
                                   implements ILampquestLevelsDao<T> {

    /**
     * name of mapped entity
     */
    private final String mappedEntity;
    /**
     * reference string to entity mapped dungeon id property
     */
    private final String dungeonIdRef;
    /**
     * reference string to entity mapped level property
     */
    private final String levelRef;

    /**
     * Creates a new LampquestLevelsDao with the given database session factory.
     *
     * @param sessionFactory database session factory
     * @param entityClass entity class
     * @param mappedEntity name of mapped entity
     * @param dungeonIdRef reference string to entity mapped dungeon id property
     * @param levelRef reference string to entity mapped level property
     */
    public LampquestLevelsDao(SessionFactory sessionFactory,
                              Class<T> entityClass,
                              String mappedEntity,
                              String dungeonIdRef,
                              String levelRef) {

        super(sessionFactory, entityClass);
        this.mappedEntity = mappedEntity;
        this.dungeonIdRef = dungeonIdRef;
        this.levelRef = levelRef;
    }

    /**
     * Returns all rows in the mapped entity table that contain the given
     * dungeon id.
     *
     * @param dungeonId dungeon id of rows to be retrieved
     *
     * @return list of rows in the mapped entity table containing the given
     *     dungeon id
     */
    @Override
    @Transactional
    public List<T> getRows(int dungeonId) {

        // retrieve the rows containing the given dungeon id
        @SuppressWarnings("unchecked")
        List<T> rows = sessionFactory.getCurrentSession()
                .createCriteria(entityClass)
                .add(Restrictions.eq(dungeonIdRef, dungeonId))
                .list();

        return rows;
    }

    /**
     * Deletes all rows in the mapped entity table that contain the
     * given dungeon id and level.
     *
     * @param dungeonId dungeon id of rows to be deleted
     * @param level level of rows to be deleted
     */
    @Override
    @Transactional
    public void deleteRows(int dungeonId, int level) {

        // create an hql query specifying the rows to be deleted
        String hql = "delete " + mappedEntity + " e "
                   + "where e." + dungeonIdRef + " = :dungeonId "
                   + "and e." + levelRef + " = :level";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        // set query parameters and execute the delete statement
        query.setParameter("dungeonId", dungeonId);
        query.setParameter("level", level);
        query.executeUpdate();
    }

    /**
     * Inserts the given rows into the mapped entity table.
     *
     * @param rows rows to be inserted
     */
    @Override
    @Transactional
    public void insertRows(List<T> rows) {
        Session session = sessionFactory.getCurrentSession();
        rows.forEach(session::save);
    }
}
