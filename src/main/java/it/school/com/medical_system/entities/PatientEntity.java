package it.school.com.medical_system.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "petient")
@PrimaryKeyJoinColumn(name = "id")
public class PatientEntity extends PersonEntity{
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    private int id;
    @Column(name = "insurance_no")
    private String insuranceNumber;
    @Column(name = "insurance_company")
    private String insuranceCompany;
    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "person_id", referencedColumnName = "id")
//    PersonEntity personEntity;
}
