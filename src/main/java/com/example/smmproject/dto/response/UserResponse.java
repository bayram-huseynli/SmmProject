package com.example.smmproject.dto.response;

import com.example.smmproject.entity.Manager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String name;

    private String surname;

    private String email;

    List<Manager> managerList=new ArrayList<>();
}
