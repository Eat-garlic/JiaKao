package com.eglc.jk;

import org.assertj.core.error.ShouldBeAfterYear;

public class SqlTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String sql = "INSERT INTO dict_type(name,value,intro) values ('哈哈%d','hah%d','%d');\n";
            System.out.format(sql,i,i,i);
        }
    }
}
