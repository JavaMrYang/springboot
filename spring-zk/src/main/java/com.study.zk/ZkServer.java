package com.study.zk;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/2/8/008 14:55
 **/
public class ZkServer {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        // 1.连接zkServer
        ZkServer zkServer = new ZkServer();
        zkServer.getConnect();

        // 2.注册节点信息 服务器ip添加到zk中
        zkServer.regist("args[0]");

        // 3.业务逻辑处理
        zkServer.build(args[0]);
    }

    private String connectString = ZkPutFileTest.connectStr;
    private int sessionTimeout = 10000;
    ZooKeeper zkCli = null;
    // 定义父节点
    private String parentNode = "/servers";

    // 1.连接zkServer
    public void getConnect() throws IOException {
        zkCli = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

            @Override
            public void process(WatchedEvent event) {

            }
        });
    }

    // 2.注册信息
    public void regist(String hostname) throws KeeperException, InterruptedException {
        String node = zkCli.create(parentNode + "/server", hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(node);
    }

    // 3.构造服务器
    public void build(String hostname) throws InterruptedException {
        System.out.println(hostname + ":服务器上线了！");
        Thread.sleep(Long.MAX_VALUE);
    }
}
