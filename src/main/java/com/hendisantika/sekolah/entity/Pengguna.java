package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_pengguna")
@EntityListeners(AuditingEntityListener.class)
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fullname")
    @Size(max = 50)
    private String fullname;

    @Column(name = "moto")
    @Size(max = 120)
    private String moto;

    @Column(name = "jenkel")
    @Size(max = 2)
    private String jenkel;

    @Column(name = "username", unique = true)
    @Size(max = 30)
    private String username;

    @Column(name = "password")
    @Size(max = 75)
    private String password;

    @Column(name = "tentang")
    private String tentang;

    @Column(name = "email", unique = true)
    @Email
    @Size(max = 50)
    private String email;

    @Column(name = "nohp")
    @Size(max = 20)
    private String nohp;

    @Column(name = "facebook")
    @Size(max = 50)
    private String facebook;

    @Column(name = "twitter")
    @Size(max = 50)
    private String witter;

    @Column(name = "linkedin")
    @Size(max = 50)
    private String linkedin;

    @Column(name = "status")
    @PositiveOrZero
    private int status;

    @Column(name = "level")
    @Size(max = 3)
    private String level;

    @Column(name = "photo")
    @Size(max = 40)
    private String photo;

    @Column(name = "photo_base64")
    private String photoBase64;

    @Column(name = "filename")
    @Size(max = 40)
    private String filename;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "active")
    private boolean active;

    @CreatedDate
    @Column(name = "register")
    private LocalDateTime register;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Column(name = "created_by")
    @CreatedBy
    @Size(max = 50)
    private String createdBy;

    @Column(name = "created_on")
    @CreatedDate
    private LocalDateTime createdOn;

    @Column(name = "modified_by")
    @LastModifiedBy
    @Size(max = 50)
    private String modifiedBy;

    @Column(name = "modified_on")
    @LastModifiedDate
    private LocalDateTime modifiedOn;
}
