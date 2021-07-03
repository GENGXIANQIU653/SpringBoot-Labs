package cn.iocoder.springboot.lab30.rpc.service;


import cn.iocoder.springboot.lab30.rpc.api.UserRpcService;
import cn.iocoder.springboot.lab30.rpc.core.ServiceException;
import cn.iocoder.springboot.lab30.rpc.core.ServiceExceptionEnum;
import cn.iocoder.springboot.lab30.rpc.dto.UserAddDTO;
import cn.iocoder.springboot.lab30.rpc.dto.UserDTO;
import org.springframework.stereotype.Service;


/**
 * 注意，在类上添加了 Spring @Service 注解，暴露出 UserRpcServiceImpl Bean 对象。
 * 后续，我们会将该 Bean 暴露成 UserRpcService Dubbo 服务，注册其到注册中心中，并提供相应的 Dubbo 服务
 */
@Service
public class UserRpcServiceImpl implements UserRpcService {

    @Override
    public UserDTO get(Integer id) {
        return new UserDTO().setId(id)
                .setName("没有昵称：" + id)
                // 1 - 男；2 - 女
                .setGender(id % 2 + 1);
    }

    @Override
    public Integer add(UserAddDTO addDTO) {
        // 这里，模拟用户已经存在的情况
        if ("yudaoyuanma".equals(addDTO.getName())) {
            throw new ServiceException(ServiceExceptionEnum.USER_EXISTS);
        }
        // 嘿嘿，随便返回一个 id
        return (int) (System.currentTimeMillis() / 1000);
    }

}
