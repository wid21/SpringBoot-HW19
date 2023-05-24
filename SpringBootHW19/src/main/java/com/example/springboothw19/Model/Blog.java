package com.example.springboothw19.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog {

    @Id  //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title should not be empty")
    @Column(columnDefinition ="varchar (10) not null")
    private String title ;

    @NotEmpty(message = "category should not be empty")
    @Pattern(regexp = "^(health|educationor|programming)$" , message ="category sould be health or educationor or programming " )
    @Column(columnDefinition = "varchar(15)  not null check(category='health' or category= 'educationor' or category= 'programming')")
    private String category;

    @NotEmpty(message = "body should not be empty")
    @Size(max =50,message = "size body max 300 letter")
    private String body;

    @Column(columnDefinition = "boolean default false")
    private boolean isPublished =false;
}

