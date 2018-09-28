public class T405 {

    public static String toHex(int num) {
        if(num==0) return "0";
        StringBuilder hexString = new StringBuilder();
        String hexChar = "0123456789abcdef";
        while (num != 0) {
            hexString.append(hexChar.charAt(num & 0xf));
            num >>>= 4;
        }
        return hexString.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
    }
}
