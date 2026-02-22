package com.exemplo.todo.service;

import com.exemplo.todo.dao.TodoDAO;
import com.exemplo.todo.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDAO todoDAO;

    public void salvar(Todo todo) {
        todoDAO.salvar(todo);
    }

    public void atualizar(Todo todo) {
        todoDAO.atualizar(todo);
    }

    public void excluir(Integer id) {
        todoDAO.excluir(id);
    }

    @Transactional(readOnly = true)
    public Todo buscarPorId(Integer id) {
        return todoDAO.buscarPorId(id);
    }

    @Transactional(readOnly = true)
    public List<Todo> listarTodos() {
        return todoDAO.listarTodos();
    }
}
