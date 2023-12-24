package com.example.servingwebcontent.Daniel.Classroom;

import jakarta.persistence.*;
@Entity
@Table(name = "Classroom")
public class Classroom {
    @Id
    @SequenceGenerator(
            name = "classroom_sequence",
            sequenceName = "classroom_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "classroom_sequence"
    )
    @Column(name = "id_classroom")
    private long id_classroom;
    private String name;
    private String description;
    @Lob
    private byte[] image;

    public Classroom() {
    }

    public Classroom(long id_classroom, String name, String description, byte[] image) {
        this.id_classroom = id_classroom;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public long getId_classroom() {
        return id_classroom;
    }

    public void setId_classroom(long id_classroom) {
        this.id_classroom = id_classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
