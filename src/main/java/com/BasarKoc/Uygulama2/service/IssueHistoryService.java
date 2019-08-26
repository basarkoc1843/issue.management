package com.BasarKoc.Uygulama2.service;

import com.BasarKoc.Uygulama2.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {
    IssueHistory save(IssueHistory issueHistory);

    IssueHistory getById(Long id);

    Page<IssueHistory> getAllPageable(Pageable pageable);

    boolean delete(IssueHistory issueHistory);

}
