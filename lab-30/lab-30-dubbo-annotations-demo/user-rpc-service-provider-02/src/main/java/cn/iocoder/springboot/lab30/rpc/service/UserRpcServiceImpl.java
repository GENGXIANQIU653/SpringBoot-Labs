package cn.iocoder.springboot.lab30.rpc.service;

import cn.iocoder.springboot.lab30.rpc.api.UserRpcService;
import cn.iocoder.springboot.lab30.rpc.dto.UserDTO;
import org.apache.dubbo.config.annotation.Service;

/**
 * 在类上，我们添加的是 Dubbo 定义的 @Service 注解。并且，在该注解里，我们可以添加该 Service 服务的配置
 */
@Service(version = "${dubbo.provider.UserRpcService.version}")
public class UserRpcServiceImpl implements UserRpcService {

    @Override
    public UserDTO get(Integer id) {
        return new UserDTO().setId(id)
                .setName("没有昵称：" + id)
                .setGender(id % 2 + 1); // 1 - 男；2 - 女
    }

}
