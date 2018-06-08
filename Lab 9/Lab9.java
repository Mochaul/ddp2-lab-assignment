import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Lab9 {
	public static void main(String[] args) throws IOException{
		FileReader file = new FileReader("input.in.txt");
		PrintWriter out = new PrintWriter("output.out.txt");
		BufferedReader scan = new BufferedReader(file);
		ArrayList<String> list = new ArrayList<>();
		try{
			int N = Integer.parseInt(scan.readLine());
			String[] angkaList = scan.readLine().split(" ");
			for(int i = 0; i < N; i++){
				list.add(angkaList[i]);
			}
			int M = Integer.parseInt(scan.readLine());
			for(int x = 0; x < M; x++){
				String[] input = scan.readLine().split(" ");
				int X = Integer.parseInt(input[1]);
				int Y = Integer.parseInt(input[2]);
				if(Integer.parseInt(input[2]) < 1){
					X = 1;
				}if(Integer.parseInt(input[2]) > N){
					out.println("[ERROR] : nilai y melebihi nilai N, y diset sebesar banyaknya N");
					Y = N;
				}
				switch(input[0].toLowerCase()){
				case "min":
					min(list, X-1, Y-1, out);
					break;
				case "median":
					median(list, X-1, Y-1, out);
					break;
				case "mean":
					mean(list, X-1, Y-1, out);
					break;
				case "varian":
					var(list, X-1, Y-1, out);
					break;
				default:
					out.println("[ERROR] : Operasi \"" + input[0] + "\" tidak valid");
					break;
				}	
					
			}
		}catch(IOException e){
			out.println("[ERROR] : file input.in.txt tidak ditemukan");
			out.close();
			System.exit(0);
		}catch(NumberFormatException e){
			out.println("[ERROR] : N atau M bukan integer");
			file.close();
			scan.close();
			out.close();
			System.exit(0);
		}catch(NullPointerException e){
			out.println("[ERROR] : input line di input.in kurang dari M");
			file.close();
			scan.close();
			out.close();
			System.exit(0);
		}
		out.close();
		file.close();
		scan.close();
	}
	
	public static void min(ArrayList<String> list, int x, int y, PrintWriter out){
		int X = 0;
		int Y = y-x;
		int min;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> error = new ArrayList<Integer>();
		for(int i = x; i < (y-x+2); i++){
			try{
				temp.add(Integer.parseInt(list.get(i)));
			}catch(NumberFormatException e){
				out.println("[ERROR] : Invalid number format at index " + i);
				error.add(i);
			}
		}
		if (temp.isEmpty()){
			out.println("[ERROR] : tidak ada nilai minimal");
		}else if(temp.size() == 1){
			out.println("Nilai minimum dari indeks ke " + (X+x+1) + " - " + (Y+x+1) + " adalah " + temp.get(0));
		}else{
			int j = 0;
			int k = y-x;
			while(error.contains(j)){
				X++;
				j++;
			}
			while(error.contains(k)){
				Y--;
				k--;
			}
			min = temp.get(0);
			for (int i = 1; i < temp.size(); i++){
				if (temp.get(i) <= min){
					min = temp.get(i);
				}
			}
			out.println("Nilai minimum dari indeks ke " + (X+x+1) + " - " + (Y+x+1) + " adalah " + min);
		}
	}
	
	public static void median(ArrayList<String> list, int x, int y, PrintWriter out){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = x; i < y+1; i++){
			try{
				temp.add(Integer.parseInt(list.get(i)));
			}catch(NumberFormatException e){
				out.println("[ERROR] : Invalid number format at index " + i);
			}
		}
		Collections.sort(temp);
		int banyak = temp.size();
		if(banyak == 0){
			out.println("[ERROR] : Nilai median tidak ada");
		}else if((banyak % 2) == 1){
			out.println("Nilai median dari indeks ke " + (x+1) + " - " + (y+1) + " adalah " + temp.get(banyak / 2));
		}else{
			double bil1 = temp.get((banyak-1) / 2);
			double bil2 = temp.get(((banyak-1) / 2) + 1);
			out.println("Nilai median dari indeks ke " + (x+1) + " - " + (y+1) + " adalah " + ((bil1 + bil2)/2.0));
		}
	}
	
	public static void mean(ArrayList<String> list, int x, int y, PrintWriter out){
		int X = 0;
		int Y = y-x;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> error = new ArrayList<Integer>();
		for(int i = x; i < (Y+1); i++){
			try{
				temp.add(Integer.parseInt(list.get(i)));
			}catch(NumberFormatException e){
				out.println("[ERROR] : Invalid number format at index " + i);
				error.add(i);
			}
		}
		if (temp.isEmpty()){
			out.println("[ERROR] : tidak ada nilai mean");
		}else if(temp.size() == 1){
			out.println("Nilai mean dari indeks ke " + (X+x+1) + " - " + (Y+x+1) + " adalah " + temp.get(0));
		}else{
			int j = 0;
			int k = y-x;
			while(error.contains(j)){
				X++;
				j++;
			}
			while(error.contains(k)){
				Y--;
				k--;
			}
			double banyak = temp.size();
			double jml = 0;
			for (int i: temp){
				jml += i;
			}
			double hasil = jml / banyak;
			out.println("Nilai mean dari indeks ke " + (X+x+1) + " - " + (Y+x+1) + " yang sudah tersortir adalah " + hasil);
		}
	}
	
	public static void var(ArrayList<String> list, int x, int y, PrintWriter out){
		int X = 0;
		int Y = y-x;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> error = new ArrayList<Integer>();
		for(int i = 0; i < (y-x+1); i++){
			try{
				temp.add(Integer.parseInt(list.get(i)));
			}catch(NumberFormatException e){
				out.println("[ERROR] : Invalid number format at index " + i);
				error.add(i);
			}
		}
		if (temp.size() <= 1){
			out.println("[ERROR] : tidak ada nilai varian");
		}else{
			int j = 0;
			int k = y-x;
			while(error.contains(j)){
				X++;
				j++;
			}
			while(error.contains(k)){
				Y--;
				k--;
			}
			double banyak = temp.size();
			double jml = 0;
			for (int i: temp){
				jml += i;
			}
			double mean = jml / banyak;
			ArrayList<Double> sigma = new ArrayList<>();
			for(int i: temp){
				sigma.add(Math.pow(i - mean, 2));
			}
			Double jumlahnya = 0.0;
			for (Double d: sigma){
				jumlahnya += d;
			}
			out.println("Nilai varian dari indeks ke " + (X+x+1) + " - " + (Y+x+1) + " adalah " + (jumlahnya / (banyak-1)));
		}
	}
}
