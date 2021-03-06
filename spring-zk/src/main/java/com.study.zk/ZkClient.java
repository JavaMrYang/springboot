package com.study.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author :LiuYang
 * @desc
 * zkClient连接创建节点
 * @date :2021/2/8/008 14:51
 **/
public class ZkClient {
    private String connectString = ZkPutFileTest.connectStr;
    private int sessionTimeout = 10000;
    ZooKeeper zkCli = null;

    // 初始化客户端
    @Before
    public void init() throws IOException {
        zkCli = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            // 回调监听
            @Override
            public void process(WatchedEvent event) {
                // System.out.println(event.getPath() + "\t" + event.getState() + "\t" + event.getType());
                try {
                    List<String> children = zkCli.getChildren("/", true);
                    for (String c : children) {
                         System.out.println(c);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 创建子节点
    @Test
    public void createZnode() throws KeeperException, InterruptedException {
        String path = zkCli.create("/hello", "world".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }

    // 获取子节点
    @Test
    public void getChild() throws KeeperException, InterruptedException {
        List<String> children = zkCli.getChildren("/", true);
        for (String c : children) {
            System.out.println(c);
        }
        Thread.sleep(Long.MAX_VALUE);
    }

    // 删除节点
    @Test
    public void rmChildData() throws KeeperException, InterruptedException {
        // byte[] data = zkCli.getData("/bbq", true, null);
        // System.out.println(new String(data));
        zkCli.delete("/hello", -1);
    }

    // 修改数据
    @Test
    public void setData() throws KeeperException, InterruptedException {
        zkCli.setData("/hello", "17".getBytes(), -1);
    }

    // 判断节点是否存在
    @Test
    public void testExist() throws KeeperException, InterruptedException {
        Stat exists = zkCli.exists("/hello", false);
        System.out.println(exists == null ? "not exists" : "exists");
    }
}
