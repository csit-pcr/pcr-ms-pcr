package sg.gov.dev.csit.pcrmspcr.model;

//Classes imports
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
@Table(name="Taskee")
@EntityListeners(AuditingEntityListener.class)
public class Taskee extends EmployeeDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private RandomString taskee_id = new RandomString(8, ThreadLocalRandom.current());

    //Mapping to Change Request <entity> - Child 
    @OneToOne(mappedBy="fk_taskee_id", cascade = CascadeType.ALL)
    private Set <ChangeRequest> requests;

    public RandomString getTaskerID() {
        return this.taskee_id;
    }

    public void setTaskerID(RandomString taskerID) {
        this.taskee_id = taskerID;
    }


}