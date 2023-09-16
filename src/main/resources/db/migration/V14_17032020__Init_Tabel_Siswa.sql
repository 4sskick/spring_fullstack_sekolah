CREATE TABLE IF NOT EXISTS tbl_siswa
(
    id           UUID           DEFAULT uuid_generate_v4() NOT NULL,
    kelas_id     UUID           DEFAULT uuid_generate_v4() NOT NULL,
    nama         varchar(75),
    jenkel       varchar(2),
    nis          varchar(20),
    photo        varchar(40),
    photo_base64 text,
    filename     varchar(50)    DEFAULT NULL,
    file_content bytea          DEFAULT NULL,
    created_by   varchar(50),
    created_on   timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by  varchar(50),
    modified_on  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE (nis)
);

ALTER TABLE IF EXISTS tbl_siswa
    ADD CONSTRAINT FK7j7xvs7goinl9nq2n004ent0c
        FOREIGN KEY (kelas_id)
            REFERENCES tbl_kelas;

--
-- Dumping data untuk tabel tbl_siswa
--
