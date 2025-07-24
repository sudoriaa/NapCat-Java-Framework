package cn.ricecandy.napcat.service.api;

import cn.ricecandy.napcat.dto.api.req.MessageApiReq;
import cn.ricecandy.napcat.dto.api.resp.FetchEmojiLikeApiResp;
import cn.ricecandy.napcat.dto.api.resp.GetImageApiResp;
import cn.ricecandy.napcat.dto.api.resp.GetRecordApiResp;
import cn.ricecandy.napcat.dto.event.message.GroupMessageEvent;
import cn.ricecandy.napcat.dto.event.message.PrivateMessageEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MessageApiService {
    // 发送群消息
    public Mono<String> sendGroupMsg(MessageApiReq messageApiReq);

//    public Mono<String> sendGroupMusicCard(MessageApiReq messageApiReq);

    // 发送群合并转发消息
    public Mono<Void> sendGroupForwardMsg(MessageApiReq messageApiReq);
    // 消息转发到群
    public Mono<Void> forwardGroupSingleMsg(MessageApiReq messageApiReq);
    // 发送群聊戳一戳
    public Mono<Void> groupPoke(MessageApiReq messageApiReq);

    // 发送私聊消息
    public Mono<String> sendPrivateMsg(MessageApiReq messageApiReq);
    // 发送私聊合并转发消息
    public Mono<Void> sendPrivateForwardMsg(MessageApiReq messageApiReq);
    // 消息转发到私聊
    public Mono<Void> forwardFriendSingleMsg(MessageApiReq messageApiReq);
    // 发送私聊戳一戳
    public Mono<Void> friendPoke(MessageApiReq messageApiReq);

//    // 发送戳一戳
//    public Mono<Void> sendPoke(MessageApiReq messageApiReq);
    // 撤回消息
    public Mono<Void> deleteMsg(MessageApiReq messageApiReq);
    // 获取群历史消息
    public Mono<List<GroupMessageEvent>> getGroupMsgHistory(MessageApiReq messageApiReq);
    // 获取消息详情
    public Mono<GroupMessageEvent> getMsg(MessageApiReq messageApiReq);
    // 获取合并转发消息
    public Mono<GroupMessageEvent> getForwardMsg(MessageApiReq messageApiReq);
    // 贴表情,返回表情个数
    public Mono<Integer> sendMsgEmojiLike(MessageApiReq messageApiReq);


    // 获取好友历史消息
    public Mono<List<PrivateMessageEvent>> getFriendMsgHistory(MessageApiReq messageApiReq);
    // 获取贴表情详情
    public Mono<FetchEmojiLikeApiResp> fetchEmojiLike(MessageApiReq messageApiReq);
    // 发送合并转发消息
    public Mono<Void> sendForWardMsg(MessageApiReq messageApiReq);
    // 获取语音消息详情
    public Mono<GetRecordApiResp> getRecord(MessageApiReq messageApiReq);
    // 获取图片消息详情
    public Mono<GetImageApiResp> getImage(MessageApiReq messageApiReq);
    // 发送群AI语音
    public Mono<String> sendGroupAiRecord(MessageApiReq messageApiReq);

}
