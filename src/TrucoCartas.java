import java.util.Random;
import java.util.Scanner;

public class TrucoCartas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		char letras [][] = new char[7][3];
		char grupo1[] = new char[7]; 
		char grupo2[] = new char[7]; 
		char grupo3[] = new char[7];
		char orden[] = new char[21]; 
		char let;
		int en;
		String entrada;
		
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 3; j++){
				let = (char)(rd.nextInt(26)+65);
				int k = 0;
				while(k <= i){
					int c = 0;
					while(c < 3){
						if(letras[k][c] == let){
							c = 0;
							k = 0;
							let = (char)(rd.nextInt(26)+65);
						}else{
							c++;
						}
					}
					k++;
				}
				letras[i][j] = let;
			}
		}	
		
		for(int i = 0; i < 7; i++){
			grupo1[i] = letras[i][0];
		}
		for(int i = 0; i < 7; i++){
			grupo2[i] = letras[i][1];
		}
		for(int i = 0; i < 7; i++){
			grupo3[i] = letras[i][2];
		}
		
		System.out.println("\n\nVamos a hacer 3 secuencias, empecemos:... \n");
		System.out.println("Presione ENTER para comenzar");
		sc.nextLine();
		int j = 0;
		while(j <= 3){
			if(j < 3){
				System.out.println("\nSecuencia "+(j+1)+": \n");
				for(int i = 0; i < 7; i++){
					System.out.println("\t "+grupo1[i]+"   "+grupo2[i]+"   "+grupo3[i]);
				}
				System.out.print("\nEn que grupo esta tu tarjeta [1,2,3]: ");
				entrada = sc.nextLine();
				while(entrada == "1" || entrada == "2" || entrada == "3") {
					System.out.print("ERROR---. Debes ingresar una opcion valida [1,2,3]: ");
					entrada = sc.nextLine();
					if(entrada == "1" || entrada == "2" || entrada == "3"){
						break;
					}
				}
				switch(entrada){
		 			case "1":
		 				for(int i = 0; i < 21; i++){
		 					if(i < 7){
		 						orden[i] = grupo2[i];
		 					}else if(i >= 7 && i <= 13){
		 						orden[i] = grupo1[i-7];
		 					}else{
		 						orden[i] = grupo3[i-14];
		 					}
		 				}
		 				int k = 0, l = 0;
		 				while(k < 21 && l < 7) {
		 					grupo1[l] = orden[k];
		 					grupo2[l] = orden[k+1];
		 					grupo3[l] = orden[k+2];
		 					k+=3;
		 					l++;
		 				}
		 				break;
		 			case "2":
		 				for(int i = 0; i < 21; i++){
		 					if(i < 7){
		 						orden[i] = grupo3[i];
		 					}else if(i >= 7 && i <= 13){
		 						orden[i] = grupo2[i-7];
		 					}else{
		 						orden[i] = grupo1[i-14];
		 					}
		 				}
		 				int p = 0, o = 0;
		 				while(p < 21 && o < 7) {
		 					grupo1[o] = orden[p];
		 					grupo2[o] = orden[p+1];
		 					grupo3[o] = orden[p+2];
		 					p+=3;
		 					o++;
		 				}
		 				break;
		 			case "3":
		 				for(int i = 0; i < 21; i++){
		 					if(i < 7){
		 						orden[i] = grupo1[i];
		 					}else if(i >= 7 && i <= 13){
		 						orden[i] = grupo3[i-7];
		 					}else{
		 						orden[i] = grupo2[i-14];
		 					}
		 				}
		 				int b = 0, n = 0;
		 				while(b < 21 && n < 7) {
		 					grupo1[n] = orden[b];
		 					grupo2[n] = orden[b+1];
		 					grupo3[n] = orden[b+2];
		 					b+=3;
		 					n++;
		 				}
		 				break;
		 			}
			}
			j++;
		}
		sc.close();
		System.out.println("\n\n\tObviamente estabas pensando en la letra: "+grupo2[3]);
	}

}
