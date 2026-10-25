# Smart Public Facility App — Design System & UI Specification

> **Dokumentasi Desain & Style Guide Resmi (Civic Horizon v2.4.0)**  
> Dibuat untuk memastikan konsistensi visual, tata letak, dan implementasi komponen antarmuka aplikasi Android *Smart Public Facility*.

---

## 1. Ringkasan Proyek

| Atribut | Nilai |
| :--- | :--- |
| **Nama Proyek** | **Smart Public Facility App** |
| **Stitch Project ID** | `14976926923939457974` |
| **Sistem Desain** | **Civic Horizon (Material Design 3)** |
| **Platform Target** | Android (Kotlin / Jetpack Compose atau Android View XML) |
| **Kategori & Tema** | Portal Kota Cerdas (*Smart City* / DISKOMINFO & Layanan Publik) |
| **Gaya Visual** | Otoritatif, Bersih, Ergonomis, Modern Glassmorphism & Card-based |

---

## 2. Palet Warna (Color Tokens)

Desain menggunakan turunan skema Material 3 bertema **Civic Blue & Cyan Accent**, mencerminkan integritas institusi pemerintahan dengan aksen teknologi cerdas.

### 2.1 Warna Utama (Core Brand Colors)

| Token Desain | Kode HEX | Peran & Penggunaan UI |
| :--- | :--- | :--- |
| **`primary`** | `#004D99` | Warna primer identitas aplikasi, status aktif penting |
| **`primary-container`** | `#1565C0` | Tombol CTA utama (*Primary Button*), header kartu, aksen fokus |
| **`on-primary`** | `#FFFFFF` | Teks/ikon di atas latar `primary` atau `primary-container` |
| **`primary-fixed`** | `#D6E3FF` | Background badge / kontainer ringan untuk kategori utama |
| **`primary-fixed-dim`** | `#A9C7FF` | Aksen sekunder varian biru muda |
| **`secondary`** | `#006876` | Elemen penegas, jarak (*distance indicator*), ikon navigasi |
| **`secondary-container`** | `#58E6FF` | Highlight aktif, latar chip status terkini |
| **`accent-cyan`** | `#00BCD4` | Indikator *Live IoT*, aksen glowing splash, tombol aksi FAB |
| **`on-secondary`** | `#FFFFFF` | Teks/ikon di atas warna sekunder |

### 2.2 Warna Permukaan & Latar (Surfaces & Backgrounds)

| Token Desain | Kode HEX | Peran & Penggunaan UI |
| :--- | :--- | :--- |
| **`background`** | `#F9F9FF` | Latar belakang dasar layar (atau `#F5F7FA`) |
| **`surface`** | `#F9F9FF` | Permukaan dasar kanvas aplikasi |
| **`surface-container-lowest`**| `#FFFFFF` | Permukaan kartu utama (*CardView*), modal bottom sheet |
| **`surface-container-low`** | `#F0F3FF` | Latar item informasi dalam kartu, sub-section |
| **`surface-container`** | `#E7EEFF` | Latar chip fasilitas, tombol sekunder |
| **`surface-container-high`**| `#DEE8FF` | Latar filter chip tidak aktif, pemisah baris |
| **`surface-container-highest`**| `#D8E3FB` | Border tipis kontainer dan status netral |
| **`surface-dim`** | `#CFDAF2` | Efek bayangan / overlay lembut |
| **`surface-tint`** | `#005DB7` | Efek tint pada elevasi kartu Material 3 |
| **`inverse-surface`** | `#263143` | Background snackbar / toast notifikasi |
| **`inverse-on-surface`** | `#ECF1FF` | Teks di atas toast / snackbar gelap |

### 2.3 Tipografi & Teks (Content & Text Colors)

| Token Desain | Kode HEX | Peran & Penggunaan UI |
| :--- | :--- | :--- |
| **`on-surface`** | `#111C2D` | Teks judul utama (*Headings*), teks kontras tinggi |
| **`on-surface-variant`**| `#424752` | Teks isi deskripsi (*Body text*), subtitle, keterangan sekunder |
| **`outline`** | `#727783` | Border input form tidak aktif, ikon placeholder |
| **`outline-variant`** | `#C2C6D4` | Garis pembatas (*Divider*), hairline border kartu |

### 2.4 Status & Feedback Colors

| Token Desain | Kode HEX | Peran & Penggunaan UI |
| :--- | :--- | :--- |
| **`status-success`** | `#2E7D32` | Fasilitas Buka / Aktif, Indikator AQI Baik |
| **`status-warning`** | `#F57C00` | Peringatan kapasitas penuh, jam mendekati tutup |
| **`error` / `tertiary`**| `#BA1A1A` / `#A10016` | Pesan error validasi NIK/Password, status tutup darurat |
| **`tertiary-container`**| `#C5242B` / `#EF4444` | Tombol destruktif (*Logout*), badge IGD Rumah Sakit |
| **`on-tertiary-container`**| `#FFDDDA` | Teks peringatan error kontainer |

---

## 3. Tipografi (Typography Scale)

Aplikasi memadukan font serif berbobot otoritatif untuk identitas (*Domine*) dengan font sans-serif ergonomis dengan legibilitas tinggi (*Roboto Flex* / *Plus Jakarta Sans*).

### 3.1 Hierarki Teks

| Skala (Role) | Font Family | Size | Line Height | Weight | Tracking | Penggunaan |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Display Lg** | `Domine` | 36px (36sp) | 44px | 700 (Bold) | -0.02em | Judul besar poster & splash screen |
| **Headline Lg** | `Domine` | 30px (30sp) | 38px | 600 (Semibold)| -0.01em | Judul halaman utama |
| **Headline Lg Mobile**| `Domine` | 26px (26sp) | 34px | 600 (Semibold)| -0.01em | Judul fasilitas pada Detail Screen |
| **Headline Md** | `Domine` | 22px (22sp) | 28px | 600 (Semibold)| Normal | Judul card utama / Section modal |
| **Headline Sm** | `Domine` | 18px (18sp) | 24px | 500 (Medium)  | Normal | Judul kartu fasilitas di daftar |
| **Title Lg** | `Roboto Flex` | 16px (16sp) | 24px | 600 (Semibold)| Normal | Sub-heading section, judul list item |
| **Body Lg** | `Roboto Flex` | 16px (16sp) | 24px | 400 (Regular) | Normal | Paragraf penjelas panjang |
| **Body Md** | `Roboto Flex` | 14px (14sp) | 20px | 400 (Regular) | Normal | Deskripsi fasilitas, input teks form |
| **Body Sm** | `Roboto Flex` | 12px (12sp) | 16px | 400 (Regular) | Normal | Metadata sekunder, preview alamat |
| **Label Lg** | `Roboto Flex` | 14px (14sp) | 20px | 600 (Semibold)| 0.01em | Teks tombol aksi utama (*Button CTA*) |
| **Label Md** | `Roboto Flex` | 12px (12sp) | 16px | 500 (Medium)  | 0.02em | Filter chips, tombol kecil, tab label |
| **Label Sm** | `Roboto Flex` | 11px (11sp) | 14px | 500 (Medium)  | 0.03em | Badge status ("Live", "Buka", "0.8 km") |

---

## 4. Bentuk, Jarak, & Elevasi (Shapes, Spacing & Elevation)

### 4.1 Corner Radius (Bentuk Lengkungan)
- **`rounded-sm` (4dp / 0.25rem)**: Badge mikro, indikator kecil.
- **`rounded-md` (8dp / 0.5rem)**: Image thumbnail kecil, tag fasilitas.
- **`rounded-xl` (12dp / 0.75rem)**: Tombol standar, kolom textfield input.
- **`rounded-2xl` (16dp / 1.0rem)**: Kartu fasilitas (*Facility Card*), container profil.
- **`rounded-3xl` (24dp / 1.5rem)**: Bottom sheet modal, hero banner, form container.
- **`rounded-full` (9999px)**: Filter chips, badge pill status, tombol bulat FAB.

### 4.2 Skala Spasi (Grid & Spacing Scale)
- **Grid Basis**: 8dp (kelipatan 4dp / 8dp).
- **Margin Layar Mobile**: 16dp (`margin-mobile`).
- **Gutter Antar Kolom**: 12dp (`gutter-mobile`).
- **Jarak Elemen Berdekatan**: 4dp (`space-xs`) / 8dp (`space-sm`).
- **Jarak Antar Komponen**: 16dp (`space-md`) / 24dp (`space-lg`).
- **Jarak Antar Section**: 32dp (`space-xl`).

### 4.3 Elevasi & Efek Visual
- **Card Flat / Minimal**: Border `1px solid #E2E8F0` dengan shadow `0 2px 8px -2px rgba(30, 41, 59, 0.06)`.
- **Floating Action / Sticky App Bar**: Background translusen dengan `backdrop-filter: blur(12px)`.
- **Elevated Button / Modal**: Shadow `0 8px 24px -4px rgba(21, 101, 192, 0.20)`.

---

## 5. Inventaris Aset & Ikonografi

### 5.1 Logo Resmi
- **URL Asset Logo**:  
  `https://lh3.googleusercontent.com/aida/AEtjO1Xx_bbEaJfBlPguikP00TfTh3HQPv_j-HbxxYz1Z3tPoz2DMrNGpIv6Ha87_l_e2ww6SraZuL1EjN9P-B7NUhS80S2eU3860qfdNdUy1BMTbsaQC1aIRNX3G1QMm9c0tSJcGmzElQR3lg2_r9E1xJD6-_kcR67WaLpnJLcMd4FYnkIio5nPp0Ojo9Sl5rRF7HfJruIp-fc5u2zBNVvNQI82uBeK313oP8NwH3CvFQGDqdex6i2M2nbJZrDF`
- **Tampilan**: Logo persegi dengan lengkungan `rounded-xl`, berlatar putih bersih dengan aksen gradasi biru ke toska.

### 5.2 Standar Ikon (Material Symbols Outlined / Vector 24x24dp)
- `verified` — Lencana akun terverifikasi & dinas pengelola.
- `search` / `tune` — Kolom pencarian dan filter opsi.
- `park` / `tree` — Kategori Taman & Rekreasi Kota.
- `local_hospital` / `emergency` — Kategori Fasilitas Medis & IGD.
- `accessible` — Akses ramah disabilitas / kursi roda.
- `directions_bus` — Transportasi umum & halte.
- `menu_book` — Perpustakaan daerah / literasi publik.
- `account_balance` — Kantor layanan sipil / pemerintahan.
- `wifi` — Ketersediaan Wi-Fi publik gratis.
- `schedule` / `clock` — Informasi jam operasional.
- `near_me` / `location_on` — Penunjuk arah & jarak radius.
- `notifications_active` — Pengaturan notifikasi.
- `logout` — Tombol keluar akun.

---

## 6. Spesifikasi Layar (Screen Specifications)

Aplikasi terdiri dari **5 Alur Layar Utama**:

```
[1. Splash Screen] ──> [2. Login Screen] ──> [3. Main Dashboard] ──> [4. Detail Screen]
                                                    │
                                                    └──> [5. Profile & Settings]
```

---

### 6.1 Layar 1: Splash Screen
* **Tujuan**: Inisialisasi aplikasi, pemeriksaan konektivitas data kota, dan pengenalan identitas kota cerdas.
* **Latar Belakang**: Gradasi vertikal dari `#0D47A1` (biru tua) ke `#1565C0` dengan lingkaran luminous cyan blur.
* **Komponen & Elemen**:
  1. **Top Bar Status**:
     - Badge Kiri: `verified` "PORTAL RESMI KOTA" (transparan kaca `bg-white/10`).
     - Badge Kanan: `Live IoT` dengan animasi titik berkedip hijau toska (`#00BCD4`).
  2. **Logo Utama**:
     - Ukuran 116x116dp dalam kontainer glassmorphism bersudut `rounded-[28px]`, bayangan glow lembut.
  3. **Tipografi Judul**:
     - Tag badge: "KOTA CERDAS TERINTEGRASI".
     - H1: "Smart Public Facility" (`Domine`, 32px, Bold, Putih).
     - Subtitle: "Sistem Informasi Fasilitas Umum Berbasis Smart City".
  4. **Pill Highlight Layanan**:
     - Tiga kartu kaca mini: `Kesehatan`, `Mobilitas`, `Layanan`.
  5. **Indikator Loading**:
     - Progress bar gradasi `#00BCD4` dengan efek shimmer.
     - Teks tahapan (*Loading steps*):
       - "Menghubungkan ke Pusat Layanan Kota..." (35%)
       - "Sinkronisasi Peta & Sensor Fasilitas..." (65%)
       - "Memverifikasi Akses Publik..." (90%)
       - "Siap Digunakan" (100%)
  6. **Footer**:
     - Logo dinas "Diskominfo" dan badge versi "Versi 2.4.0".

---

### 6.2 Layar 2: Login Screen (Autentikasi Akun Warga)
* **Tujuan**: Gerbang masuk warga kota menggunakan NIK atau akun digital IKD.
* **Latar Belakang**: Biru gradasi `#0C3975` ke `#00838F` dengan pola blueprint arsitektur kota (*civic-grid* opacity 7%).
* **Komponen & Elemen**:
  1. **Header**:
     - Logo mini 32x32dp berdampingan dengan teks "KOTA CERDAS / Smart Public Facility".
     - Subtitle: "Portal Layanan Fasilitas Publik Terpadu".
  2. **Form Card Glassmorphism**:
     - Latar kartu putih salju `bg-white/95` bersudut `rounded-3xl` dengan padding 24dp.
     - Lencana avatar warga dengan ikon badge terverifikasi hijau (`verified`).
     - Judul: "Masuk ke Akun Warga".
  3. **Input Fields**:
     - **Field 1 (Username / NIK)**:
       - Label: "Username / NIK".
       - Ikon: `person`.
       - Placeholder: "Contoh: aditya.cahyo".
     - **Field 2 (Password / Kata Sandi)**:
       - Label: "Password / Kata Sandi".
       - Ikon: `lock`.
       - Tombol show/hide password dengan ikon `visibility` / `visibility_off`.
  4. **Checkbox & Link**:
     - Checkbox "Ingat Saya" (aksen warna `#1565C0`).
     - Teks link: "Lupa Password?".
  5. **Tombol Tindakan (CTA)**:
     - **Primary Button**: "Masuk Sekarang" (`bg-[#1565C0]`, teks putih, ikon panah kanan).
     - **Secondary Button**: "Masuk dengan Identitas Digital Warga (IKD)" (`bg-slate-100`, ikon badge).
  6. **Footer**:
     - Teks: "Belum terdaftar? Hubungi Kelurahan / Daftarkan Akun".

---

### 6.3 Layar 3: Main Dashboard (Direktori Fasilitas Publik)
* **Tujuan**: Eksplorasi katalog fasilitas umum terdekat berdasarkan kategori, radius, dan status buka.
* **Komponen & Elemen**:
  1. **Top App Bar (Sticky)**:
     - Logo 36x36dp + Teks "Smart Public Facility" & "Facility Directory".
     - Ikon lonceng notifikasi dan foto profil warga.
  2. **Banner Status Cerdas**:
     - Gradasi biru muda `from-[#D6E3FF] to-[#DEE8FF]` bersudut `rounded-xl`.
     - Teks: "KOTA CERDAS TERINTEGRASI — 148 Layanan Publik Aktif Hari Ini" + Badge "Live".
  3. **Kolom Pencarian & Filter Cepat**:
     - Search bar bentuk pill (`rounded-full`), placeholder: "Cari fasilitas, rumah sakit, taman...".
     - Tombol opsi filter (`tune`).
  4. **Horizontal Filter Chips**:
     - Chip aktif: `bg-[#004D99] text-white` (Contoh: "Semua").
     - Chip normal: `bg-[#DEE8FF] text-[#424752]` dengan ikon kategori:
       - `Taman Kota` (`park`)
       - `Kesehatan` (`local_hospital`)
       - `Transportasi` (`directions_bus`)
       - `Pendidikan` (`school`)
  5. **Daftar Kartu Fasilitas (CardView)**:
     Setiap item kartu memiliki struktur konsisten:
     - **Foto Fasilitas**: Rasio 1:1 (96x96dp) bersudut `rounded-xl` dengan badge mikro (misal: "Wi-Fi Free" atau "IGD").
     - **Kategori & Jarak**: Badge pill kategori (misal: "Taman & Rekreasi") + indikator jarak (misal: "0.8 km").
     - **Nama Fasilitas**: Font `Domine`, Headline-Sm (18px), warna `#111C2D`.
     - **Ringkasan**: 2 baris deskripsi singkat layanan.
     - **Status Baris Bawah**: Titik hijau status "Buka • Tutup 22.00" dan tombol "Detail >".
  6. **Banner Navigasi Peta Interaktif**:
     - Kotak pintasan menuju peta digital dengan tombol "Buka" (`arrow_outward`).
  7. **Bottom Navigation Bar**:
     - 4 Menu: `Home` (Aktif), `Search`, `Saved`, `Profile`.

---

### 6.4 Layar 4: Facility Detail Screen (Detail Fasilitas Publik)
* **Tujuan**: Menampilkan informasi komprehensif suatu fasilitas: lokasi presisi, sarana, jam buka, rute navigasi, dan kualitas lingkungan.
* **Komponen & Elemen**:
  1. **Header Navigasi**:
     - Tombol kembali (`arrow_back`), logo mini, judul "Facility Detail", tombol `share`, dan avatar profil.
  2. **Hero Image Banner (Tinggi 288dp)**:
     - Foto utama resolusi tinggi dengan gradasi gelap di bagian bawah.
     - Badge mengambang: "Buka Sekarang" (`bg-white/90`, teks hijau) dan ikon kategori.
     - Tag overlay bawah: "18 Foto Warga" dan "Ruang Terbuka Hijau".
  3. **Sheet Konten Melengkung (`-mt-6 rounded-t-[28px] bg-white`)**:
     - Handle bar penarik di bagian tengah atas (`w-12 h-1 bg-slate-300 rounded-full`).
     - Badge Kategori + Penilaian bintang: `★ 4.8 (1.2k Ulasan)`.
     - Nama Tempat: "Taman Kota Bungkul" (`Domine`, 26px Bold).
     - Pengelola: `verified` "Dikelola Resmi oleh Dinas Lingkungan Hidup Kota".
  4. **Tombol Aksi Cepat (3 Kolom Grid)**:
     - `Petunjuk Arah` (Warna aksen `primary-fixed`, ikon `near_me`).
     - `Bagikan` (Latar netral, ikon `share`).
     - `Simpan` (Toggle bookmark, label "Simpan" / "Tersimpan").
  5. **Blok Lokasi & Alamat**:
     - Alamat lengkap: "Jl. Raya Darmo No. 120, Pusat Kota. Bersebelahan dengan Halte BRT."
     - Cuplikan peta rute interaktif dengan tombol "Lihat Peta Lengkap".
  6. **Blok Jam Operasional**:
     - Status: "Aktif — Senin - Minggu: 05:00 - 22:00 WIB".
     - Catatan: "Terbuka untuk Umum • Tanpa Tiket Masuk".
  7. **Katalog Fasilitas Tersedia (Pill Badges)**:
     - 6 Sarana publik:
       1. `Wi-Fi Gratis` (`wifi`)
       2. `Jalur Jogging` (`directions_run`)
       3. `Taman Bermain` (`toys`)
       4. `Toilet Disabilitas` (`accessible`)
       5. `Area Parkir Sepeda` (`pedal_bike`)
       6. `Pos Keamanan CCTV` (`videocam`)
  8. **Deskripsi Naratif**:
     - Paragraf lengkap profil fasilitas dan pohon peneduh kota.
  9. **Widget Indeks Kualitas Udara (AQI)**:
     - Ikon angin `air` dengan indikator angka "AQI 32 • Sangat Baik & Segar" + Badge "Sehat".
  10. **Galeri Suasana Terkini**:
      - Dua foto preview warga: "Area Bunga" & "Taman Anak".
  11. **Floating Action Footer Bar (Fixed Bottom)**:
      - Tombol telepon darurat pengelola (`support_agent`).
      - Tombol navigasi rute utama: "Buka di Navigasi / Peta Digital" (lebar penuh, warna `primary-container`).

---

### 6.5 Layar 5: Profile & Settings Screen (Profil Warga & Konfigurasi)
* **Tujuan**: Manajemen identitas warga digital, riwayat aktivitas utilitas publik, preferensi notifikasi, dan sesi aplikasi.
* **Komponen & Elemen**:
  1. **Top Bar**:
     - Logo + Judul "Profile Settings", notifikasi, dan avatar profil.
  2. **Citizen Identity Card (Gradasi Biru Modern)**:
     - Background gradasi `from-[#004D99] to-[#1565C0]` dengan efek blur orbs.
     - Foto profil warga dengan indikator aktif digital.
     - Nama: **Aditya Cahyo** (`verified`).
     - Identitas Mahasiswa/Warga: "NIM: 2455301008 • Mahasiswa / Warga Terdaftar".
     - Badge: `Warga Aktif Digital`.
     - Statistik Mini:
       - **4** Fasilitas Tersimpan (`bookmark`).
       - **12** Ulasan Publik (`rate_review`).
  3. **Grup Menu: Akun & Preferensi**:
     - Edit Profil ("Perbarui data diri dan kontak").
     - Fasilitas Tersimpan ("Daftar taman dan RS favorit" + badge "4 Baru").
     - Riwayat Kunjungan ("Aktivitas check-in fasilitas").
  4. **Grup Menu: Pengaturan Aplikasi**:
     - Pengaturan Notifikasi (Dilengkapi toggle switch aktif/nonaktif).
     - Pengaturan Bahasa (Menampilkan teks pilihan: "Bahasa Indonesia").
     - Bantuan & Layanan Pengaduan ("Sampaikan kendala fasilitas").
     - Tentang Smart City App (Menampilkan nomor versi "v2.4.0").
  5. **Tombol Keluar Akun**:
     - Tombol `Logout / Keluar Akun` dengan warna merah terencana (`bg-[#C5242B]`), teks putih, dan dialog konfirmasi keamanan saat ditekan.
  6. **Bottom Navigation**:
     - Tab `Profile` berada dalam kondisi aktif (*Selected*).

---

## 7. Format Template Data Mock (Sample Model Data)

Agar data saat penyalinan ke model Kotlin konsisten, gunakan struktur data berikut:

```kotlin
data class PublicFacility(
    val id: String,
    val name: String,
    val category: FacilityCategory,
    val address: String,
    val distanceKm: Double,
    val rating: Double,
    val reviewCount: Int,
    val operatingHours: String,
    val isOpenNow: Boolean,
    val aqiIndex: Int?,
    val imageUrl: String,
    val amenities: List<String>,
    val managedBy: String,
    val description: String,
    val latitude: Double,
    val longitude: Double
)

enum class FacilityCategory(val displayName: String, val iconResName: String) {
    PARK("Taman & Rekreasi", "ic_park"),
    HOSPITAL("Kesehatan & Medis", "ic_hospital"),
    TRANSPORT("Transportasi", "ic_bus"),
    LIBRARY("Pendidikan & Literasi", "ic_book"),
    GOVERNMENT("Kantor Layanan", "ic_landmark")
}
```

### Data Sampel Fasilitas:
1. **Taman Kota Bungkul**:
   - Kategori: `PARK`
   - Jarak: `0.8 km` | Rating: `4.8` (1.200 ulasan)
   - Jam Buka: `05.00 - 22.00 WIB` | Status: `Buka`
   - AQI: `32` (Sangat Baik)
   - Alamat: "Jl. Raya Darmo No. 120, Pusat Kota."
2. **RSUD Kota Madya**:
   - Kategori: `HOSPITAL`
   - Jarak: `1.4 km` | Rating: `4.9` (3.450 ulasan)
   - Jam Buka: `Buka 24 Jam` | Status: `Buka (IGD 24 Jam)`
   - Alamat: "Jl. Pemuda No. 45, Kompleks Kesehatan Terpadu."
3. **Puskesmas Harapan Jaya**:
   - Kategori: `HOSPITAL`
   - Jarak: `2.1 km` | Rating: `4.6` (420 ulasan)
   - Jam Buka: `07.30 - 16.00 WIB` | Status: `Buka`
   - Alamat: "Jl. Harapan Jaya Indah Blok B/12."
4. **Perpustakaan Umum Daerah**:
   - Kategori: `LIBRARY`
   - Jarak: `3.5 km` | Rating: `4.7` (890 ulasan)
   - Jam Buka: `08.00 - 18.00 WIB` | Status: `Buka`
   - Alamat: "Jl. Gubernur Suryo No. 15."

---

## 8. Panduan Integrasi ke Kode Android

### 8.1 Pemetaan Warna di Compose (`Color.kt`)
```kotlin
package com.example.smartpublicfacility.ui.theme

import androidx.compose.ui.graphics.Color

val CivicPrimary = Color(0xFF004D99)
val CivicPrimaryContainer = Color(0xFF1565C0)
val CivicOnPrimary = Color(0xFFFFFFFF)
val CivicPrimaryFixed = Color(0xFFD6E3FF)

val CivicSecondary = Color(0xFF006876)
val CivicSecondaryContainer = Color(0xFF58E6FF)
val CivicAccentCyan = Color(0xFF00BCD4)

val CivicSurface = Color(0xFFF9F9FF)
val CivicSurfaceContainerLowest = Color(0xFFFFFFFF)
val CivicSurfaceContainerLow = Color(0xFFF0F3FF)
val CivicSurfaceContainer = Color(0xFFE7EEFF)
val CivicSurfaceContainerHigh = Color(0xFFDEE8FF)

val CivicOnSurface = Color(0xFF111C2D)
val CivicOnSurfaceVariant = Color(0xFF424752)
val CivicOutline = Color(0xFF727783)
val CivicOutlineVariant = Color(0xFFC2C6D4)

val CivicSuccess = Color(0xFF2E7D32)
val CivicWarning = Color(0xFFF57C00)
val CivicError = Color(0xFFBA1A1A)
val CivicDangerContainer = Color(0xFFC5242B)
```

### 8.2 Pemetaan Warna di XML (`res/values/colors.xml`)
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="civic_primary">#004D99</color>
    <color name="civic_primary_container">#1565C0</color>
    <color name="civic_on_primary">#FFFFFF</color>
    <color name="civic_primary_fixed">#D6E3FF</color>

    <color name="civic_secondary">#006876</color>
    <color name="civic_secondary_container">#58E6FF</color>
    <color name="civic_accent_cyan">#00BCD4</color>

    <color name="civic_background">#F9F9FF</color>
    <color name="civic_surface">#F9F9FF</color>
    <color name="civic_surface_card">#FFFFFF</color>
    <color name="civic_surface_container_low">#F0F3FF</color>
    <color name="civic_surface_container_high">#DEE8FF</color>

    <color name="civic_on_surface">#111C2D</color>
    <color name="civic_on_surface_variant">#424752</color>
    <color name="civic_outline">#727783</color>
    <color name="civic_outline_variant">#C2C6D4</color>

    <color name="civic_status_open">#2E7D32</color>
    <color name="civic_status_warning">#F57C00</color>
    <color name="civic_status_danger">#C5242B</color>
</resources>
```
