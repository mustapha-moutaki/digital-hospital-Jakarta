package org.mustapha.digitalhospitaljee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private int age;
        private String name;
        public Doctor(){}
        public Doctor(int age, String name){
        }



    public Long getId() {
                return id;
            }


            public int getAge() {
                return age;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }
