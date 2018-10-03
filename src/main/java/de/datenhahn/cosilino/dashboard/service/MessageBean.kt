package de.datenhahn.cosilino.dashboard.service

import java.time.LocalTime
import org.springframework.stereotype.Service

@Service
class MessageBean {

	val message: String
		get() = "Button was clicked at " + LocalTime.now()
}
