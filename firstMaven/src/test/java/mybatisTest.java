import cn.zhougq.Utils.MybatisUtil;
import cn.zhougq.mapper.NewMapper;
import cn.zhougq.pojo.NewsMod;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 06- 21- 16:44
 */
public class mybatisTest {
    /*添加mybatis接口*/
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            /*读取xml文件，加载mybatis*/
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAll()
    {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)) {

            NewMapper mapper =sqlSession.getMapper(NewMapper.class);

            //List<NewsMod> list = mapper.selectListChoose(1);
            List<NewsMod> list = mapper.selectListPage(0,5);
            for (NewsMod newsMod : list) {
                System.out.println("newMod:"+newsMod.getId() + ":" + newsMod.getTitle());
                System.out.println("newInfo:"+newsMod.getInfo().getId() + ":" + newsMod.getInfo().getTitle());
            }

            /*Map<String,Object> map = new HashMap<>();
            List<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(3);
            ids.add(5);
            ids.add(7);
            map.put("ids",ids);
            //List<NewsMod> list =mapper.selectModeInList(ids);
            List<NewsMod> list =mapper.selectModeInMapList(map);
            for (NewsMod newsMod : list) {
                System.out.println("newMod:"+newsMod.getId() + ":" + newsMod.getTitle());
                System.out.println("newInfo:"+newsMod.getInfo().getId() + ":" + newsMod.getInfo().getTitle());
            }*/

            /*NewsMod mod = mapper.selectModeById(12);
            System.out.println("mod:"+mod.getTitle());

            List<NewsMod> list =mapper.selectAll();
            for (NewsMod newsMod : list) {
                System.out.println("newMod:"+newsMod.getId() + ":" + newsMod.getTitle());
                System.out.println("newInfo:"+newsMod.getInfo().getId() + ":" + newsMod.getInfo().getTitle());
            }*/
        }
    }


}
