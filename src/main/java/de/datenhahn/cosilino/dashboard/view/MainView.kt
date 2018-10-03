package de.datenhahn.cosilino.dashboard.view

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.notification.Notification
import de.datenhahn.cosilino.dashboard.service.MessageBean
import org.springframework.beans.factory.annotation.Autowired

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import de.datenhahn.cosilino.dashboard.service.DeviceDataService

@Route
class MainView(@Autowired deviceDataService: DeviceDataService) : VerticalLayout() {

	init {
		val data = deviceDataService.getDeviceData();
		add(getChart("Schlafzimmer", "XXX", data))
	}

}
