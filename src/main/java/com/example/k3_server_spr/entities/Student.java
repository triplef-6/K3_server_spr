package com.example.k3_server_spr.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.*;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.Size;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Student {
//    @Min(1)
    private long id;

//    @Size(min = 3, max = 32)
    private String surname;

//    @Size(min = 3, max = 32)
    private String name;

//    @Size(min = 3, max = 32)
    private String patronymic;

//    @Size(min = 3, max = 32)
    private String status;

//    @Min(1)
    private long groupId;

}
