package models;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UserSimple {
     String firstName;
     String surName;
     String email;
     boolean  isActive;
     int age;
     int id;
     String userName;
     String password;

}
