package cn.jeas.bos.serivce.base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.jeas.bos.domain.base.Area;

public interface AreaService {

	/**
	 * 说明：批量保存区域
	 * 
	 * @param areaList
	 */
	void saveArea(List<Area> areaList);

	/**
	 * 说明: 分页展示区域数据
	 * 
	 * @param pageable
	 * @return
	 */
	Page<Area> findAreaListPage(Pageable pageable);

}
