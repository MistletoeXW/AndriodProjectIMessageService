package com.example.demo.utils.security;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.ConstCorrespond;
import com.example.demo.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: management
 * @description: 配置用户权限认证,根据用户登录输入的用户名，去读取用户信息.验证成功后会被保存在当前回话的principal对象中
 *               用户信息的获取逻辑
 *
 * @author: ggmr
 * @create: 2019-01-03 17:03
 */
@Slf4j
@Component
public class MyUserDetailService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 根据用户输入的用户名到存储数据库读取用户信息，并且封装到一个UserDetails接口实现类中，给后面处理和校验，
    // 如果处理通过了，spring就会把它放到session中 ，即登录成功
    // 如果找不到用户，那么会抛出用户名不存在异常
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        logger.info("登录用户：" + userId);
        //从数据库中获取这个用户
        User user = userMapper.selectByPrimaryKey(userId);
        if(user == null) {
            //后台抛出的异常是：org.springframework.security.authentication.BadCredentialsException:
            logger.info("登录用户：" + userId + " 不存在.");
            throw new UsernameNotFoundException("登录用户：" + userId + " 不存在");
        }

        //获取用户的身份
        String identity = "ROLE_USER";
        Set<GrantedAuthority> grantedAuths = new HashSet<>();
        grantedAuths.add( new SimpleGrantedAuthority(identity) );

        return new JwtUser(user.getId(), grantedAuths);
    }


}
