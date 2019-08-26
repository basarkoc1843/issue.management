package com.BasarKoc.Uygulama2.service.impl;

import com.BasarKoc.Uygulama2.dto.IssueDto;
import com.BasarKoc.Uygulama2.entity.Issue;
import com.BasarKoc.Uygulama2.repository.IssueRepository;
import com.BasarKoc.Uygulama2.service.IssueService;
import com.BasarKoc.Uygulama2.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository,ModelMapper modelMapper) {
        this.issueRepository=issueRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate()==null) {
            throw new IllegalArgumentException("issue Date cannet be null");
        }
        Issue issueDb=modelMapper.map(issue, Issue.class);
        issueDb=this.issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);

    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data=this.issueRepository.findAll(pageable);
        TPage page=new TPage<IssueDto>();
        IssueDto[] dtos =modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data,Arrays.asList(dtos));

        return page;
    }

    @Override
    public IssueDto delete(IssueDto issueDto) {
        return null;
    }
}
