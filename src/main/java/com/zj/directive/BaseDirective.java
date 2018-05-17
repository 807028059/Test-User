package com.zj.directive;

import com.alibaba.fastjson.JSON;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseDirective implements TemplateDirectiveModel{

    //获取参数值
    public <T> T getParameter(String paramName,Map params,Class<?> clazz)
            throws TemplateException{
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        //获取参数
        TemplateModel templateModel = (TemplateModel) params.get(paramName);
        T value = (T) beansWrapper.unwrap(templateModel, clazz);

        return value;
    }

    //输出
    public void setVariable(Environment env, TemplateDirectiveBody body,String key,Object value)
            throws TemplateException,IOException{
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        TemplateModel templateModel = beansWrapper.wrap(value);
        env.setVariable(key, templateModel);
        // 输出
        if (body != null) {
            body.render(env.getOut());
        } else {
            env.getOut().write(JSON.toJSONString(value));
        }
    }
}
