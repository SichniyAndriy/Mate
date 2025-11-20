package mate.academy.obsapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import mate.academy.obsapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final EntityManagerFactory emf;

    public BookRepositoryImpl(@Autowired EntityManagerFactory factory) {
        this.emf = factory;
    }

    @Override
    public Book save(Book book) {
        EntityTransaction transaction = null;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(book);
            transaction.commit();
        } catch (Exception e) {
            assert transaction != null;
            if (transaction.isActive()) {
                transaction.rollback();
            } else {
                RuntimeException rex = new RuntimeException("Rollback failed. Trace follows: ", e);
                rex.printStackTrace(System.err);
            }
            throw new RuntimeException("Cannot insert book to DB", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Book> criteria = cb.createQuery(Book.class);
            Root<Book> root = criteria.from(Book.class);
            criteria.select(root).where(cb.equal(root.get("title"),"aaa"));
            TypedQuery<Book> query = em.createQuery(criteria);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Cannot get all books from DB", e);
        }
    }
}
