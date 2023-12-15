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
    @Column(name = "idClassroom")
    private long idClassroom;
    private String name;
    private String description;
    @Lob
    private byte[] image;

    public Classroom() {
    }

    public Classroom(long idClassroom, String name, String description, byte[] image) {
        this.idClassroom = idClassroom;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public long getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(long idClassroom) {
        this.idClassroom = idClassroom;
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
