import cn.zhougq.entitys.SysUserAddress;
import cn.zhougq.service.IAddressService;
import cn.zhougq.service.impl.AddressServiceImpl;
import org.junit.Test;

/**
 * @author zhouganqing
 * @create 2020- 08- 10- 17:50
 */
public class twoHi {

    IAddressService service = new AddressServiceImpl();

    @Test
    public void HibTest2() {

        SysUserAddress address = new SysUserAddress();
        address.setProvince("深圳3");
        address.setCity("福田3");
        address.setRegion("开发区");
        address.setAddress("鱼花下新村");
        address.setAddressType(0);
        address.setStreet("高埔镇");
        service.saveAddress(address);
        System.out.println("===================ID:" +address.getId());
    }

    @Test
    public void SelectTest() {
        SysUserAddress address = service.selectByID(279717);
        System.out.println("===================ID:" +address.getAddress());
    }

    @Test
    public void UpdateTest() {
        SysUserAddress address = service.selectByID(279717);
        address.setAddress(address.getAddress()+"哈哈哈");
        service.mergeAddress(address);
        System.out.println("===================ID:" +address.getAddress());
    }

}
