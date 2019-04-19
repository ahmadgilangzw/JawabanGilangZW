package com.ahmadgilang.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OperationMain {
	
	public static void main(String[]args){
		List<Mahasiswa> listMahasiswa = new ArrayList<>();	
	
		listMahasiswa = EngineUtils.inputData();
		
		for (int i = 0; i < listMahasiswa.size(); i++) {
			listMahasiswa.get(i).setNilaiAkhir(EngineUtils.hitungNilaiAkhir(listMahasiswa.get(i).getNilaiKehadiran(), listMahasiswa.get(i).getNilaiMidtest(), listMahasiswa.get(i).getNilaiUas()));
			listMahasiswa.get(i).setGrade(EngineUtils.gradeNilai(listMahasiswa.get(i).getNilaiAkhir()));
		}
		
		try{
			EngineUtils.cetakData(listMahasiswa);
			EngineUtils.writeFile(listMahasiswa);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
