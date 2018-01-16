package cn.itcast.bos.serivce.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.itcast.bos.domain.base.FixedArea;

@Service
public interface FixedAreaService {

	/**
	 * 功能:添加FixedArea pojo
	 * @param model
	 */
	void add(FixedArea model);

	Page<FixedArea> findFixedAreaListPage(Specification<FixedArea> spec, Pageable pageable);

	void saveFixedArea(FixedArea model);

}
