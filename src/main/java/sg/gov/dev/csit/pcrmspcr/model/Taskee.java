package sg.gov.dev.csit.pcrmspcr.model;

import sg.gov.dev.csit.pcrmspcr.model.EmployeeDetails;

//Spring imported
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imported
import javax.persistence.*;

//Java imported
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="Taskee")
@EntityListeners(AuditingEntityListener.class)
public class Taskee extends EmployeeDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String taskee_id;

    //Mapping to Change Request <entity> - Child 
    @OneToOne(mappedBy="fk_taskee_id", cascade = CascadeType.ALL)
    private Set <ChangeRequest> requests;

    public String getTaskerID() {
        return this.taskee_id;
    }

    public void setTaskerID(String taskerID) {
        this.taskee_id = taskerID;
    }


}