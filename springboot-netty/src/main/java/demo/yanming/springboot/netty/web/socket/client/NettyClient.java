package demo.yanming.springboot.netty.web.socket.client;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

import java.net.InetSocketAddress;

/**
 * <b>标题:    </b><br />
 * <pre>
 * </pre>
 *
 * @author 毛宇鹏
 * @date 创建于 上午10:56 2018/4/25
 */
public class NettyClient {

    private static final Logger log = Logger.getLogger(NettyClient.class);

    private static Bootstrap b;
    private static ChannelFuture f;
    private static final EventLoopGroup workerGroup = new NioEventLoopGroup();

    private static void init () {
        try {
            log.info("init...");
            b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) {
                    // 解码编码
                    socketChannel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
                    socketChannel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));

                    socketChannel.pipeline().addLast(new ClientHandler());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object startAndWrite(InetSocketAddress address, Object send) throws InterruptedException {
        init();
        f = b.connect(address).sync();
        // 传数据给服务端
        f.channel().writeAndFlush(send);
        f.channel().closeFuture().sync();
        return f.channel().attr(AttributeKey.valueOf("Attribute_key")).get();
    }

    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 7000);
        String message = "hello";
        try {
            Object result = NettyClient.startAndWrite(address, message);
            log.info("....result:" + result);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            f.channel().close();
            workerGroup.shutdownGracefully();
            log.info("Closed client!");
        }
    }
}
