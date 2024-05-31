package com.example.k3_server_spr.utils;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateStudentPojo {
    private String name;
    private String surname;
    private String status;
    private long groupId;
    private String patronymic;
}
