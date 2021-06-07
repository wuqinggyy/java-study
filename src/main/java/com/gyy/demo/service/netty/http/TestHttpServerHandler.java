package com.gyy.demo.service.netty.http;

import java.net.URI;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {

        if (httpObject instanceof HttpRequest) {
            System.out.println("pipeline hash" + channelHandlerContext.pipeline().hashCode() + "HttpServerCodec hash" + this.hashCode());
            System.out.println("httpObject 类型" + httpObject.getClass());
            System.out.println("客户端地址" + channelHandlerContext.channel().remoteAddress());

            HttpRequest httpRequest = (HttpRequest) httpObject;
            URI uri = new URI(httpRequest.uri());
            if ("/favicon.ico".equals(httpRequest.uri())) {
                System.out.println("请求了什么，不做响应");
                return;
            }

            ByteBuf buf = Unpooled.copiedBuffer("hello,我是服务器", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, buf);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, buf.readableBytes());

            channelHandlerContext.writeAndFlush(response);

        }
    }
}
