package com.BasarKoc.Uygulama2.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long id;
    @NotNull
    private String projectName;
    @NotNull
    private String projectCode;


}
