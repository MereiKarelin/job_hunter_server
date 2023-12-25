package com.alibou1.security1.controler;

import com.alibou1.security1.dto.CotegoryDTO;
import com.alibou1.security1.service.CotegoryService;
import com.alibou1.security1.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/main")
public class MainControler {

    @Autowired
    private CotegoryService cotegoryService;


    @GetMapping("/getAll")
    private ResponseEntity<List<Object>> getAll(){
//    private String getAll(Model model){
        List<Object> tasksDTOS = cotegoryService.getAll().stream()
                .map(task -> new CotegoryDTO(task.getId(), task.getName(), task.getSalary(), task.getDescription(), task.getExperience(), task.getType(), task.getTitle(), task.getWanted()) )
                .collect(Collectors.toList());
//        model.addAttribute("allTasks", tasksDTOS);
        return new ResponseEntity<>(tasksDTOS, HttpStatus.OK);
//        return "task/all";
    }
    @GetMapping("/getOne/{taskId}")
    private ResponseEntity<Object> getOne(@PathVariable(name = "cotegoryId")Integer id){
//    private String getOne(@PathVariable(name = "taskId")Integer id, Model model){
        Category category = cotegoryService.getOneById(id);
//        model.addAttribute("task", tasks);
//        return "task/dataTask";
        if (category !=null){
            return new ResponseEntity<>(cotegoryService.getOne(category), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("status: \"NOT_FOUND\"", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/post")
    private ResponseEntity<Object> createTask(@RequestBody CotegoryDTO cotegoryDTO){
        Category category = cotegoryService.getOneById(cotegoryDTO.getId());
        if (category !=null){
            return new ResponseEntity<>(cotegoryService.createCotegory(category),HttpStatus.RESET_CONTENT);
        }else{
            return new ResponseEntity<>(cotegoryService.createNewCotegory(cotegoryDTO),HttpStatus.CREATED);
        }
    }


    @PutMapping("/update/{cotegoryId}")
    private ResponseEntity<Object> updateCotegory(@PathVariable(name = "cotegoryId")Integer id,@RequestBody CotegoryDTO cotegoryDTO) {
//        tasksService.deleteTask(id);
        CotegoryDTO cotegory = cotegoryService.update(id, cotegoryDTO.getSalary());
        return ResponseEntity.ok(cotegory);
//        Cotegory cotegory = tasksService.getOneById(tasksDTO.getId());
//        if (cotegory!=null){
//            return new ResponseEntity<>(tasksService.createTask(cotegory),HttpStatus.RESET_CONTENT);
//        }else{
//            return new ResponseEntity<>(tasksService.createNewTask(tasksDTO),HttpStatus.CREATED);
//        }
    }

    @DeleteMapping("/delete/{cotegoryId}")
    private ResponseEntity<Void> deleteCotegory(@PathVariable(name = "cotegoryId")Integer id){
        cotegoryService.deleteCotegory(id);
        return ResponseEntity.noContent().build();
    }



}
