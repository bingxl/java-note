package cn.bingxl.example;

/**
 * 枚举类例子
 * 
 * @author bingxl <bingxl@outlook.com>
 * @date 2021/08/29
 */
public class EnumExample {
    public static void main(String[] args) {
        Util.print(SeasonEnum.AUTUM);
    }

    /**
     * 季节
     */
    enum SeasonEnum {
        SPRING, SUMMER, AUTUM, WINTER;
    }
}
