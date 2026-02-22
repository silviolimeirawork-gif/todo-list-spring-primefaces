package com.exemplo.todo.controller;

import com.exemplo.todo.entity.Todo;
import com.exemplo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Controller
@Scope("session")
public class TodoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private transient TodoService todoService;

    private List<Todo> todos;
    private Todo todo;

    public TodoBean() {
        System.out.println(">>> TodoBean instanciado! <<<");
    }

    @PostConstruct
    public void init() {
        System.out.println(">>> @PostConstruct TodoBean <<<");
        novo();
        carregarTodos();
    }

    public void carregarTodos() {
        if (todoService != null) {
            todos = todoService.listarTodos();
        } else {
            System.err.println(">>> ERRO: todoService é null! <<<");
        }
    }

    public void novo() {
        todo = new Todo();
    }

    public void salvar() {
        if (todo.getId() == null) {
            todoService.salvar(todo);
        } else {
            todoService.atualizar(todo);
        }
        novo();
        carregarTodos();
    }

    public void editar(Todo todo) {
        this.todo = todo;
    }

    public void excluir(Integer id) {
        todoService.excluir(id);
        carregarTodos();
    }

    public void concluir(Todo todo) {
        todo.setConcluido(!todo.isConcluido());
        todoService.atualizar(todo);
        carregarTodos();
    }

    // Getters e Setters
    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }
}