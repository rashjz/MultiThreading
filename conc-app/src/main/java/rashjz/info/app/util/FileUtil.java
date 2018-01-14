package rashjz.info.app.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    private static int maxConnection = 5;

    public static int getMaxConnection() {
        return maxConnection;
    }

    public static String getParentDir(String s) {
        System.out.println("getParentDir " + s);
        Path path = Paths.get(s);
        return path.getParent().toString();
    }

    public void getParentDirVoid(String s) {
        System.out.println("getParentDirVoid " + s);
    }

    private int getPrivateHashOfMaxConn(int hash) {
        return maxConnection * hash;
    }


}
