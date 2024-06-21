package org.example;

import org.example.dao.AuthorDao;
import org.example.dao.impl.AuthorDaoImpl;
import org.example.model.Author;
import org.example.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        /*
         * Steps to reproduce:
         * 1. Add dependencies hibernate-cache
         * 2. Add  properties:
         * - hibernate.cache.use_second_level_cache
         * - hibernate.cache.region.factory_class
         * 3. Add annotations
         * - @Cacheable
         * - @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
         * 4. Call method 'authorDao.get(1L);' twice
         * 5. See how many selects will be displayed in logs
         * */

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        AuthorDao authorDao = new AuthorDaoImpl(sessionFactory);

        Author agatha = new Author("Agatha Cristie");
        Author lesya = new Author("Lesia Ukrainka");
        Author victor = new Author("Victor Hugo");

        authorDao.save(agatha);
        authorDao.save(lesya);
        authorDao.save(victor);

        Author authorFromDB = authorDao.get(1L);
        Author anotherAuthorFromDB = authorDao.get(1L);

        System.out.println(authorFromDB);
        System.out.println(anotherAuthorFromDB);
        sessionFactory.close();
    }
}