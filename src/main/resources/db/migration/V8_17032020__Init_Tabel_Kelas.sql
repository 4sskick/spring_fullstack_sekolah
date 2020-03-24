CREATE TABLE IF NOT EXISTS tbl_kelas
(
    kelas_id   int4 GENERATED BY DEFAULT AS IDENTITY,
    kelas_nama varchar(25),
    PRIMARY KEY (kelas_id)
);
--
-- Dumping data untuk tabel tbl_kelas
--

INSERT INTO tbl_kelas (kelas_id, kelas_nama)
VALUES (1, 'Kelas X.1'),
       (2, 'Kelas X.2'),
       (3, 'Kelas X.3'),
       (4, 'Kelas X.4'),
       (5, 'Kelas X.5'),
       (6, 'Kelas X.6'),
       (7, 'Kelas X.7'),
       (8, 'Kelas XI IPA.1'),
       (9, 'Kelas XI IPA.2'),
       (10, 'Kelas XI IPA.3'),
       (11, 'Kelas XI IPA.4'),
       (12, 'Kelas XI IPA.5'),
       (13, 'Kelas XI IPA.6'),
       (14, 'Kelas XI IPA.7'),
       (15, 'Kelas XI IPS.1'),
       (16, 'Kelas XI IPS.2'),
       (17, 'Kelas XI IPS.3'),
       (18, 'Kelas XI IPS.4'),
       (19, 'Kelas XI IPS.5'),
       (20, 'Kelas XI IPS.6'),
       (21, 'Kelas XI IPS.7');
