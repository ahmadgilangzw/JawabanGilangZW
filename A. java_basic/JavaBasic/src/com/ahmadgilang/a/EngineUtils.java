package com.ahmadgilang.a;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EngineUtils {
	
	private static Scanner keyboard;

	/**
	 * Input Data
	 * @return
	 */
	public static List<Mahasiswa> inputData(){
		Integer jmlMahasiswa = 0;
		List<Mahasiswa> listMahasiswa = new ArrayList<>();
		
		try{
			keyboard = new Scanner(System.in);
			System.out.print("Masukan Jumlah Mahasiswa : ");
			jmlMahasiswa = Integer.parseInt(keyboard.next());
			
			for (int i = 1; i <= jmlMahasiswa; i++) {
				System.out.println("==================== Masukan Data Mahasiswa Ke "+i+" =======================");
				
				Mahasiswa mahasiswa = new Mahasiswa();
				System.out.print("Masukan NIM				: ");
				mahasiswa.setNim(keyboard.next());
				System.out.print("Masukan Nama				: ");
				mahasiswa.setNama(keyboard.next());
				System.out.print("Masukan Nilai Kehadiran			: ");
				mahasiswa.setNilaiKehadiran(Integer.parseInt(keyboard.next()));
				System.out.print("Masukan Nilai Midtest			: ");
				mahasiswa.setNilaiMidtest(Integer.parseInt(keyboard.next()));
				System.out.print("Masukan Nilai UAS			: ");
				mahasiswa.setNilaiUas(Integer.parseInt(keyboard.next()));
				listMahasiswa.add(mahasiswa);
				
				System.out.println("============================================================================");
				System.out.println("");
			}
		}catch (NumberFormatException e) {
			System.out.println("ERROR : Silahkan Masukan Angka");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listMahasiswa;
	}
	
	/**
	 * Menentukan Grade
	 * @param nilaiAkhir
	 * @return
	 */
	public static String gradeNilai(Integer nilaiAkhir){
		if(nilaiAkhir >= 85 && nilaiAkhir <= 100){
			return "A"; 
		}else if(nilaiAkhir >= 76 && nilaiAkhir <= 84){
			return "B";
		}else if(nilaiAkhir >= 61 && nilaiAkhir <= 75){
			return "C";
		}else if(nilaiAkhir >= 46 && nilaiAkhir <= 60){
			return "D";
		}else if(nilaiAkhir >= 0 && nilaiAkhir <= 45){
			return "E";
		}
		return "-";
	}
	
	
	/**
	 * Hitung Nilai Akhir
	 * @param nilaiKehadiran
	 * @param nilaiMidtest
	 * @param nilaiUas
	 * @return
	 */
	public static Integer hitungNilaiAkhir(Integer nilaiKehadiran, Integer nilaiMidtest, Integer nilaiUas){
		Double nilaiAkhir = (0.2 * nilaiKehadiran) + (0.4 * nilaiMidtest) + (0.4 * nilaiUas);
		return nilaiAkhir.intValue();
	}
	
	
	/**
	 * printData
	 * @param listMahasiswa
	 */
	public static void cetakData(List<Mahasiswa> listMahasiswa){
		Integer mahasiswaLulus = 0;
		Integer mahasiswaTidakLulus = 0;
		
		System.out.println("No. NIM Nama Nilai Akhir Grade");
		System.out.println("============================================");
		for (int i = 0; i < listMahasiswa.size(); i++) {
			System.out.print((i+1)+". ");
			System.out.print(listMahasiswa.get(i).getNim() +" ");
			System.out.print(listMahasiswa.get(i).getNama() +" ");
			System.out.print(listMahasiswa.get(i).getNilaiAkhir() +" ");
			System.out.print(listMahasiswa.get(i).getGrade());
			System.out.println("");
			
			if(listMahasiswa.get(i).getNilaiAkhir() >= 61 && listMahasiswa.get(i).getNilaiAkhir() <= 100){
				mahasiswaLulus++;
			}else{
				mahasiswaTidakLulus++;
			}
		}
		System.out.println("============================================");
		System.out.println("");
		System.out.println("Jumlah Mahasiswa : " + listMahasiswa.size() +" (berdasarkan hasil kalkulasi)");
		System.out.println("Jumlah Mahasiswa yang Lulus : " + mahasiswaLulus + " (berdasarkan hasil kalkulasi)");
		System.out.println("Jumlah Mahasiswa yang Lulus : " + mahasiswaTidakLulus + " (berdasarkan hasil kalkulasi)");
		System.out.println("");
		System.out.println("============================================");
	}
	
	
	public static void writeFile(List<Mahasiswa> listMahasiswa) throws IOException{
		Integer mahasiswaLulus = 0;
		Integer mahasiswaTidakLulus = 0;
		String file = "mahasiswa.nilai";
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file))) {
			writer.write("No. NIM Nama Nilai Akhir Grade\n");
			writer.write("============================================\n");
			for (int i = 0; i < listMahasiswa.size(); i++) {
				writer.write((i+1)+". ");
	        	writer.write(listMahasiswa.get(i).getNim() +" ");
	        	writer.write(listMahasiswa.get(i).getNama() +" ");
				writer.write(listMahasiswa.get(i).getNilaiAkhir() +" ");
				writer.write(listMahasiswa.get(i).getGrade()); 
	        	
	        	if(listMahasiswa.get(i).getNilaiAkhir() >= 61 && listMahasiswa.get(i).getNilaiAkhir() <= 100){
					mahasiswaLulus++;
				}else{
					mahasiswaTidakLulus++;
				}
	        	writer.write("\n");
			}
			writer.write("============================================");
			writer.write("\n");
			writer.write("\n");
			writer.write("Jumlah Mahasiswa : " + listMahasiswa.size() +" (berdasarkan hasil kalkulasi) \n");
			writer.write("Jumlah Mahasiswa yang Lulus : " + mahasiswaLulus + " (berdasarkan hasil kalkulasi) \n");
			writer.write("Jumlah Mahasiswa yang Lulus : " + mahasiswaTidakLulus + " (berdasarkan hasil kalkulasi) \n");
			writer.write("\n");
			writer.write("============================================");
		} 
	}
	
}
