package test;

import org.apache.commons.lang.StringUtils;
import org.jeecgframework.codegenerate.pojo.onetomany.CodeParamEntity;
import org.jeecgframework.jwt.util.GsonUtil;

/**
 * 测试类
 * @author Libin
 * @date 2018/10/10
 */
public class BeanToJson {

    public static void main(String[] args) {
        CodeParamEntity obj = new CodeParamEntity();
        obj.setTableName("表名");
        obj.setEntityName("TestOrderMain");
        obj.setEntityPackage("test");
        obj.setFtlDescription("订单");
        // 实体Bean转换成JSON字符串 {\"entityPackage\":\"test\",\"tableName\":\"表名\"}
        String jsonStr = GsonUtil.toJson(obj);
        String str = StringUtils.join(jsonStr.split("\""), "\\\"");
        System.out.println(str);
    }


}
