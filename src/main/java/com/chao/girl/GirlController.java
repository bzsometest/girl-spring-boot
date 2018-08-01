package com.chao.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRespository girlRespository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRespository.findAll();
    }

    /**
     * 添加一个女生
     *
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setName(name);
        girl.setAge(age);
        return girlRespository.save(girl);
    }

    /**
     * 查询一个女生
     *
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    @ResponseBody
    public Girl getOne(@PathVariable("id") Integer id) {

        Girl girl = girlRespository.getOne(id);
        System.out.println(girl.toString());
        return girl;
    }

    /**
     * 更新
     *
     * @return
     */
    @PutMapping(value = "/girls")
    public Girl updateOne(Girl girl) {
        return girlRespository.save(girl);
    }

    /**
     * 删除
     *
     * @return
     */
    @DeleteMapping(value = "/girls{id}")
    public String deleteOne(Integer id) {
        girlRespository.delete(id);
        return "delete success";
    }

    /**
     * 通过年龄查询
     *
     * @return
     */
    @GetMapping(value = "/girls/age")
    @ResponseBody
    public List<Girl> findByAge(Integer age) {
        return girlRespository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }
}

