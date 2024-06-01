package com.makhdoom.Splitwise.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "user_groups")
public class Group extends BaseModel {

    private String name;

    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> members = new ArrayList<>();

    @ManyToMany
    private List<User> admins = new ArrayList<>();
}
