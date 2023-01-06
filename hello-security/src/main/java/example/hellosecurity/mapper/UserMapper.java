package example.hellosecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import example.hellosecurity.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
