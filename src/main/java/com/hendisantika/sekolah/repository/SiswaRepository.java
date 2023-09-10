package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.dto.SiswaDtoTes;
import com.hendisantika.sekolah.entity.Siswa;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/03/20
 * Time: 18.52
 */
@Repository
public interface SiswaRepository extends JpaRepository<Siswa, UUID> {
    @Query(value = "SELECT tbl_siswa.* FROM tbl_siswa JOIN tbl_kelas ON tbl_siswa.kelas_id = tbl_kelas.id", nativeQuery = true)
    List<SiswaDtoTes> findSiswa();
}
