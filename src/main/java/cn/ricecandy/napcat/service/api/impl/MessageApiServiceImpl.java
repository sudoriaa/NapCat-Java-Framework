package cn.ricecandy.napcat.service.api.impl;

import cn.ricecandy.napcat.dto.api.req.MessageApiReq;
import cn.ricecandy.napcat.dto.api.resp.*;
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
                        BaseNapcatResp<MessageResp> resp = JSON.parseObject(
                                jsonStr,
                                new TypeReference<BaseNapcatResp<MessageResp>>() {}
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
    public Mono<String> sendGroupForwardMsg(MessageApiReq messageApiReq) {
        return webClient.post()
                .uri("/send_group_forward_msg")
                .bodyValue(messageApiReq)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(
                        jsonStr -> {
                            try {
                                BaseNapcatResp<MessageResp> resp = JSON.parseObject(
                                        jsonStr,
                                        new TypeReference<BaseNapcatResp<MessageResp>>() {}
                                );
                                if (resp.getStatus().equals("failed")) {
                                    log.error("[↑发送群合并转发消息]发送失败:{}", resp.getMessage());
                                    return Mono.just("-1");
                                }
                                log.info("[↑发送群合并转发消息]群聊:{} -> {}", messageApiReq.getGroup_id(), messageApiReq.getMessage());
                                return Mono.just(resp.getData().getMessage_id());
                            } catch (Exception e) {
                                return Mono.error(new RuntimeException("JSON解析失败", e));
                            }
                        }
                );
    }

    @Override
    public Mono<Void> forwardGroupSingleMsg(MessageApiReq messageApiReq) {
        return webClient.post()  // 关键：添加 return
                .uri("消息转发到群")
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
                            log.error("[↑消息转发到群]发送失败:{}", resp.getMessage());
                            return Mono.just("-1");
                        }
                        log.info("[↑消息转发到群]群聊:{} -> {}", messageApiReq.getGroup_id(), messageApiReq.getMessage());
                        return Mono.empty();
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("JSON解析失败", e));
                    }
                }).then();
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
                        BaseNapcatResp<MessageResp> resp = JSON.parseObject(
                                jsonStr,
                                new TypeReference<BaseNapcatResp<MessageResp>>() {}
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
                            log.error("[撤回消息]撤回失败:{}", resp.getMessage());
                            return Mono.empty();
                        }
                        log.info("[撤回消息] -> {}", messageApiReq.getMessage_id());
                        return Mono.empty();
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("JSON解析失败", e));
                    }
                }).then();
    }

    @Override
    public Mono<List<MessageResp>> getGroupMsgHistory(MessageApiReq messageApiReq) {
        return webClient.post()
                .uri("/get_group_msg_history")
                .bodyValue(messageApiReq)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(jsonStr -> {
                    try {
                        BaseNapcatResp<JSONObject> resp = JSON.parseObject(
                                jsonStr,
                                new TypeReference<BaseNapcatResp<JSONObject>>() {}
                        );
                        if (resp.getStatus().equals("failed")) {
                            log.error("[获取群历史消息]获取失败:{}", resp.getMessage());
                            return Mono.empty();
                        }
                        log.info("[获取群历史消息] -> {}", resp.getData().getJSONArray("messages").toJSONString());
                        List<MessageResp> res = JSON.parseObject(
                                resp.getData().getJSONArray("messages").toString(),
                                new TypeReference<List<MessageResp>>(){}
                        );
                        return Mono.just(res);
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("JSON解析失败", e));
                    }
                });
    }

    @Override
    public Mono<MessageResp> getMsg(MessageApiReq messageApiReq) {
        return webClient.post()
                .uri("/get_msg")
                .bodyValue(messageApiReq)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(jsonStr -> {
                    try {
                        BaseNapcatResp<MessageResp> resp = JSON.parseObject(
                                jsonStr,
                                new TypeReference<BaseNapcatResp<MessageResp>>() {}
                        );
                        if (resp.getStatus().equals("failed")) {
                            log.error("[获取消息详情]获取失败:{}", resp.getMessage());
                            return Mono.empty();
                        }
                        log.info("[获取消息详情] -> {}",  JSONObject.toJSONString(resp.getData()));
                        return Mono.just(resp.getData());
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("JSON解析失败", e));
                    }
                });
    }


    @Override
    public Mono<List<MessageResp>> getForwardMsg(MessageApiReq messageApiReq) {
        return webClient.post()
                .uri("/get_forward_msg")
                .bodyValue(messageApiReq)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(jsonStr -> {
                    try {
                        BaseNapcatResp<JSONObject> resp = JSON.parseObject(
                                jsonStr,
                                new TypeReference<BaseNapcatResp<JSONObject>>() {}
                        );
                        if (resp.getStatus().equals("failed")) {
                            log.error("[获取合并转发消息]获取失败:{}", resp.getMessage());
                            return Mono.empty();
                        }
                        log.info("[获取合并转发消息] -> {}", resp.getData().getJSONArray("messages").toJSONString());


                        List<MessageResp> res = JSON.parseObject(
                                resp.getData().getJSONArray("messages").toString(),
                                new TypeReference<List<MessageResp>>(){}
                        );
                        return Mono.just(res);
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("JSON解析失败", e));
                    }
                });
    }

    @Override
    public Mono<SendMsgEmojiLikeResp> sendMsgEmojiLike(MessageApiReq messageApiReq) {
        return webClient.post()
                .uri("/send_msg_emoji_like")
                .bodyValue(messageApiReq)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(jsonStr -> {
                    try {
                        BaseNapcatResp<SendMsgEmojiLikeResp> resp = JSON.parseObject(
                                jsonStr,
                                new TypeReference<BaseNapcatResp<SendMsgEmojiLikeResp>>() {
                                }
                        );
                        if (resp.getStatus().equals("failed")) {
                            log.error("[贴表情]发送失败: {}", resp.getMessage());
                            return Mono.empty();
                        }
                        log.info("[贴表情] -> message_id:{}", messageApiReq.getMessage_id());
                        return Mono.just(resp.getData());
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("JSON解析失败", e));
                    }
                });
    }

@Override
public Mono<List<MessageResp>> getFriendMsgHistory(MessageApiReq messageApiReq) {
    return webClient.post()
            .uri("/get_friend_msg_history")
            .bodyValue(messageApiReq)
            .retrieve()
            .bodyToMono(String.class)
            .flatMap(jsonStr -> {
                try {
                    BaseNapcatResp<JSONObject> resp = JSON.parseObject(
                            jsonStr,
                            new TypeReference<BaseNapcatResp<JSONObject>>() {}
                    );
                    if (resp.getStatus().equals("failed")) {
                        log.error("[获取私聊历史消息]获取失败:{}", resp.getMessage());
                        return Mono.empty();
                    }
                    log.info("[获取私聊历史消息] -> {}", resp.getData().getJSONArray("messages").toJSONString());
                    List<MessageResp> res = JSON.parseObject(
                            resp.getData().getJSONArray("messages").toString(),
                            new TypeReference<List<MessageResp>>(){}
                    );
                    return Mono.just(res);
                } catch (Exception e) {
                    return Mono.error(new RuntimeException("JSON解析失败", e));
                }
            });
}

@Override
public Mono<FetchEmojiLikeResp> fetchEmojiLike(MessageApiReq messageApiReq) {
    return webClient.post()
            .uri("/fetch_emoji_like")
            .bodyValue(messageApiReq)
            .retrieve()
            .bodyToMono(String.class)
            .flatMap(
                    jsonStr -> {
                        try {
                            BaseNapcatResp<FetchEmojiLikeResp> resp = JSON.parseObject(
                                    jsonStr,
                                    new TypeReference<BaseNapcatResp<FetchEmojiLikeResp>>() {}
                            );
                            if (resp.getStatus().equals("failed")) {
                                log.error("[获取贴表情详情]获取失败:{}", resp.getMessage());
                                return Mono.empty();
                            }
                            log.info("[获取贴表情详情] -> {}", JSONObject.toJSONString(resp.getData()));
                            return Mono.just(resp.getData());
                        } catch (Exception e) {
                            return Mono.error(new RuntimeException("JSON解析失败", e));
                        }
                    }
            );
}

@Override
public Mono<Void> sendForWardMsg(MessageApiReq messageApiReq) {
    return null;
}

@Override
public Mono<GetRecordResp> getRecord(MessageApiReq messageApiReq) {
    return webClient.post()
            .uri("/get_record")
            .bodyValue(messageApiReq)
            .retrieve()
            .bodyToMono(String.class)
            .flatMap(
                    jsonStr -> {
                        try {
                            BaseNapcatResp<GetRecordResp> resp = JSON.parseObject(
                                    jsonStr,
                                    new TypeReference<BaseNapcatResp<GetRecordResp>>() {}
                            );
                            if (resp.getStatus().equals("failed")) {
                                log.error("[获取语音消息详情]获取失败:{}", resp.getMessage());
                                return Mono.empty();
                            }
                            log.info("[获取语音消息详情] -> {}", JSONObject.toJSONString(resp.getData()));
                            return Mono.just(resp.getData());
                        } catch (Exception e) {
                            return Mono.error(new RuntimeException("JSON解析失败", e));
                        }
                    }
            );
}

@Override
public Mono<GetImageResp> getImage(MessageApiReq messageApiReq) {
    return webClient.post()
            .uri("/get_image")
            .bodyValue(messageApiReq)
            .retrieve()
            .bodyToMono(String.class)
            .flatMap(
                    jsonStr -> {
                        try {
                            BaseNapcatResp<GetImageResp> resp = JSON.parseObject(
                                    jsonStr,
                                    new TypeReference<BaseNapcatResp<GetImageResp>>() {}
                            );
                            if (resp.getStatus().equals("failed")) {
                                log.error("[获取图片消息详情]获取失败:{}", resp.getMessage());
                                return Mono.empty();
                            }
                            log.info("[获取图片消息详情] -> {}", JSONObject.toJSONString(resp.getData()));
                            return Mono.just(resp.getData());
                        } catch (Exception e) {
                            return Mono.error(new RuntimeException("JSON解析失败", e));
                        }
                    }
            );
}

@Override
public Mono<String> sendGroupAiRecord(MessageApiReq messageApiReq) {
    return webClient.post()  // 关键：添加 return
            .uri("/send_group_ai_record")
            .bodyValue(messageApiReq)
            .retrieve()
            .bodyToMono(String.class)
            .flatMap(jsonStr -> {
                try {
                    BaseNapcatResp<MessageResp> resp = JSON.parseObject(
                            jsonStr,
                            new TypeReference<BaseNapcatResp<MessageResp>>() {}
                    );
                    if (resp.getStatus().equals("failed")) {
                        log.error("[↑发送群AI语音]发送失败:{}", resp.getMessage());
                        return Mono.just("-1");
                    }
                    log.info("[↑发送群AI语音]群聊:{} ->({}) {}", messageApiReq.getGroup_id(), messageApiReq.getCharacter(), messageApiReq.getText());
                    return Mono.just(resp.getData().getMessage_id());
                } catch (Exception e) {
                    return Mono.error(new RuntimeException("JSON解析失败", e));
                }
            });
}
}
