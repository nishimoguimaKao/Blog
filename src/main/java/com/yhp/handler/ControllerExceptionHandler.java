package com.yhp.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice//拦截所有注释有@Controller的方法
public class ControllerExceptionHandler {
    //获取日志对象
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)//表示该方法可以用来做异常处理的，能处理Exception级别的异常
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e ) throws Exception {

        logger.error("Request URL : {}, Exception : {}",request.getRequestURL(),e);

        if ((AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class))!=null){
            throw e;
        }

        ModelAndView mv=new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        mv.setViewName("error/error");//将这些错误界面返回到error包下的error界面
        return mv;
    }
}
