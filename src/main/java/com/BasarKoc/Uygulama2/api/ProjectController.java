package com.BasarKoc.Uygulama2.api;

import com.BasarKoc.Uygulama2.dto.ProjectDto;
import com.BasarKoc.Uygulama2.service.impl.ProjectServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")

public class ProjectController {

     private final ProjectServiceImpl projectServiceImpl;

     public ProjectController(ProjectServiceImpl projectServiceImpl) {
         this.projectServiceImpl=projectServiceImpl;
     }

     @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id",required = true)  Long id) {
        ProjectDto projectDto=projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);

    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody  ProjectDto projectDto){

         return ResponseEntity.ok(this.projectServiceImpl.save(projectDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value ="id",required = true) Long id,@Valid @RequestBody ProjectDto projectDto) {
         return ResponseEntity.ok(this.projectServiceImpl.update(id,projectDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
     return ResponseEntity.ok(this.projectServiceImpl.delete(id));
    }
}
