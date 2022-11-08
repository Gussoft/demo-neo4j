package com.gussoft.demoneo4j.models.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonCreateResponse {

    private Long id;

    private String firstname;

    private String lastname;

    private LocalDate birthday;

    private Integer age;

}
