package T400_T500;

import java.util.LinkedList;
import java.util.List;

public class T401 {

    public static List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();

        for (int i = 0; i < 4 && i <= num; ++i) {
            if (num - i > 5) continue;
            generate(i, num - i, 0, 0, res);
        }
        return res;
    }

    private static void generate(int hourLED, int minuteLED, int start, int hour, List<String> res) {
        if (hour > 11) return;
        if (hourLED == 0) {
            List<String> minutes = new LinkedList<>();
            generateMinute(minuteLED, 0, 0, minutes);
            for (String minute : minutes) {
                res.add(hour + ":" + minute);
            }
            return;
        }
        for (int i = start; i < 4 - hourLED + 1; ++i) {
            generate(hourLED - 1, minuteLED, i + 1, (int) (hour + Math.pow(2, i)), res);
        }
    }

    private static void generateMinute(int minuteLED, int start, int minute, List<String> minutes) {
        if (minute > 59) return;
        if (minuteLED == 0) {
            minutes.add(minute > 9 ? String.valueOf(minute) : "0" + minute);
            return;
        }
        for (int i = start; i < 6 - minuteLED + 1; i++) {
            generateMinute(minuteLED - 1, i + 1, (int) (minute + Math.pow(2, i)), minutes);
        }
    }

    public static void main(String[] args) {
        for (String s : readBinaryWatch(2)) {
            System.out.println(s);
        }
    }

}
