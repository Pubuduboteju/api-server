package com.ragul.assignment.apiserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateData {
    private Long id;
    private String name;
    private String abbreviation;

}
