package com.api;

import com.api.kdiniao.electron.service.ElectronService;
import com.api.kdiniao.subscribe.service.KdnSubscrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KDNiaoTest {

    @Autowired
    private ElectronService electronService;
    @Autowired
    private KdnSubscrService kdnSubscrService;

    //  预约取件
    @Test
    public void test3() {
        kdnSubscrService.subGetOrder();
    }

    //   取消订单
    @Test
    public void test2() {
        electronService.cancelOrder();
    }

    //  电子面单
    @Test
    public void test1() {
        electronService.pushElectron();
    }

}
