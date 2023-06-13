package com.hugh.spring.service.impl;

import com.google.common.collect.Lists;
import com.hugh.spring.common.ResultCode;
import com.hugh.spring.exception.HughException;
import com.hugh.spring.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TestServiceImpl implements TestService {
    @Override
    public List<String> lis() {
        log.warn("TestServiceImpl -> list ");
        try {
            List<String> item = Lists.newArrayList();
            item.add("A");
            item.add("B");
            item.add("C");
            throw new HughException(ResultCode.INSERT_FAILURE);
//
//            return item;
        }catch (HughException e){
            throw e;
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new HughException(ResultCode.JINGQING_EXCEPTION);
    }
}
