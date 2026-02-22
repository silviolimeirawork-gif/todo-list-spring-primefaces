package com.exemplo.todo.dao;

import com.exemplo.todo.entity.Todo;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TodoDAOImpl implements TodoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Todo todo) {
        entityManager.persist(todo);
    }

    public void atualizar(Todo todo) {
        entityManager.merge(todo);
    }

    public void excluir(Integer id) {
        Todo todo = buscarPorId(id);
        if (todo != null) {
            entityManager.remove(todo);
        }
    }

    public Todo buscarPorId(Integer id) {
        return entityManager.find(Todo.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Todo> listarTodos() {
        Query query = entityManager.createQuery("from Todo t order by t.dataAlvo");
        return query.getResultList();
    }
}
