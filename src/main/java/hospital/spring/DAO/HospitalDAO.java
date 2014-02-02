package hospital.spring.DAO;

import hospital.spring.model.Category;
import hospital.spring.model.Doctor;
import hospital.spring.model.Speciality;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
   
    public List<Speciality> getSpecialities(){
        List specialities = getSessionFactory().getCurrentSession().
                createCriteria(Speciality.class).list();
        return specialities;
    }   
    
    public List<Doctor> getDoctorsBySpeciality(long specId){
        List doctors = getSessionFactory().getCurrentSession().
        createCriteria(Doctor.class).add(Restrictions.eq("specialityId", specId))
        .list();
        return doctors;
    }
    
    public Category getCategoryById(long id){
        Category category = (Category) getSessionFactory().getCurrentSession()
                .get(Category.class, id);
        return category;
    }
    
    public Speciality getSpecialityById(long id){
        Speciality speciality = (Speciality) getSessionFactory().getCurrentSession()
                .get(Speciality.class, id);
        return speciality;
    }
    
    public List<Doctor> addPartOfRecordsOfDoctors(int begin, int critCount){
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Doctor.class);
        criteria.setFirstResult(begin);
        criteria.setMaxResults(critCount);
        List doctors = criteria.list();
        return doctors;
    }
    
}
