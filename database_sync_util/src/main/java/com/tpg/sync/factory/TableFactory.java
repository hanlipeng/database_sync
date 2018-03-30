package com.tpg.sync.factory;

import com.tpg.sync.sqlbuilder.SqlBuilder;
import com.tpg.sync.syncbuilder.SyncMethod;
import com.tpg.sync.util.Utils;

import java.util.Properties;

/**
 *
 * @author reph
 * @date 2017/6/16
 */
public class TableFactory {
    private static Properties tableType= Utils.getTableType();
    private static final String SRC_SQL_TYPE ="srcbuilder.";
    private static final String DEST_SQL_TYPE ="destbuilder.";
    private static final String METHOD_TYPE="syncmethod.";


    public static SyncMethod getSyncMethodInstanceByTableType(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String key = METHOD_TYPE + type;
        String property = tableType.getProperty(key);
        return (SyncMethod) Class.forName(property).newInstance();
    }
    public static SqlBuilder getSrcSqlBuilderInstanceByTableType(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (SqlBuilder) Class.forName(tableType.getProperty(SRC_SQL_TYPE +type)).newInstance();
    }
    public static SqlBuilder getDestSqlBuilderInstanceByTableType(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (SqlBuilder) Class.forName(tableType.getProperty(DEST_SQL_TYPE +type)).newInstance();
    }

}
