package leetcode;

public class T1694 {

    public String reformatNumber(String number) {
        number = number.replace("-", "").replace(" ", "");
        int len = number.length(), index = 0;
        StringBuilder sb = new StringBuilder();
        while (len > 4) {
            sb.append(number, index, index + 3).append("-");
            len -= 3;
            index += 3;
        }
        if (len == 4) {
            sb.append(number, index, index + 2).append("-")
                    .append(number, index + 2, index + 4).append("_");
        } else if (len == 3) {
            sb.append(number, index, index + 3).append("-");
        } else {
            sb.append(number, index, index + 2).append("-");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static void main(String[] args) {
        System.out.println(new T1694().reformatNumber("1-23-45 6"));
    }

}
