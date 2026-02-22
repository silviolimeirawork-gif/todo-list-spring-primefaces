package com.exemplo.todo.service;

import com.exemplo.todo.entity.Todo;
import java.util.List;

public interface TodoService {
    void salvar(Todo todo);
    void atualizar(Todo todo);
    void excluir(Integer id);
    Todo buscarPorId(Integer id);
    List<Todo> listarTodos();
}
