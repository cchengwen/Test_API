package com.api.kdiniao.electron.pojo;

import java.util.List;

/**
 *   增值服务实体
 */
public class AddService {

   List<AddValues> AddService;

    public List<AddValues> getAddService() {
        return AddService;
    }

    public void setAddService(List<AddValues> addService) {
        AddService = addService;
    }

    @Override
    public String toString() {
        return "AddService{" +
                "AddService=" + AddService +
                '}';
    }
}
