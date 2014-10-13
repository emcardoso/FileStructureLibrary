package testes;

import field.Convert;

public class testeCabecalho {

    public static void main(String[] args) {

        short num = 25678;
        int num1 = 230456456;
        long num2 = 2385134875193845l;

        byte[] bShort = new byte[2];
        byte[] bInt = new byte[4];
        byte[] bLong = new byte[8];

        bShort = Convert.shortToByte(num, 2);
        bInt = Convert.intToByte(num1, 4);
        bLong = Convert.longToByte(num2, 8);

        printByteArray(bShort);
        System.out.println(" -> " + Convert.byteToShort(bShort, 2));

        printByteArray(bInt);
        System.out.println(" -> " + Convert.byteToInt(bInt, 4));

        printByteArray(bLong);
        System.out.println(" -> " + Convert.byteToLong(bLong, 8));
    }

    public static void printByteArray(byte b[]) {
        System.out.print("[" + ((int) b[0] & 0xFF));
        for (int i = 1; i < b.length; i++) {
            System.out.print(" ," + ((int) b[i] & 0xFF));
        }
        System.out.print("]");
    }
}
