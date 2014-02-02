package hospital.managedController;

import hospital.spring.model.Category;
import hospital.spring.model.Doctor;
import hospital.spring.model.Speciality;
import hospital.spring.service.HospitalService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="doctorMB")
@SessionScoped
public class DoctorManagedBean implements Serializable{
    
    @ManagedProperty(value="#{HospitalService}")
    HospitalService hospitalService;
    
    Speciality selectedSpeciality;
    
    Doctor selectedDoctor;
    
    List<Doctor> listOfDoctors = new ArrayList<Doctor>();
    
    Category category;
    
    public String findDoctorsBySpeciality(){
        return "findDoctors";
    }
    
    public String showInfoAboutDoctor(){
        setCategory(getHospitalService().getCategoryById(selectedDoctor.getCategoryId()));
        return "infoAboutDoctor";
    }
    
    public Speciality getSelectedSpeciality() {
        return selectedSpeciality;
    }

    public void setSelectedSpeciality(Speciality selectedSpeciality) {
        this.selectedSpeciality = selectedSpeciality;
    }

    public HospitalService getHospitalService() {
        return hospitalService;
    }

    public void setHospitalService(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }
    
    public List<Doctor> getListOfDoctors() {
        listOfDoctors = getHospitalService().getDoctorsBySpeciality(selectedSpeciality.getId());
        return listOfDoctors;
    }

    public void setListOfDoctors(List<Doctor> listOfDoctors) {
        this.listOfDoctors = listOfDoctors;
    }  

    public Doctor getSelectedDoctor() {
        return selectedDoctor;
    }

    public void setSelectedDoctor(Doctor selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
