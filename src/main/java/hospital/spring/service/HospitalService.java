package hospital.spring.service;

import hospital.spring.DAO.HospitalDAO;
import hospital.spring.model.Category;
import hospital.spring.model.Doctor;
import hospital.spring.model.FullDoctorInfo;
import hospital.spring.model.Speciality;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("HospitalService")
@Transactional(readOnly = true)
public class HospitalService {
    
    @Autowired
    HospitalDAO hospitalDAO; 

    public HospitalDAO getHospitalDAO() {
        return hospitalDAO;
    }

    public void setHospitalDAO(HospitalDAO hospitalDAO) {
        this.hospitalDAO = hospitalDAO;
    }
    
    public List<Speciality> getSpecialities(){
        return getHospitalDAO().getSpecialities();
    }
    
    public List<Doctor> getDoctorsBySpeciality(long specId){
        return getHospitalDAO().getDoctorsBySpeciality(specId);
    }
    
    public Category getCategoryById(long id){
        return getHospitalDAO().getCategoryById(id);
    }
    
    public Speciality getSpecialityById(long id){
        return getHospitalDAO().getSpecialityById(id);
    }
    
     public List<FullDoctorInfo> addPartOfRecordsOfDoctors(int begin, int critCount){
         List<Doctor> listOfDoctors = getHospitalDAO().addPartOfRecordsOfDoctors(begin, critCount);
         String category = "", speciality = "";
         List<FullDoctorInfo> listOfFullInfo = new ArrayList<FullDoctorInfo>();
         for (Doctor doctor : listOfDoctors){
             category = getCategoryById(doctor.getCategoryId()).getTitle();
             speciality = getSpecialityById(doctor.getSpecialityId()).getTitle();
             FullDoctorInfo info = new FullDoctorInfo(doctor.getId(),
                     doctor.getSurname(),doctor.getName(),doctor.getPatronymic(),
                     doctor.getSchedule(),category,speciality);
             listOfFullInfo.add(info);
         }
         return listOfFullInfo;
     }
    
    
}
