package de.datenhahn.cosilino.dashboard.model;

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "DeviceData")
class DeviceData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long = 0
	var deviceId: String? = null
	var roomHum: Double = 0.toDouble()
	var roomTemp: Double = 0.toDouble()
	var heaterTemp: Double = 0.toDouble()
	var heaterPower: Long = 0
	var timestamp: java.sql.Timestamp? = null
}
