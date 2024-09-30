/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemmanajemenfilmfavoritpribadi;

import java.util.ArrayList;
import java.util.Scanner;

// Kelas Film
class Film {
    private final String judul;
    private final String genre;
    private final int tahunRilis;
    private final double rating;

    // Constructor
    public Film(String judul, String genre, int tahunRilis, double rating) {
        this.judul = judul;
        this.genre = genre;
        this.tahunRilis = tahunRilis;
        this.rating = rating;
    }

    // Getters
    public String getJudul() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public int getTahunRilis() {
        return tahunRilis;
    }

    public double getRating() {
        return rating;
    }

    // Method untuk menampilkan detail film
    public void tampilkanDetail() {
        System.out.printf("%-20s %-15s %-10s %-6s\n", judul, genre, tahunRilis, rating);
    }
}

// Kelas FilmManager
class FilmManager {
    private static final ArrayList<Film> daftarFilm = new ArrayList<>();

    // Method untuk menambahkan film
    public static void tambahFilm(Film film) {
        daftarFilm.add(film);
        System.out.println("\nFilm berhasil ditambahkan: " + film.getJudul());
        System.out.println("------------------------------------------");
    }

    // Method untuk menampilkan semua film
    public static void tampilkanSemuaFilm() {
        System.out.println("\n=============== Daftar Film Favorit ===============");
        if (daftarFilm.isEmpty()) {
            System.out.println("Belum ada film yang ditambahkan.");
        } else {
            System.out.printf("%-20s %-15s %-10s %-6s\n", "Judul", "Genre", "Tahun", "Rating");
            System.out.println("----------------------------------------------------");
            for (Film film : daftarFilm) {
                film.tampilkanDetail();
            }
        }
        System.out.println("===================================================");
    }

    // Method untuk menghapus film berdasarkan judul
    public static void hapusFilm(String judul) {
        boolean ditemukan = false;
        for (Film film : daftarFilm) {
            if (film.getJudul().equalsIgnoreCase(judul)) {
                daftarFilm.remove(film);
                System.out.println("\nFilm berhasil dihapus: " + judul);
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("\nFilm dengan judul '" + judul + "' tidak ditemukan.");
        }
        System.out.println("------------------------------------------");
    }
}

// Kelas MainApp
public class SistemManajemenFilmFavoritPribadi {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int pilihan;
            
            do {
                System.out.println("\n===========================================");
                System.out.println("Selamat Datang di Daftar Film Favorit Anda!");
                System.out.println("===========================================");
                System.out.println("1. Tambah Film");
                System.out.println("2. Tampilkan Semua Film");
                System.out.println("3. Hapus Film");
                System.out.println("4. Keluar");
                System.out.print("Pilih opsi (1-4): ");
                pilihan = scanner.nextInt();
                scanner.nextLine(); // konsumsi newline
                
                switch (pilihan) {
                    case 1:
                        // Tambah film baru
                        System.out.println("\n--- Tambah Film Baru ---");
                        System.out.print("Masukkan judul film: ");
                        String judul = scanner.nextLine();
                        System.out.print("Masukkan genre film: ");
                        String genre = scanner.nextLine();
                        System.out.print("Masukkan tahun rilis: ");
                        int tahunRilis = scanner.nextInt();
                        System.out.print("Masukkan rating film (0.0 - 10.0): ");
                        double rating = scanner.nextDouble();
                        scanner.nextLine(); // konsumsi newline
                        Film filmBaru = new Film(judul, genre, tahunRilis, rating);
                        FilmManager.tambahFilm(filmBaru);
                        break;
                    case 2:
                        // Tampilkan semua film
                        FilmManager.tampilkanSemuaFilm();
                        break;
                    case 3:
                        // Hapus film berdasarkan judul
                        System.out.println("\n--- Hapus Film ---");
                        System.out.print("Masukkan judul film yang akan dihapus: ");
                        String judulHapus = scanner.nextLine();
                        FilmManager.hapusFilm(judulHapus);
                        break;
                    case 4:
                        System.out.println("Sampai Jumpa Lagi, Terima kasih!");
                        break;
                    default:
                        System.out.println("\nPilihan tidak valid. Silakan coba lagi.");
                }
            } while (pilihan != 4);
        }
    }
}
