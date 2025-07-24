package cn.ricecandy.napcat.utils;

import cn.ricecandy.napcat.enums.ContactType;

import java.util.HashMap;
import java.util.Map;

public class CQUtil {
    private static String buildCQCode(String type, Map<String, String> params) {
        StringBuilder sb = new StringBuilder("[CQ:")
                .append(type);

        params.forEach((k, v) -> sb.append(",").append(k).append("=").append(escape(v)));

        return sb.append("]").toString();
    }

    private static String escape(String value) {
        return value.replace("&", "&amp;")
                .replace("[", "&#91;")
                .replace("]", "&#93;")
                .replace(",", "&#44;");
    }

    public static String face(String id){
        return "[CQ:face,id=" + id + "]";
    }

    public static String record(String file){
        return "[CQ:record,file=" + file + "]";
    }

    public static String video(String file){
        return "[CQ:video,file=" + file + "]";
    }

    public static String at(String userId) {
        return "[CQ:at,qq=" + userId + "]";
    }

    public static String rps(){
        return "[CQ:rps]";
    }

    public static String dice(){
        return "[CQ:dice]";
    }

    public static String shake(){
        return "[CQ:shake]";
    }

    public static String share(String url, String title){
        return "[CQ:share,url=" + url + ",title=" + title + "]";
    }

    public static String contact(ContactType type, String target_id){
        return "[CQ:contact,type=" + type + ",id=" + target_id + "]";
    }

    public static String music(String type, String id){
        return "[CQ:music,type=" + type + ",id=" + id + "]";
    }

    public static String music(String type, String url, String audio, String title, String content, String image){
        Map<String, String> params = new HashMap<String, String>();
        params.put("url", url); // 跳转url
        params.put("audio", audio); // 音乐文件url
        params.put("title", title); // 标题
        params.put("content", content); // 提示内容
        params.put("image", image); // 图像
        return buildCQCode(type, params);
    }

    public static String image(String file){
        return "[CQ:image,file=" + file + ",type=0]";
    }

    public static String reply(String message_id){
        return "[CQ:reply,id=" + message_id + "]";
    }

    public static String poke(String user_id){
        return "[CQ:poke,qq=" + user_id + "]";
    }

    public static String xml(String data){
        return "[CQ:xml,data=" + escape( data) + "]";
    }

/*
    public static String json(String data){
        return "[CQ:json,data=" + escape( data) + "]";
    }
 */


}
