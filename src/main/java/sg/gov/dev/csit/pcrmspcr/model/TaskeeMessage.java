package sg.gov.dev.csit.pcrmspcr.model;

//Classes that are imported or used
import sg.gov.dev.csit.pcrmspcr.model.Message;

//Apring imports
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;

@Entity
@Table(name="tasker_message")
@EntityListeners(AuditingEntityListener.class)
public class TaskeeMessage extends Message implements Serializable{
    private static final long serialVersionUID = 1L;

    @OneToOne
    @JoinColumn(name="FK_requestorID")
    private Requestor requestor_id;

    @OneToOne
    @JoinColumn(name="FK_taskerID")
    private Tasker tasker_id;


}