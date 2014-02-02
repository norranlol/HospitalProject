package hospital.managedController;

import hospital.spring.model.FullDoctorInfo;
import hospital.spring.service.HospitalService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AllDoctorsPageBean implements Serializable{
    
    @ManagedProperty(value="#{HospitalService}")
    HospitalService hospitalService;
    
    private List<FullDoctorInfo> listOfDoctors;
    
    private int strListMax;
    
    private boolean flagOfInitialize = false;

    public HospitalService getHospitalService() {
        return hospitalService;
    }
    
    public void setHospitalService(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    public List<FullDoctorInfo> getListOfDoctors() {
        if (!flagOfInitialize){
        listOfDoctors = getHospitalService().addPartOfRecordsOfDoctors(0,50);
        flagOfInitialize = true;
        }
        return listOfDoctors;
    }

    public void setListOfDoctors(List<FullDoctorInfo> listOfDoctors) {
        this.listOfDoctors = listOfDoctors;
    } 
    
    public void loadMoreData(){
        strListMax = listOfDoctors.size();
        int addCount = 30;
        List<FullDoctorInfo> listOfNewDoctors = getHospitalService().addPartOfRecordsOfDoctors(strListMax, addCount);
        listOfDoctors.addAll(listOfNewDoctors);
        strListMax += addCount;
    }
}
