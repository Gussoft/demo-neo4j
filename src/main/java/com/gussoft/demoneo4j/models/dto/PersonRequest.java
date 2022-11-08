package com.gussoft.demoneo4j.models.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PersonRequest {

    private String firstname;

    private String lastname;

    private LocalDate birthday;

}
