package cn.bingxl.example;

public class Statements {
    public static enum Size {
        SMALL, MEDIUM, LARGE, EXTRA_LARGE
    };

    public static void main(String[] args) {

        // if 语句
        if (args.length > 1) {
            System.out.println(args[1]);
        } else if (args.length == 1) {
            System.out.println(args[0]);
        } else {
            System.out.println("没穿参数");
        }

        // for语句
        int[] arrs = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
            if (i == 1) {
                continue;
            }
            if (i == 4) {
                break;
            }
        }
        for (int v : arrs) {
            System.out.println(v);
        }

        // while
        int i = 0;
        while (i < arrs.length) {
            // do something
            i++;
        }
        i = 0;
        do {
            // do something
            i++;
        } while (i < arrs.length);

        // switch
        Size s = Size.SMALL;
        switch (s) {
            case SMALL: {
                break;
            }
            case MEDIUM: {
                break;
            }
            case LARGE: {
                break;
            }
            case EXTRA_LARGE: {
                break;
            }
            default: {

            }
        }

        // 使用 var 定义变量时需要能通过右侧赋值语句推测出变量类型
        var sizeName = switch (s) {
            case SMALL -> {
                System.out.println("hello switch");
                // 代码块中使用 yield 返回值
                yield "SMALL";
            }
            case MEDIUM, LARGE -> "MEDIUM or LARGE";

            case EXTRA_LARGE -> "EXTRA_LARGE";
            default -> "default";
        };
        System.out.println(sizeName);

    }
}
