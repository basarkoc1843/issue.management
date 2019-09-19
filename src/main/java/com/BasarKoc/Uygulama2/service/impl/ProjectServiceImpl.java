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
    public ProjectDto save(ProjectDto project) {
        Project projectCheck=this.projectRepository.getByProjectCode(project.getProjectCode());
        if(projectCheck!=null)
            throw new IllegalArgumentException("ProjectCode Already Exist");

           Project p=modelMapper.map(project,Project.class);
           p=this.projectRepository.save(p);
           project.setId(p.getId());
           return project;



    }

    @Override
    public ProjectDto getById(Long id) {
        if(id==null) {
            throw new IllegalArgumentException("id NULL");
        }
        Project p=projectRepository.getOne(id);
        if(p==null) {
            throw new IllegalArgumentException("Boyle Bir Proje Yok");
        }
         return modelMapper.map(p,ProjectDto.class);

    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
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
    public ProjectDto update(Long id,ProjectDto projectDto) {
        Project project=this.projectRepository.getOne(id);

        if(project==null)
            throw new IllegalArgumentException("Project Does Not Exist ID:"+id);

       Project projectCheck=this.projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(),id);
       if(projectCheck!=null)
           throw new IllegalArgumentException("Project Code Already Exist");

       project.setProjectCode(projectDto.getProjectCode());
       project.setProjectName(projectDto.getProjectName());

       this.projectRepository.save(project);
       return this.modelMapper.map(project,ProjectDto.class);


    }

    @Override
    public Boolean delete(Project project) {
        return false;
    }

    public Boolean delete(Long id) {
        this.projectRepository.deleteById(id);
        return true;
    }
}
