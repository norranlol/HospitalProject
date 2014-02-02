package hospital.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Doctor")
public class Doctor  implements java.io.Serializable {

     private long id;
     private long categoryId;
     private String name;
     private String patronymic;
     private String schedule;
     private long specialityId;
     private String surname;

    public Doctor() {
    }

    public Doctor(long categoryId, String name, String patronymic, String schedule, long specialityId, String surname) {
       this.categoryId = categoryId;
       this.name = name;
       this.patronymic = patronymic;
       this.schedule = schedule;
       this.specialityId = specialityId;
       this.surname = surname;
    }
   
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name="categoryId")
    public long getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
    
    @Column(name="name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="patronymic")
    public String getPatronymic() {
        return this.patronymic;
    }
    
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    
    @Column(name="schedule")
    public String getSchedule() {
        return this.schedule;
    }
    
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    
    @Column(name="specialityId")
    public long getSpecialityId() {
        return this.specialityId;
    }
    
    public void setSpecialityId(long specialityId) {
        this.specialityId = specialityId;
    }
    
    @Column(name="surname")
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    private Category category;
    
    @ManyToOne
    @JoinTable(name = "id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    private Speciality speciality;

    @ManyToOne
    @JoinTable(name = "id")
    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
    
    
}


