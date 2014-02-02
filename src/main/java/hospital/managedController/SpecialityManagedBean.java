package hospital.managedController;

import hospital.spring.model.Speciality;
import hospital.spring.service.HospitalService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="specialityMB")
@RequestScoped
public class SpecialityManagedBean implements Serializable{
    
    @ManagedProperty(value="#{HospitalService}")
    HospitalService hospitalService;

    public HospitalService getHospitalService() {
        return hospitalService;
    }

    public void setHospitalService(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }
    
    List<Speciality> listOfSpeciality;

    public List<Speciality> getListOfSpeciality() {
        listOfSpeciality = new ArrayList<Speciality>();
        listOfSpeciality.addAll(getHospitalService().getSpecialities());
        return listOfSpeciality;
    }
}
