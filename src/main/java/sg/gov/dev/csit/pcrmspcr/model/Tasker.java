package sg.gov.dev.csit.pcrmspcr.model;

//Classes imported or used
import sg.gov.dev.csit.pcrmspcr.model.EmployeeDetails;

//Spring imported
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imported
import javax.persistence.*;

//Java imported
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Tasker")
@EntityListeners(AuditingEntityListener.class)
public class Tasker extends EmployeeDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tasker_id;

    private String[] directorate_assigned;

    private String[] section_assigned;

    //Mapping to Change Request <entity> - Child 
    @OneToOne(mappedBy="fk_tasker_id", cascade = CascadeType.ALL)
    private Set <ChangeRequest> requests;

    //Start of Getters

    public String getTaskerID() {
        return this.tasker_id;
    }    

    public String[] getDirectorateAssigned() {
        return this.directorate_assigned;
    }

    public String[] getSectionAssigned() {
        return this.section_assigned;
    }

    //Start of Setters

    public void setTaskerID(String taskerID) {
        this.tasker_id = taskerID;
    }

    public void setDirectorateAssigned(String[] directorateAssigned) {
        this.directorate_assigned = directorateAssigned;
    }

    public void setSectionAssigned(String[] sectionAssigned) {
        this.section_assigned = sectionAssigned;
    }


}