package com.chao.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRespository girlRespository;

    /*事物回滚不起作用！*/
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setName("cccc");
        girlA.setAge(22);
        girlRespository.save(girlA);

        Girl girlB = new Girl();
        girlB.setName("ta");
        girlB.setAge(22);
        girlRespository.save(girlB);
    }
}
