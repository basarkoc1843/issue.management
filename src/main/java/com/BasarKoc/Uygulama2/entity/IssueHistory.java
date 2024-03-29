package com.BasarKoc.Uygulama2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue_history")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode

public class IssueHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "issue_status")
    private IssueStatus issueStatus;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "details",length = 400)
    private String details;

    @JoinColumn(name = "issue_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Issue issue;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User assignee;

}
