package sg.gov.dev.csit.pcrmspcr.model;

//Classes that are imported or used
import sg.gov.dev.csit.pcrmspcr.model.EmployeeDetails;

//Spring imports
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name="Approver")
@EntityListeners(AuditingEntityListener.class)
public class Approver extends EmployeeDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private RandomString approver_id = new RandomString(8, ThreadLocalRandom.current());

    private String[] directorate_assigned;

    private String[] section_assigned;

    public RandomString getApproverID() {
        return this.approver_id;
    }

    //Mapping to Change Request <entity> - Child 
    @OneToOne(mappedBy="fk_approver_id", cascade = CascadeType.ALL)
    private Set <ChangeRequest> requests;

    //Start of Getters

    public String[] getDirectorateAssigned() {
        return this.directorate_assigned;
    }

    public String[] getSectionAssigned() {
        return this.section_assigned;
    }

    //Start of Setters 

    public void setApproverID(RandomString approverID) {
        this.approver_id = approverID;
    }

    public void setDirectorateAssigned(String[] directorateAssigned) {
        this.directorate_assigned = directorateAssigned;
    }

    public void setSectionAssigned(String[] sectionAssigned) {
        this.section_assigned = sectionAssigned;
    }


}