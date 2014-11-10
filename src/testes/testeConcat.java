package testes;

import field.*;

public class testeConcat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] vet1;
		vet1 = concat();
		System.out.println(unpack(vet1));
		
	}
	
	public static byte[] concat(){
		int[] vet2 = {1, 2};
		int[] vet3 = {3, 4};
		byte[] vet4 = new byte[4];
		System.arraycopy(vet2, 0, vet4, 0, vet2.length);
		System.arraycopy(vet3, 0, vet4, vet2.length, vet3.length);
		return null;
	}
	
	public static int[] concat2(){
		int[] vet2 = {1, 2};
		int[] vet3 = {3, 4};
		int[] vet4 = new int[4];
		System.out.println(vet2);
		System.arraycopy(vet2, 0, vet4, 0, vet2.length);
		System.arraycopy(vet3, 0, vet4, vet2.length, vet3.length);
		return vet4;
	}
	
	public static int unpack(byte[] vet){
		return Convert.byteToInt(vet,4);
	}
	
}
