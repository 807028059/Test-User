package com.zj.test;

import com.alibaba.fastjson.JSON;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import java.util.HashMap;
import java.util.Map;

public class Test_4 {
    public static void main(String[] args) {
        String url = "http://gw.api.taobao.com/router/rest";
        String appkey = "23560540";
        String secret = "cb6ebff7fcdc193349497f578905b9b4";
        try {
            TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
            AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
            req.setSmsType("normal");
            req.setSmsFreeSignName("尚HAI购网");
            Map<String, String> map = new HashMap<>();
            map.put("randomNum", "你生儿子没屁眼");
            req.setSmsParam(JSON.toJSONString(map));
            req.setRecNum("13361836960");
            req.setSmsTemplateCode("SMS_33490385");
            AlibabaAliqinFcSmsNumSendResponse response = client.execute(req);
            if (response.isSuccess()) {
                System.out.println("成功");
            } else {
                System.out.println(response.getSubMsg());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
