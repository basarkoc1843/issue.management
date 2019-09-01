package com.BasarKoc.Uygulama2.repository;

import com.BasarKoc.Uygulama2.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> findAll(Pageable pageble);

    List<Project> findAll(Sort sort);
}
