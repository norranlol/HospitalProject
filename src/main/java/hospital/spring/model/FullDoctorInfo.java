package hospital.spring.model;

public class FullDoctorInfo {
     private long id;
     private String surname;
     private String name;
     private String patronymic;
     private String schedule;
     private String speciality;
     private String category;

     public FullDoctorInfo(long id, String surname, String name, String patronymic,
             String schedule, String category, String speciality){
         this.id = id;
         this.surname = surname;
         this.name = name;
         this.patronymic = patronymic;
         this.schedule = schedule;
         this.category = category;
         this.speciality = speciality;
     }
     
     public FullDoctorInfo(){}
     
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }   
}
