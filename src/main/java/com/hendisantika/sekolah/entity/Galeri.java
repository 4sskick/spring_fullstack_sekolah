package com.hendisantika.sekolah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_galeri")
@EntityListeners(AuditingEntityListener.class)
public class Galeri {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "galeri_judul")
    private String judul;

    @Column(name = "galeri_tanggal")
    private LocalDateTime tanggal;

    @Column(name = "galeri_gambar")
    private String gambar;

    @Column(name = "galeri_album_id")
    private int albumId;

    @Column(name = "galeri_pengguna_id")
    private int penggunaId;

    @Column(name = "galeri_author")
    private String author;

}
