package sg.gov.dev.csit.pcrmspcr.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;

@Entity
@Table(name="files")
@EntityListeners(AuditingEntityListener.class)
public class Files implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long file_id;

    @NotBlank
    private byte[] file;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "request_no")
    private String cr_id;

    //Start of Getters

    public Long getFilesID() {
        return this.file_id;
    }

    public byte[] getFiles() {
        return this.file;
    }

    // public String getCRID() {
    //     return this.cr_id;
    // }

    //Start of Setters

    public void setFileID(Long fileID) {
        this.file_id = fileID;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
    
}
