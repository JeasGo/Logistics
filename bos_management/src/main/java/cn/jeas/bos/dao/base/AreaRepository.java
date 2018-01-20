package cn.jeas.bos.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.jeas.bos.domain.base.Area;

public interface AreaRepository extends JpaRepository<Area, String> {

//	List<Area> finByProvinceLikeOrCityLikeOrDistrictLikeOrShortcodeOrCitycode(String province, String city,
//			String district, String shortcode, String citycode);

	Area findByProvinceAndCityAndDistrict(String province, String city, String district);
}
