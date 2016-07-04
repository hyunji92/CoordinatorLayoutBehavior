package Util;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyunji on 16. 7. 4..
 */
public class Utils {

    private static final int ITEM_COUNT = 35;

    public static List<String> getSampleData() {
        return getSampleData(ITEM_COUNT);
    }

    public static List<String> getSampleData(int count) {
        List<String> data = new ArrayList<>();
        int i = 0;
        for (int n = count; i < n; i++) {
            data.add(String.format("Line %d", i));
        }
        return data;
    }

    public static void log(String s, Object... args) {
        Log.d("SmoothAppBarLayoutDemo", String.format(s, args));
    }
}
