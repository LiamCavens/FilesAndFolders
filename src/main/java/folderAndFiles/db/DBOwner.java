package folderAndFiles.db;

import folderAndFiles.models.File;
import folderAndFiles.models.Folder;
import folderAndFiles.models.Owner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBOwner {

    private static Transaction transaction;
    private static Session session;

    public static List<Folder> getFoldersOwnerHas(Owner owner){
        session = db.HibernateUtil.getSessionFactory().openSession();
        List<Folder> results = null;
        try{
            Criteria criteria = session.createCriteria(Folder.class);
            criteria.add(Restrictions.eq("owner", owner));
            results = criteria.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } session.close();
        return results;
    }
}
