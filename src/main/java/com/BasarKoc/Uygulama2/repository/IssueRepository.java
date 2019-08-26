package com.BasarKoc.Uygulama2.repository;

import com.BasarKoc.Uygulama2.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {


}
