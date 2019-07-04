package hertz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author sunyi,
 * @date 2019/6/5,
 * @time 10:47,
 */
public class azkaban {
    public void run() throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("/opt/52hertz/haha");
        fileOutputStream.write("加油 Hertz".getBytes());
        fileOutputStream.close();
    }


    public static  void main(String[] args) throws Exception {

        azkaban azkaban = new azkaban();
        azkaban.run();

    }
}
