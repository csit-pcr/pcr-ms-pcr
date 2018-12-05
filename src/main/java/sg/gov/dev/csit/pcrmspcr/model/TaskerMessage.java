package sg.gov.dev.csit.pcrmspcr.model;

import sg.gov.dev.csit.pcrmspcr.model.Message;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="tasker_message")
@EntityListeners(AuditingEntityListener.class)
public class TaskerMessage extends Message implements Serializable{
    private static final long serialVersionUID = 1L;

    @OneToOne
    @JoinColumn(name="FK_requestorID")
    private Requestor requestor_id;

    @OneToOne
    @JoinColumn(name="FK_taskerID")
    private Tasker tasker_id;


}