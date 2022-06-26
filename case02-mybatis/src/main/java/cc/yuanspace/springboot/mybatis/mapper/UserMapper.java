package cc.yuanspace.springboot.mybatis.mapper;

import cc.yuanspace.springboot.mybatis.entity.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    UserDO selectOne(Long userId);

    List<UserDO> listByGender(Integer gender);

    void insert(UserDO user);
}
