package cc.yuanspace.springboot.mybatis.mapper;

import cc.yuanspace.springboot.mybatis.entity.UserDO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    UserDO selectOne(Long userId);
}
