package com.BasarKoc.Uygulama2.service.impl;

import com.BasarKoc.Uygulama2.dto.ProjectDto;
import com.BasarKoc.Uygulama2.entity.Project;
import com.BasarKoc.Uygulama2.repository.ProjectRepository;
import com.BasarKoc.Uygulama2.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository,ModelMapper modelMapper) {
        this.projectRepository=projectRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public Project save(Project project) {
        if(project.getProjectCode()==null){
            throw new IllegalArgumentException("Project Code cannot be");
        }
        return this.projectRepository.save(project);
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p=projectRepository.getOne(id);
         return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return this.projectRepository.findAll(pageable);
    }

    @Override
    public boolean delete(Project project) {
        return false;
    }
}
