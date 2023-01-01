package com.eglc.jk;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.eglc.jk.pojo.po.DictType;
import org.assertj.core.error.ShouldBeAfterYear;

public class SqlTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String sql = "INSERT INTO dict_type(name,value,intro) values ('哈哈%d','hah%d','%d');\n";
            System.out.format(sql,i,i,i);
        }

        LambdaQueryWrapper<DictType> wrapper = new LambdaQueryWrapper<>();
    }
}
