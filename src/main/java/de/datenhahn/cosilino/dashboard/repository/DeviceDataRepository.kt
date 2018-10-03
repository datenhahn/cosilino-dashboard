package de.datenhahn.cosilino.dashboard.repository

import de.datenhahn.cosilino.dashboard.model.DeviceData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Date

@Repository
interface DeviceDataRepository : JpaRepository<DeviceData, Long> {

	fun findAllByTimestampGreaterThanOrderByTimestampAsc(date : Date) : List<DeviceData>

}
