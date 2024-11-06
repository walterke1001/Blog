package top.walterke.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.walterke.entity.About;

import java.util.List;

/**
 * @Description: 关于我持久层接口
 *  
 * @Date: 2020-08-31
 */
@Mapper
@Repository
public interface AboutMapper {
	List<About> getList();

	int updateAbout(String nameEn, String value);

	String getAboutCommentEnabled();
}
