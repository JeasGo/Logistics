package cn.itcast.bos.service.impl.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.AreaRepository;
import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.serivce.base.AreaService;

@Service("areaService")
@Transactional
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaRepository areaRepository;

	
	@Override
	public void saveArea(List<Area> areaList) {
		areaRepository.save(areaList);

	}


	@Override
	public Page<Area> findAreaListPage(Pageable pageable) {
		Page<Area> page = areaRepository.findAll(pageable);
		return page;
	}

}
