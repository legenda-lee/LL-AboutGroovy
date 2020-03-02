import com.alibaba.fastjson.JSONObject

sayHello(name) {
    "我是字段值"
}

sayHello(name)


getIpCity(result) {
    String city = null;
    JSONObject jo = JSONObject.parseObject(result);
    if ("0".equals(jo.getString("code"))) {
        JSONObject data = jo.getJSONObject("data");
        city = data.getString("city");
    }
    return city;
}

