package demo.yanming.springboot.netty;


import java.net.InetSocketAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import demo.yanming.springboot.netty.web.socket.server.NettyServer;
import io.netty.channel.ChannelFuture;

@SpringBootApplication
//不使用数据库
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class NettyApplication implements CommandLineRunner {

    @Value("${n.port}")
    private int port;

    @Value("${n.url}")
    private String url;

    @Autowired
    private NettyServer socketServer;

    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        InetSocketAddress address = new InetSocketAddress(url, port);
        ChannelFuture future = socketServer.run(address);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                socketServer.destroy();
            }
        });
        future.channel().closeFuture().syncUninterruptibly();
    }
}
