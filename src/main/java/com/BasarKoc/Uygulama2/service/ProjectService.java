package com.BasarKoc.Uygulama2.service;

import com.BasarKoc.Uygulama2.dto.ProjectDto;
import com.BasarKoc.Uygulama2.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    ProjectDto update(Long id,ProjectDto projectDto);

    Boolean delete(Project project);

}
