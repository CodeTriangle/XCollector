package JSONTest;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class JSONTest {
    public static Map object;

    public static void main(String args[]) {
        object = new HashMap<>();
        object.put("test1", "Test 1");
        object.put("test2", new Random().nextInt());
        object.put("test3", true);
        object.put("test4", null);
        object.put("test5", new Random().nextFloat());

        String jsonString = JSONValue.toJSONString(object);
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File("data/test.xc"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println(jsonString);
        out.close();
        System.out.println(jsonString);
    }
}
