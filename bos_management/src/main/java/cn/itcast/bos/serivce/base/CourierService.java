package cn.itcast.bos.serivce.base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.itcast.bos.domain.base.Courier;
@Service
public interface CourierService {

	/**
	 * 功能:保存快递员功能
	 * @param courier
	 */
	void saveCourier(Courier courier);
	/**
	 * 功能:查询分页功能
	 * @param spec 
	 * @param pageable
	 * @return
	 */
	Page<Courier> findCourierListPage(Specification<Courier> spec, Pageable pageable);
	/**
	 * 功能: 作废快递员
	 * 逻辑删除 物理不删 只是定义字段  实质上是更新
	 * @param ids
	 * @throws Exception 
	 */
	void deleteCourierBatch(String ids) throws Exception;
	List<Courier> finAll();

}
