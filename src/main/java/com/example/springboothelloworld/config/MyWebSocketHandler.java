package com.example.springboothelloworld.config;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Component
public class MyWebSocketHandler implements WebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(MyWebSocketHandler.class);
    private static Map<Long, Set<WebSocketSession>> userSocketSessionMap = new ConcurrentHashMap<>();

    /**
     * 建立连接后
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        Long uid = (Long) session.getAttributes().get("uid");
        //访问方式127.0.0.1:8081/ws?uid=3
        String token = session.getUri().getQuery().substring(session.getUri().getQuery().indexOf("=") + 1);
        Long uid=Long.parseLong(token);
        // 如果是新 Session，记录进 Map
        boolean isNewUser = true;
        for (Object o : userSocketSessionMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Long key = (Long) entry.getKey();
            if (key.equals(uid)) {
                userSocketSessionMap.get(uid).add(session);
                isNewUser = false;
                break;
            }
        }
        if (isNewUser) {
            Set<WebSocketSession> sessions = new HashSet<>();
            sessions.add(session);
            userSocketSessionMap.put(uid, sessions);
        }
        logger.info("当前在线用户数: {}", userSocketSessionMap.values().size());
        sendMessageToUser( uid, new TextMessage("这是单独发送的消息") );
        broadcast(new TextMessage("发送给所有连接用户的消息"));

    }

    /**
     * 收到消息时触发的回调
     * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message.getPayloadLength() == 0) {
            System.out.println("收到客户端发来的消息：" + message.getPayload());
        }
    }

    /**
     * 消息传输错误处理
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        // 移除Socket会话
        for (Set<WebSocketSession> item : userSocketSessionMap.values()) {
            if (item.contains(session)) {
                // 删除连接 session
                item.remove(session);
                // 如果 userId 对应的 session 数为 0 ，删除该 userId 对应的记录
                if (0 == item.size()) {
                    userSocketSessionMap.values().remove(item);
                }
                break;
            }
        }
    }

    /**
     * 关闭连接后
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.info("Session {} disconnected. Because of {}", session.getId(), closeStatus);
        for (Set<WebSocketSession> item : userSocketSessionMap.values()) {
            if (item.contains(session)) {
                // 删除连接 session
                item.remove(session);
                // 如果 userId 对应的 session 数为 0 ，删除该 userId 对应的记录
                if (0 == item.size()) {
                    userSocketSessionMap.values().remove(item);
                }
                break;
            }
        }
        logger.info("当前在线用户数: {}", userSocketSessionMap.values().size());

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


    /**
     * 给所有在线用户发送消息
     *
     * @param message
     * @throws IOException
     */
    /**
     * 给所有在线用户发送消息
     *
     * @param message
     * @throws IOException
     */
    public void broadcast(final TextMessage message) throws IOException {
        // 多线程群发
        for(Set<WebSocketSession> item : userSocketSessionMap.values()) {
            for (final WebSocketSession session : item) {
                if (session.isOpen()) {
                    ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                            new BasicThreadFactory.Builder().namingPattern("socket-schedule-pool-%d").daemon(true).build());
                    for (int i = 0; i < 3; i++) {
                        executorService.execute(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if (session.isOpen()) {
                                        logger.debug("broadcast output:" + message.toString());
                                        session.sendMessage(message);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    /**
     * 给某个用户发送消息
     *
     * @param uid
     * @param message
     * @throws IOException
     */
    private void sendMessageToUser(Long uid, TextMessage message) throws IOException {
        for (Long id : userSocketSessionMap.keySet()) {
            if (id.equals(uid)) {
                for (WebSocketSession session : userSocketSessionMap.get(uid)) {
                    try {
                        logger.info("SendAll: {}", message);
                        session.sendMessage(message);
                    } catch (Exception e) {
                        logger.error(e.toString());
                    }
                }
            }
        }
    }

}
