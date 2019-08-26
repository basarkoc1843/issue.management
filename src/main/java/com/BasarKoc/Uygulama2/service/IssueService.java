package com.BasarKoc.Uygulama2.service;

import com.BasarKoc.Uygulama2.dto.IssueDto;
import com.BasarKoc.Uygulama2.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {
    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    IssueDto delete(IssueDto issueDto);


}
