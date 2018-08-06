# Rest服务框架说明

##名词解释
    - demo ：公司名
    - example：项目名
##模块介绍
    - demo-example-rest-domain：领域层，聚合各领域数据
        - com.demo.example.rest.domain.config：客户端连接配置
    - demo-example-rest-api：rest API层
        - src\main\proto：proto文件
    - demo-example-rest-service：rest服务层
    - demo-example-rest-utils：工具包
##要求
    - 每个服务都需要写README.MD文件
    - 每个对外暴露的接口都需要做单元测试


# 服务环境说明

## 开发环境
    -服务器地址配置：https://radevio.com/demo/idcnew/src/master/sshconfig/gen.docker203
    -服务器名：ofexampleservice
    -所在目录：/data/demo-example-rest-service/
    -启动服务：exampleservice
    -域名：192.168.20.3
    -端口：28800

## 测试环境
    -服务器地址配置：https://radevio.com/demo/idcnew/src/master/sshconfig/gen.dockervmnew
    -服务器名：uexampleservice
    -所在目录：/data/demo-example-rest-service/
    -启动服务：exampleservice
    -域名：example.devmq.top
    -端口：28800
    
## 预发布环境
    -服务器地址配置：https://radevio.com/demo/idcnew/src/master/sshconfig/gen.ucloud.product
    -服务器名：pexampleservice2
    -所在目录：/data/demo-example-rest-service/
    -启动服务：exampleservice
    -域名：example.rest.demo.cn
    -端口：28800
    
## 生产环境
    -服务器地址配置：https://radevio.com/demo/idcnew/src/master/sshconfig/gen.ucloud.product
    -服务器名：pexampleservice1
    -所在目录：/data/demo-example-rest-service/
    -启动服务：exampleservice
    -域名：example.rest.demo.cn
    -端口：28800
  
  
  