名称：微信服务接口SDK

核心内容：主要对外统一提供对微信接口的访问，这是一个基于JAVA开发平台封装的SDK

版本：V1.0.1-SNAPSHOT

主要功能说明：
1、支持微信签名验证、JS-SDK签名验证、公众号对第三方平台的授权以及公众号和代公众号的消息发送和接收、自定义菜单、关注者信息的获取。
2、提供ACCESS_TOKEN、JSAPI_TICKET的获取接口，但不提供其数据的缓存存储（需调用SDK者自己进行相应的逻辑处理，以免调用次数过多而无法继续使用微信服务）。

3、外部调用该微信SDK，需要对SDK的缓存池进行初始化，即先初始化你的帐号ID和帐号密钥以及设置的安全token和加解密aesKey,且只需初始化一次，后续可到处调用SDK的接口。
4、如果是第三方平台调用、后续有公众号授权给第三方，接收授权成功的回调中需将此授权公众号的信息添加到缓存池中。

主要类和接口的说明以及方法说明：
1、WxCheckArithmetic：提供微信验证的算法。
2、WXBizMsgCryptUtils：提供微信加解密消息的工具类。
3、XStreamUtil：提供对xml的解析和反解析的工具类。
4、HttpClientUtil：提供http的post和get请求的工具类。
5、IWeixinBasisAPI：提供微信基础服务接口。
6、WeixinAPIFactory：用来创建微信接口的工厂类。
7、WeixinAPInitObject：调用方需要进行初始化的对象定义。