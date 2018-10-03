package de.datenhahn.cosilino.dashboard.service

import de.datenhahn.cosilino.dashboard.model.DeviceData
import de.datenhahn.cosilino.dashboard.repository.DeviceDataRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@Service
class DeviceDataService(private val deviceDataRepository: DeviceDataRepository) {

	fun getDeviceData(): List<DeviceData> {
		val now = LocalDateTime.now()
		return deviceDataRepository.findAllByTimestampGreaterThanOrderByTimestampAsc(Date.from(now.minusDays(1).atZone(ZoneId.systemDefault()).toInstant()))
	}
}
