package cc.yuanspace.springboot.integration.mybatis.mapper;

import cc.yuanspace.springboot.integration.mybatis.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    UserDO selectOne(Long userId);
}
