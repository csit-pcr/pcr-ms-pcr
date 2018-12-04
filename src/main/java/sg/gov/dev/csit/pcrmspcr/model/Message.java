package sg.gov.dev.csit.pcrmspcr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

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

    @NotBlank
    @OneToOne
    @JoinColumn(name = "request_no")
    private String cr_id;

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

    public String getCRID() {
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
    
}