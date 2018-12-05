package sg.gov.dev.csit.pcrmspcr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Spring imports
// import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//Java Imports
import java.io.Serializable;

@Entity
@Table(name="message")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createdAt", "updatedAt"},
            allowGetters=true)
//Prevent specified files from being serializable or deserialized

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long message_id;

    @NotBlank
    private String message;

    @NotBlank
    private String remarks;

    @OneToOne
    @JoinColumn(name = "FK_request_no")
    private ChangeRequest cr_id;

    //Start of Getters

    public Long getMessageID() {
        return this.message_id;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public ChangeRequest getCRID() {
        return this.cr_id;
    }

    //Start of Setters

    public void setMessageID(Long messageID) {
        this.message_id = messageID;
    }

    public void setName(String message) {
        this.message = message;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    //Not sure if need to set a foreign key 
}