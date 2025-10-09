package org.mustapha.digitalhospitaljee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is reuqired")
    @Column(length = 30, unique = true, nullable = false)
    private String name;


    @NotBlank(message = "the capacity is required ")
    @Size(min = 1, max = 55) // the must larged hospital in the world
    private int capacity;

    private final boolean isAvailable = false;

    /**
     *  Many to one: many rooms belong to a department, and it can't be null
     */
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public Room(){}

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
