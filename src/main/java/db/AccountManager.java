package db;

import java.util.HashSet;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/28
 */
public class AccountManager {
    private static HashSet<String> types = new HashSet<>();

    public static HashSet<String> getTypes() {
        return types;
    }

    public static void setTypes(HashSet<String> types) {
        AccountManager.types = types;
    }
}
