package cn.zhougq.redis.execption;

import cn.zhougq.redis.util.CodeInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhouganqing
 * @create 2020- 09- 16- 17:52
 */
public class ResultRuntimeException extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(ResultRuntimeException.class);

    private CodeInterface codeInterface;

    /**
     * 状态码
     */
    private String code;

    private Object data;

    public ResultRuntimeException() {
    }

    public ResultRuntimeException(String message) {
        super(message);
    }

    public ResultRuntimeException(Throwable throwable) {
        super(throwable);
    }

    public ResultRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ResultRuntimeException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ResultRuntimeException(CodeInterface codeInterface, Object data) {
        super(codeInterface.getMsg());
        this.codeInterface = codeInterface;
        this.code = codeInterface.getCode();
        this.data = data;
    }

    public ResultRuntimeException(CodeInterface codeInterface) {
        super(codeInterface.getMsg());
        this.codeInterface = codeInterface;
        this.code = codeInterface.getCode();
    }

    public ResultRuntimeException(CodeInterface codeInterface, String message) {
        super(codeInterface.getMsg() + "[" + message + "]");
        this.codeInterface = codeInterface;
        this.code = codeInterface.getCode();
    }

    public ResultRuntimeException(CodeInterface codeInterface, String message, Object data) {
        super(codeInterface.getMsg() + "[" + message + "]");
        this.codeInterface = codeInterface;
        this.code = codeInterface.getCode();
        this.data = data;
    }

    public ResultRuntimeException(CodeInterface codeInterface, Throwable cause) {
        super(codeInterface.getMsg(), cause);
        this.codeInterface = codeInterface;
        this.code = codeInterface.getCode();
        log.error(codeInterface.getMsg(), cause);
    }

    public ResultRuntimeException(CodeInterface codeInterface, String message, Throwable cause) {
        super(codeInterface.getMsg() + "[" + message + "]", cause);
        this.codeInterface = codeInterface;
        this.code = codeInterface.getCode();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public CodeInterface getCodeInterface() {
        return codeInterface;
    }

    public void setCodeInterface(CodeInterface codeInterface) {
        this.codeInterface = codeInterface;
    }

}