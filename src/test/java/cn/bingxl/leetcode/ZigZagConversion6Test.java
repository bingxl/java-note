package cn.bingxl.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZigZagConversion6Test {
    private record CaseType(String s, int numRows, String expect) {
    };

    private ZigZagConversition6 ins = new ZigZagConversition6();
    private CaseType[] cases = {
            new CaseType("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
            new CaseType("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
            new CaseType("A", 1, "A"),
            new CaseType("AB", 1, "AB")
    };

    @Test
    public void convertTest() {
        for (var ca : cases) {
            String get = ins.convert(ca.s, ca.numRows);
            assertEquals(String.format("expect: %s, but get: %s", ca.expect, get), get, ca.expect);
        }
    }

    @Test
    public void solution2Test() {
        for (var ca : cases) {
            String get = ins.solution2(ca.s, ca.numRows);
            assertEquals(String.format("expect: %s, but get: %s", ca.expect, get), get,
                    ca.expect);
        }
    }

}
