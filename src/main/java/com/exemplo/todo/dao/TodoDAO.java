package com.exemplo.todo.dao;

import com.exemplo.todo.entity.Todo;
import java.util.List;

public interface TodoDAO {
    void salvar(Todo todo);
    void atualizar(Todo todo);
    void excluir(Integer id);
    Todo buscarPorId(Integer id);
    List<Todo> listarTodos();
}
