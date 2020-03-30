package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.dto.PenggunaDto;
import com.hendisantika.sekolah.entity.Pengguna;
import com.hendisantika.sekolah.repository.PenggunaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/03/20
 * Time: 13.13
 */
@Slf4j
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("admin/pengguna")
public class PenggunaController {

    @Autowired
    private PenggunaRepository penggunaRepository;

    @GetMapping
    public String pengguna(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Pengguna.");
        model.addAttribute("penggunaList", penggunaRepository.findAll(pageable));
        return "admin/pengguna/pengguna-list";
    }

    @GetMapping("add")
    public String showFormPengguna(Model model) {
        log.info("Menampilkan Form Tambah Pengguna.");
        model.addAttribute("pengguna", new PenggunaDto());
        return "admin/pengguna/pengguna-form";
    }

    @PostMapping
    public String addPengguna(Model model, @Valid PenggunaDto penggunaDto, @RequestParam("file") MultipartFile file,
                              Principal principal, Pageable pageable, SessionStatus status) {
        log.info("Menyiapkan Data Tambah Pengguna.");
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            Pengguna pengguna = new Pengguna();
            BeanUtils.copyProperties(penggunaDto, pengguna);
            pengguna.setPhoto(file.getOriginalFilename());
            pengguna.setFileContent(bytes);
            pengguna.setFilename(file.getOriginalFilename());
            penggunaRepository.save(pengguna);
            status.setComplete();
            log.info("Tambah Pengguna yang baru sukses.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("penggunaList", penggunaRepository.findAll(pageable));
        return "redirect:/admin/pengguna";
    }

}
