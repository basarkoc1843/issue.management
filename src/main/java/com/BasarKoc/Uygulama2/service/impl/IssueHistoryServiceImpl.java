package com.BasarKoc.Uygulama2.service.impl;

import com.BasarKoc.Uygulama2.entity.IssueHistory;
import com.BasarKoc.Uygulama2.repository.IssueHistoryRepository;
import com.BasarKoc.Uygulama2.service.IssueHistoryService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {
    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository=issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if(issueHistory.getDate()==null) {
            throw  new IllegalArgumentException("issue cannot be null");
        }
        return this.issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return this.issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return this.issueHistoryRepository.findAll(pageable);
    }

    @Override
    public boolean delete(IssueHistory issueHistory) {
        this.issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
