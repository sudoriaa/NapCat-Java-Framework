package cn.ricecandy.napcat.service.api.impl;

import cn.ricecandy.napcat.dto.api.req.MessageApiReq;
import cn.ricecandy.napcat.dto.api.resp.BaseNapcatResp;
import cn.ricecandy.napcat.dto.api.resp.FetchEmojiLikeApiResp;
import cn.ricecandy.napcat.dto.api.resp.GetImageApiResp;
import cn.ricecandy.napcat.dto.api.resp.GetRecordApiResp;
import cn.ricecandy.napcat.dto.event.message.GroupMessageEvent;
import cn.ricecandy.napcat.dto.event.message.MessageEvent;
import cn.ricecandy.napcat.dto.event.message.PrivateMessageEvent;
import cn.ricecandy.napcat.service.api.MessageApiService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class MessageApiServiceImpl implements MessageApiService {
    @Resource
    private WebClient webClient;



    @Override
    public Mono<String> sendGroupMsg(MessageApiReq messageApiReq) {
        return webClient.post()  // 关键：添加 return
                .uri("/send_group_msg")
                .bodyValue(messageApiReq)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(jsonStr -> {
                    try {
                        BaseNapcatResp<GroupMessageEvent> resp = JSON.parseObject(
                                jsonStr,
                                new TypeReference<BaseNapcatResp<GroupMessageEvent>>() {}
                        );
                        if (resp.getStatus().equals("failed")) {
                            log.error("[↑发送群消息]发送失败:{}", resp.getMessage());
                            return Mono.just("-1");
                        }
                        log.info("[↑发送群消息]群聊:{} -> {}", messageApiReq.getGroup_id(), messageApiReq.getMessage());
                        return Mono.just(resp.getData().getMessage_id());
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("JSON解析失败", e));
                    }
                });
    }

//    @Override
//    public Mono<String> sendGroupMusicCard(MessageApiReq messageApiReq) {
//        return null;
//    }

    @Override
    public Mono<Void> sendGroupForwardMsg(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<Void> forwardGroupSingleMsg(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<Void> groupPoke(MessageApiReq messageApiReq) {
        return webClient.post()  // 关键：添加 return
                .uri("/group_poke")
                .bodyValue(messageApiReq)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(jsonStr -> {
                    try {
                        BaseNapcatResp<Void> resp = JSON.parseObject(
                                jsonStr,
                                new TypeReference<BaseNapcatResp<Void>>() {}
                        );
                        if (resp.getStatus().equals("failed")) {
                            log.error("[↑发送群聊戳一戳]发送失败:{}", resp.getMessage());
                            return Mono.just("-1");
                        }
                        log.info("[↑发送群聊戳一戳]群聊:{} -> {}", messageApiReq.getGroup_id(), messageApiReq.getUser_id());
                        return Mono.just("0");
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("JSON解析失败", e));
                    }
                }).then();
    }

    @Override
    public Mono<String> sendPrivateMsg(MessageApiReq messageApiReq) {
        return webClient.post()  // 关键：添加 return
                .uri("/send_private_msg")
                .bodyValue(messageApiReq)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(jsonStr -> {
                    try {
                        BaseNapcatResp<PrivateMessageEvent> resp = JSON.parseObject(
                                jsonStr,
                                new TypeReference<BaseNapcatResp<PrivateMessageEvent>>() {}
                        );
                        if (resp.getStatus().equals("failed")) {
                            log.error("[↑发送私聊消息]发送失败:{}", resp.getMessage());
                            return Mono.just("-1");
                        }
                        log.info("[↑发送私聊消息]私聊对象:{} -> {}", messageApiReq.getUser_id(), messageApiReq.getMessage());
                        return Mono.just(resp.getData().getMessage_id());
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("JSON解析失败", e));
                    }
                });
    }

    @Override
    public Mono<Void> sendPrivateForwardMsg(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<Void> forwardFriendSingleMsg(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<Void> friendPoke(MessageApiReq messageApiReq) {
        return webClient.post()  // 关键：添加 return
                .uri("/friend_poke")
                .bodyValue(messageApiReq)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(jsonStr -> {
                    try {
                        BaseNapcatResp<Void> resp = JSON.parseObject(
                                jsonStr,
                                new TypeReference<BaseNapcatResp<Void>>() {}
                        );
                        if (resp.getStatus().equals("failed")) {
                            log.error("[↑发送私聊戳一戳]发送失败:{}", resp.getMessage());
                            return Mono.just("-1");
                        }
                        log.info("[↑发送私聊戳一戳] -> {}", messageApiReq.getUser_id());
                        return Mono.just("0");
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("JSON解析失败", e));
                    }
                }).then();
    }


    @Override
    public Mono<Void> deleteMsg(MessageApiReq messageApiReq) {
        return webClient.post()  // 关键：添加 return
                .uri("/delete_msg")
                .bodyValue(messageApiReq)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(jsonStr -> {
                    try {
                        BaseNapcatResp<Void> resp = JSON.parseObject(
                                jsonStr,
                                new TypeReference<BaseNapcatResp<Void>>() {}
                        );
                        if (resp.getStatus().equals("failed")) {
                            log.error("[↑撤回消息]撤回失败:{}", resp.getMessage());
                            return Mono.empty();
                        }
                        log.info("[↑撤回消息] -> {}", messageApiReq.getMessage_id());
                        return Mono.empty();
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("JSON解析失败", e));
                    }
                }).then();
    }

    @Override
    public Mono<List<GroupMessageEvent>> getGroupMsgHistory(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<GroupMessageEvent> getMsg(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<GroupMessageEvent> getForwardMsg(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<Integer> sendMsgEmojiLike(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<List<PrivateMessageEvent>> getFriendMsgHistory(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<FetchEmojiLikeApiResp> fetchEmojiLike(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<Void> sendForWardMsg(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<GetRecordApiResp> getRecord(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<GetImageApiResp> getImage(MessageApiReq messageApiReq) {
        return null;
    }

    @Override
    public Mono<String> sendGroupAiRecord(MessageApiReq messageApiReq) {
        return null;
    }
}
