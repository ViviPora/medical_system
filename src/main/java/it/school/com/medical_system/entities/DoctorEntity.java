package it.school.com.medical_system.entities;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor")
@PrimaryKeyJoinColumn(name = "id")
public class DoctorEntity extends PersonEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    private String degreeNumber;

    private int experience;
    private String specialization;
//    @ToString.Exclude
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_person", referencedColumnName = "id")
//    private PersonEntity personEntity;

}
