package com.chao.girl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*获取前缀是girl的配置*/
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String cpuSize;
    private Integer age;

    public String getCpuSize() {
        return cpuSize;
    }

    public void setCpuSize(String cpuSize) {
        this.cpuSize = cpuSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
