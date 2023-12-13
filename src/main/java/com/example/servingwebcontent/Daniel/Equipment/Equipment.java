package com.example.servingwebcontent.Daniel.Equipment;

import jakarta.persistence.*;

@Entity
@Table(name = "Equipment")
public class Equipment {
    @Id
    @SequenceGenerator(
            name = "equipment_sequence",
            sequenceName = "equipment_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "equipment_sequence"
    )
    @Column(name = "id_equipment")
    private long id_equipment;
    private String category;
    private String description;
    private String label;

    public Equipment(long id_equipment, String category, String description, String label) {
        this.id_equipment = id_equipment;
        this.category = category;
        this.description = description;
        this.label = label;
    }

    public Equipment(){

    }

    public long getId_equipment() {
        return id_equipment;
    }

    public void setId_equipment(long id_equipment) {
        this.id_equipment = id_equipment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id_equipment +
                ", category='" + category + '\'' +
                ", name='" + description + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
