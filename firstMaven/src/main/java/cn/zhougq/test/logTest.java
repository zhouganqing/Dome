package cn.zhougq.test;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhouganqing
 * @create 2020- 06- 20- 19:43
 */

@Log4j2
public class logTest {

    //private static final Logger log = LoggerFactory.getLogger(logTest.class);
    public static void main(String[] args) {
        log.info("info");
        log.debug("debug");
        log.warn("warn");
        log.error("error");
        System.out.println("asdf");
    }
}
