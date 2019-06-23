## SpringBoot集成FastDFS+Nginx整合基于Token的防盗链
为什么要用SpringBoot?
SpringBoot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者。

创建独立的Spring应用程序

嵌入的Tomcat，无需部署WAR文件

简化Maven配置

自动配置Spring

提供生产就绪型功能，如指标，健康检查和外部配置

绝对没有代码生成并且对XML也没有配置要求
为什么要用Nginx?
概述

Nginx（engine x）是一个开源的，支持高并发的www服务和代理服务软件。Nginx是俄罗斯人Igor Sysoev开发的，最初被应用到俄罗斯的大型网站（www.rambler.ru）上。后来作者将源代码以类BSD许可证的形式开源出来供全球使用。在功能应用方面，Nginx不仅是一个优秀的Web服务软件，还具有反向代理负载均衡和缓存的功能。在反向代理负载均衡方面类似于LVS负载均衡及HAProxy等你专业代理软件。Nginx部署起来更加方便简单，在缓存服务功能方面，有类似于Squid等专业的缓存服务软件。Nginx可以运行在UNIX、Linux、MS Windows Server、Mac OS X Server、Solaris等操作系统中。

Nginx的重要特性

可以针对静态资源高速节点并发访问及缓存。
可以使用反向代理加速，并且可以进行数据缓存。
具有简单负载均衡，节点健康检查和容错功能。
支持远程Fast CGI服务的缓存加速。
支持Fast CGI、Uwsgi、SCGI、Memcached Server的加速和缓存。
支持SSL、TLS、SNI。
具有模块化的架构。
过滤器包括gzip压缩、ranges支持、chunked响应、XSLT、SSL和图像缩放等功能。
在SSL过滤器中，包含多个SSL页面，如果经由Fast CGI或反向代理处理，可以并行处理。
Nginx所具备的WWW服务特性

支持基于域名、端口和IP的虚拟主机配置。
支持KeepAlived和piplined连接。
可进行简单、方便、灵活的配置和管理。
支持修改Nginx配置，并且在代码上线时，可平滑重启，不中断业务访问。
可自定义访问日志格式，临时缓冲写日志操作，快速日志轮询及通过rsyslog处理日志。
可利用信号控制Nginx进程。
支持3xx-5xxHTTP状态码重定向。
支持rewrite模块，支持URI重写及正则表达式匹配。
支持基于客户端IP地址和HTTP基本认证的访问控制。
支持PUT、DELETE、MKCOL、COPY、MOVE等特殊的HTTP请求方法。
支持FLV流和MP4流技术产品应用。
支持HTTP响应速率限制。
支持同一IP地址的并发连接或请求限制。
支持邮件服务代理。
支持高并发，可以支持几百万并发连接。
资源消耗少，在3万并发连接下，可以开启10个nginx的线程消耗的内存不到200MB。
可以做HTTP反向代理及加速缓存，及负载均衡功能，内置对RS节点服务器健康检查功能，折现但能够与专业的HAProxy或LVS的功能。
具备Squid等专业缓存软件等的缓存功能。
支持异步网络I/O事件模型epoll（Linux2.6+）。
Nginx软件主要企业应用

作为Web服务软件。
使用Nginx运行HTML、JS、CSS、小图片等静态数据（类似于Lighttpd）。
结合Fast CGI运行PHP等动态程序（例如使用fastcgi_pass方式）。
Nginx结合Tomcat/Resin等支持Java动态程序（常用proxy_pass）。
反向代理或负载均衡服务（Nginx从1.9.0开始就开始支持TCP的代理了）。
前端业务数据缓存服务。
Web服务应用产品性能对比

静态数据的访问上：处理小文件（小于1MB）时，Nginx和Lighttpd比Apache更有优势，Nginx处理小文件的优势明显，Lighttpd综合最强。
动态数据的访问上：三者差距不大，Apache更有优势，因为处理动态数据的能力在于PHP（Java）和后端数据库的服务能力，也就是说瓶颈不在Web服务器上。
一般情况下普通PHP引擎支持的并发连接参考值300~1000。Java引擎和数据库的并发连接参考值300~1500。
为什么Nginx比Apache的性能高？

Nginx使用最新版的eepoll（Linux 2.6内核）和kqueue（FreeBSD）异步网络I/O模型，而Apache使用的是传统的select模型。
目前Linux下能够承受高并发访问的Squid、Memcached软件采用都是epoll模型。
处理大量的连接的读写时，Apache所采用的select网络I/O模型比较低。
如何正确采用Web服务器？

静态业务：如果是高并发场景，尽量采用Nginx或Lighttpd，二者首选Nginx。
动态业务：理论上采用Nginx和Apache均可，建议使用Nginx，为了避免相同业务服务的软件多样化，增加维护成本，动态业务可以使用Nginx兼做前端代理，再根据页面的元素或目录转发到其他的服务器进行处理。
既有动态业务又有静态业务，就用Nginx。
关于部署，就不在重复了，如果需要请移步《Java高级架构之FastDFS分布式文件集群》：https://blog.51cto.com/xvjunjie/2377669
