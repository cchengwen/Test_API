package com.api.software_install.service;

import com.api.software_install.OperateYml;
import com.api.software_install.SourceData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class SoftServiceImpl {

    @Transactional
    public void soft(SourceData sourceData) throws IOException {
        if (sourceData != null)
        OperateYml.addToYml(sourceData);
    }
}
