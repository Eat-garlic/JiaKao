package com.eglc.jk.pojo.vo;

import com.eglc.jk.pojo.result.CodeMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 *这个返回值就是取代了之前没改之前 的R，这个只是用来做返回 结果 代码 的
 */
@Data
@ApiModel("返回结果")
public class JsonVo  {

    @ApiModelProperty("代码0代表成功，其他代表失败")
    private Integer code;

    @ApiModelProperty("消息描述")
    private String msg;

    public static final int CODE_OK = CodeMsg.OPERATE_OK.getCode();
    public static final int CODE_ERROR = CodeMsg.BAD_REQUEST.getCode();


    public JsonVo(){
        this(true);
    }

    public JsonVo(Boolean ok){
        this(ok, null);
    }


    public JsonVo (Boolean ok, String msg) {
        //三目运算符用的不熟练
        this(ok ? CODE_OK : CODE_ERROR, msg);
    }



    public JsonVo (int code, String msg){
        this.code = code;
        this.msg = msg;
    }



    public JsonVo (CodeMsg codeMsg){
        this(codeMsg.getCode(),  codeMsg.getMsg());

    }




}
