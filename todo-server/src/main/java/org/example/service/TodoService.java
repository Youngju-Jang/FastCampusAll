package org.example.service;

import lombok.AllArgsConstructor;
import org.example.repository.model.TodoModel;
import org.example.repository.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    //    1. 목록에 아이템 추가
    public TodoModel add(TodoRequest request) {
        TodoModel todoModel = new TodoModel();
        todoModel.setTitle(request.getTitle());
        todoModel.setOrder(request.getOrder());
        todoModel.setCompleted(request.getCompleted());

        return this.todoRepository.save(todoModel); // <S extends T> S save(S entity);  >>> TodoEntity값 return함
    }
    //    2. 목록 중 특정 아이템 조회
    public TodoModel searchById(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));  //>>>>@@@@@@
    }
    //    3. 전체 목록 조회
    public List<TodoModel> searchAll() {
        return this.todoRepository.findAll();
    }
    //    4. 목록 중 특정 아이템 수정
    public TodoModel updateById(Long id, TodoRequest request) {
        TodoModel todoModel = this.searchById(id);
        if (request.getTitle() != null){
            todoModel.setTitle(request.getTitle());
        }
        if(request.getOrder() != null){
            todoModel.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null){
            todoModel.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoModel);
    }
    //    5. 목록 중 특정 아이템 삭제
    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }
    //    6. 전체 목록 삭제
    public void deleteAll(){
        this.todoRepository.deleteAll();
    }

}