package top.walterke.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.walterke.entity.VisitLog;
import top.walterke.exception.PersistenceException;
import top.walterke.mapper.VisitLogMapper;
import top.walterke.model.dto.UserAgentDTO;
import top.walterke.model.dto.VisitLogUuidTime;
import top.walterke.service.VisitLogService;
import top.walterke.util.IpAddressUtils;
import top.walterke.util.UserAgentUtils;

import java.util.List;

/**
 * @Description: 访问日志业务层实现
 *  
 * @Date: 2020-12-04
 */
@Service
public class VisitLogServiceImpl implements VisitLogService {
	@Autowired
	VisitLogMapper visitLogMapper;
	@Autowired
	UserAgentUtils userAgentUtils;

	@Override
	public List<VisitLog> getVisitLogListByUUIDAndDate(String uuid, String startDate, String endDate) {
		return visitLogMapper.getVisitLogListByUUIDAndDate(uuid, startDate, endDate);
	}

	@Override
	public List<VisitLogUuidTime> getUUIDAndCreateTimeByYesterday() {
		return visitLogMapper.getUUIDAndCreateTimeByYesterday();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveVisitLog(VisitLog log) {
		String ipSource = IpAddressUtils.getCityInfo(log.getIp());
		UserAgentDTO userAgentDTO = userAgentUtils.parseOsAndBrowser(log.getUserAgent());
		log.setIpSource(ipSource);
		log.setOs(userAgentDTO.getOs());
		log.setBrowser(userAgentDTO.getBrowser());
		if (visitLogMapper.saveVisitLog(log) != 1) {
			throw new PersistenceException("日志添加失败");
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteVisitLogById(Long id) {
		if (visitLogMapper.deleteVisitLogById(id) != 1) {
			throw new PersistenceException("删除日志失败");
		}
	}
}
