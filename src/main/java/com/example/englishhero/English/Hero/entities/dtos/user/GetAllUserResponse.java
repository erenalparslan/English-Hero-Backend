package com.example.englishhero.English.Hero.entities.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllUserResponse {
    private int id;
    private String email;
    private String name;
    private List<SimpleGrantedAuthority> roles;
}
