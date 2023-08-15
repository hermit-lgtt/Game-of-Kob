package com.example.backend.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.backend.consumer.utils.Game;
import com.example.backend.consumer.utils.JwtAuthentication;
import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
<<<<<<< HEAD
@ServerEndpoint("/websocket/{token}")  // 注意不要以'/'结尾
public class WebSocketServer {
    final private static ConcurrentHashMap<Integer,WebSocketServer> users = new ConcurrentHashMap<>();
    final private static CopyOnWriteArraySet<User> matchpool = new CopyOnWriteArraySet<>();
    private User user;
    private Session session = null;
    private static UserMapper userMapper;


    @Autowired
    public void setUserMapper(UserMapper userMapper){
        WebSocketServer.userMapper = userMapper;
    }
    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) throws IOException {//建立连接
=======
@ServerEndpoint("/websocket/{token}")  //这里是映射到哪个链接, 注意不要以'/'结尾
public class WebSocketServer {
   final private static ConcurrentHashMap<Integer,WebSocketServer> users = new ConcurrentHashMap<>();
    //加static是为了对所有实例都可见,相当于全局变量,不加static,相当于局部变量
    //线程安全的set
    final private static CopyOnWriteArraySet<User> matchpool = new CopyOnWriteArraySet<>();
    private User user;
    private Session session = null;

    //注入WebSocket,不像之前的那些组件,很多组件都是单例模式，直接一个注解就可以了
    private static UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper){
        WebSocketServer.userMapper = userMapper;//静态变量访问用类名来访问

    }

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) throws IOException {
        // 建立连接
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
        this.session = session;
        System.out.println("connected");
        Integer userId = JwtAuthentication.getUserId(token);
        this.user = userMapper.selectById(userId);

<<<<<<< HEAD
        if(this.user !=null){
            users.put(userId,this);
        }else{
            this.session.close();
        }
=======
        if(this.user != null){
            users.put(userId,this);
        }else {
            this.session.close();
        }

>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
        System.out.println(users);
    }

    @OnClose
    public void onClose() {
        // 关闭链接
        System.out.println("disconnected");
<<<<<<< HEAD
        if(this.user != null){
=======
        if(this.user!=null){
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
            users.remove(this.user.getId());
            matchpool.remove(this.user);
        }
    }
<<<<<<< HEAD
=======

>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
    private void startMatching(){
        System.out.println("start matching");
        matchpool.add(this.user);

<<<<<<< HEAD
        while(matchpool.size()>=2){
=======
        while (matchpool.size() >= 2) {
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
            Iterator<User> it = matchpool.iterator();
            User a = it.next(), b = it.next();
            matchpool.remove(a);
            matchpool.remove(b);

<<<<<<< HEAD
            Game game =new Game(13,14,20);
            game.createMap();


            JSONObject respA = new JSONObject();
            respA.put("event","start-matching");
            respA.put("opponent_username",b.getUsername());
            respA.put("opponent_photo",b.getPhoto());
            respA.put("gamemap",game.getG());
            users.get(a.getId()).sendMessage(respA.toJSONString());

            JSONObject respB = new JSONObject();
            respB.put("event","start-matching");
            respB.put("opponent_username",a.getUsername());
            respB.put("opponent_photo",a.getPhoto());
            respB.put("gamemap",game.getG());
            users.get(b.getId()).sendMessage(respB.toJSONString());


        }
    }
=======
            Game game = new Game(13, 14, 20);
            game.createMap();

            JSONObject respA = new JSONObject();
            respA.put("event", "start-matching");
            respA.put("opponent_username", b.getUsername());
            respA.put("opponent_photo", b.getPhoto());
            respA.put("gamemap", game.getG());
            users.get(a.getId()).sendMessage(respA.toJSONString());

            JSONObject respB = new JSONObject();
            respB.put("event", "start-matching");
            respB.put("opponent_username", a.getUsername());
            respB.put("opponent_photo", a.getPhoto());
            respB.put("gamemap", game.getG());
            users.get(b.getId()).sendMessage(respB.toJSONString());
        }


    }

>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
    private void stopMatching(){
        System.out.println("stop matching");
        matchpool.remove(this.user);
    }

<<<<<<< HEAD
    @OnMessage
    public void onMessage(String message, Session session) {//当作路由
=======

    @OnMessage
    public void onMessage(String message, Session session) {//把message当作一个路由,做一个判断,要把这个任务交给谁
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
        // 从Client接收消息
        System.out.println("receive message");
        JSONObject data = JSON.parseObject(message);
        String event = data.getString("event");
        if("start-matching".equals(event)){
            startMatching();
        }else if("stop-matching".equals(event)){
            stopMatching();
        }
<<<<<<< HEAD

=======
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public void sendMessage(String message){
        synchronized (this.session){
            try{
                this.session.getBasicRemote().sendText(message);
<<<<<<< HEAD
            }catch (IOException e){
                e.printStackTrace();
            }
        }


=======
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
    }

}

