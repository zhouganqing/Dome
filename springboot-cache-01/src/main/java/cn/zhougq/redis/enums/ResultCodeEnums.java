package cn.zhougq.redis.enums;

import cn.zhougq.redis.util.CodeInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhouganqing
 * @create 2020- 09- 16- 17:57
 */

@Getter
@AllArgsConstructor
public enum ResultCodeEnums implements CodeInterface {

    SUCCESS("1000", "成功"),
    FAIL("080202", "失败"),
    PARAM_ERROR("080203", "参数错误"),
    SIGN_ERROR("080204", "参数签名错误"),
    ORDER_NOT_EXIST("080205", "订单不存在"),
    UPLOAD_IMAGE_ERROR("080206", "上传图片异常"),
    SIGN_IS_EMPTY("080207", "签名字段不存在"),
    APPID_ILLEGAL("080208", "appid不合法"),
    REMOTE_SERVICE_ERROR("080209", "调用远程服务异常"),
    PROXY_NOT_EXIST("080210", "资金方不存在"),
    ENTRY_FAIL("080211", "风控进件异常"),
    WCKD_FLOW_END("080212", "挖财快贷流程结束请勿重复进件"),
    PPM_BLACKLIST_FAIL("080213","获取PPM黑名单信息异常"),
    PPM_OPENACCOUNT_CHECK_ERROR("080214","PPM检查是否需要开户异常"),
    PPM_OPENACCOUNT_ERROR("080215","PPM开户异常"),
    PPM_OPENACCOUNT_CONFIRM_ERROR("080216","PPM开户回调异常"),
    PPM_DECRYPT_EXCEPTION("080217","PPM解析签名异常"),
    TBJ_OPENACCOUNT_EXCEPTION("080218","铜板街开户过程异常"),
    PPM_CONTRACTNO_MISS("080219","PPM开户异常"),
    PPM_STATUS_QUERY_EXCEPTTION("080220","ppm查询开户结果异常"),
    FILE_URL_ERROR("080221", "文件链接错误"),
    NOT_FIND_ENTRY_RECORD("080222", "未查询到进件记录"),
    NOT_FIND_CREDIT_EXTRA_INFO("080223", "未查询到合同文件信息"),
    FAIL_DOWNLOAD_PDF("080224", "合同PDF文件下载失败"),
    FAIL_COMPRESS_TAR_PACKAGE("080225", "文件压缩成tar包失败"),
    FAIL_UPLOAD_FILE_BY_SFTP("080226", "sftp上传文件失败"),
    FAIL_PUSH_CREDIT_INFO("080227", "调用合同信息推送接口失败"),
    UNSUPPORT_CREDIT_TYPE("080228", "该类型合同暂不支持"),
    DUPLICATE_ENTRY_ERROR("080229", "处理中，请勿重复进件"),
    NOT_FIND_CREDIT_ENTRY_INFO("080230", "未查询到合同进件信息"),
    FAIL_DOWNLOAN_FILE_FROM_FASTDFS("080231", "从fastdfs下载文件失败"),
    PPM_ENTERPRISE_OPEN_QUERY_EXCEPTION("080232", "ppm查询商户开户结果异常"),
    PPM_ENTERPRISE_OPEN_EXCEPTION("080233", "ppm商户开户异常"),
    PPM_REQUEST_EXECPTION("080234", "调用PPM请求发生异常"),
    PPM_ENTERPRISE_FILE_UPLOAD_EXCEPTION("080237", "ppm商户开户资料上传异常"),
    ENTERPRISE_OPEN_CONFIRM_EXCEPTION("080235", "商户开户回调接收异常"),
    PPM_ENTERPRISE_OPEN_CONFIRM_EXCEPTION("080236", "ppm商户开户回调接收异常"),
    CHANNEL_NOT_EXIST("080238", "渠道不存在"),
    WITHDRAW_EXCEPTION("080238", "提款异常"),
    FAIL_UPLOAD_FILE_FROM_FASTDFS("080239", "fastdfs上传文件失败"),

    //enterprise open account code enum
    OPEN_APPLY_TO_UPLOAD("080240", "开户申请已受理，请上传开户资料"),
    OPEN_DATA_IN_AUDIT_TO_WAIT("080241", "开户资料审核中，请耐心等待"),
    OPEN_DATA_BACK_TO_REUPLOAD("080242", "请重新上传开户资料"),
    OPEN_ALREADY_SUCCESS("080243", "已开户成功"),
    OPEN_STATUS_UNRIGHT_TO_UPLOAD("080244", "开户状态异常，无法上传开户资料"),
    NOT_FIND_OPEN_RECORD("080245", "未查询到开户申请记录"),
    YUNDAI_HAS_SIGNED("080241", "已签约，无需再签约"),
    CHECK_REJECT("080242", "审核拒绝"),
    CACHE_ERROR("080243", "缓存异常"),
    ACCESS_TOKEN_FAIL("080250", "获取token失败"),
    ENCRYPT_DECRYPT_EXCEPTION("080251", "加解密异常"),
    REQUEST_FUND_FAIL("080252", "请求资方异常"),
    FILE_TYPE_ERROR("080253","文件类型错误"),
    PAY_SERIAL_NUMBER_NOT_EXIST("080261", "支付流水号不存在"),
    NO_WITHDRAW_RECORD("080262", "未查询到提现记录"),
    NO_WITHDRAW_STATUS_QUERY("080263", "未查询到扣款信息"),
    NOT_FIND_SERIAL_NO_INFO("080264", "未查询到流水号对应记录"),
    PROXY_AUDIT_EXCEPTION("080265", "资方审批异常"),
    SERIAL_NO_REPEAT("080266", "流水号重复"),
    FILE_READ_ERROR("080264", "文件读取错误"),
            ;

    private String code;
    private String msg;
}
