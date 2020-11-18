package cn.zhougq.constants.enums;

/**
 * @author zhouganqing
 * @create 2020- 09- 14- 20:15
 */
public enum CharsetEnum {

    SPLIT_CHARSET(","),
    BAR_CHARSET("-"),
    EMPTY_CHARSET(""),
    UNDERLINE_CHARSET("_"),
    COMMA_CHARSET(","),
    SEMICOLON_CHARSET(";"),
    AT_CHARSET("@"),
            ;

    private final String charset;

    CharsetEnum(String charset) {
        this.charset = charset;
    }

    public String getCharset() {
        return charset;
    }

    @Override
    public String toString() {
        return charset;
    }
}
