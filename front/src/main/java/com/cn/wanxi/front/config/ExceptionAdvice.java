package com.cn.wanxi.front.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * @program: tenmallfront
 * @description:异常捕获
 * @author: niyao
 * @create: 2019-11-27 14:42
 */
@ControllerAdvice
@RestController
public class ExceptionAdvice {
    /**
     * 拦截捕捉自定义异常 ConstraintViolationException.class
     * @param ex
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Map ConstraintViolationExceptionHandler(ConstraintViolationException ex) {
        Map map = new HashMap();

        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        //存放异常消息
        List<String> msgList = new ArrayList<>();
        //
        while (iterator.hasNext()) {
            ConstraintViolation<?> cvl = iterator.next();
            msgList.add(cvl.getMessageTemplate());
        }
        map.put("msg",msgList);
        return map;
    }
    @ExceptionHandler(value = NullPointerException.class)
    public Map numberExceptionHandler(){
        Map map = new HashMap();
        map.put("msg","参数不能为空");
        return map;
    }
    @ExceptionHandler(value = NumberFormatException.class)
    public Map NumberFormatExceptionHandler(){
        Map map = new HashMap();
        map.put("msg","请输入正确类型参数");
        return map;
    }
}