package cn.itcast.bos.service.impl.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.FixedAreaRepository;
import cn.itcast.bos.domain.base.FixedArea;
import cn.itcast.bos.serivce.base.FixedAreaService;

@Service("fixedAreaService")
@Transactional
public class FixedAreaServiceImpl implements FixedAreaService {

	@Autowired
	private FixedAreaRepository fixedAreaRepository;
	
	@Override
	public void add(FixedArea model) {
		fixedAreaRepository.save(model);
	}

	@Override
	public Page<FixedArea> findFixedAreaListPage(Specification<FixedArea> spec, Pageable pageable) {
		Page<FixedArea> findAll = fixedAreaRepository.findAll(spec, pageable);
		return findAll;
	}

	@Override
	public void saveFixedArea(FixedArea model) {
		FixedArea save = fixedAreaRepository.save(model);
		System.out.println(save);
		
	}

}
