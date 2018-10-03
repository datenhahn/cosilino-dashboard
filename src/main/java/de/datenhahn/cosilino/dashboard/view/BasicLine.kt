package de.datenhahn.cosilino.dashboard.view

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.charts.Chart
import com.vaadin.flow.component.charts.model.AxisTitle
import com.vaadin.flow.component.charts.model.ChartType
import com.vaadin.flow.component.charts.model.HorizontalAlign
import com.vaadin.flow.component.charts.model.LayoutDirection
import com.vaadin.flow.component.charts.model.ListSeries
import com.vaadin.flow.component.charts.model.PlotOptionsLine
import com.vaadin.flow.component.charts.model.VerticalAlign
import de.datenhahn.cosilino.dashboard.model.DeviceData


fun getChart(deviceName : String, deviceId : String, data: List<DeviceData>): Component {

	val chart = Chart()
	chart.height = "450px"
	chart.width = "100%"

	val configuration = chart.configuration
	configuration.chart.type = ChartType.LINE
	configuration.chart.marginRight = 130
	configuration.chart.marginBottom = 25

	configuration.title.text = "Device Data " + deviceName
	configuration.subTitle.text = "ID: " + deviceId

	val xAxisCategories = data.map { deviceData -> "" + deviceData.timestamp }

	configuration.getxAxis().setCategories(*xAxisCategories.toTypedArray())

	val yAxis = configuration.getyAxis()
	yAxis.title = AxisTitle("Temperature (°C)")
	yAxis.title.align = VerticalAlign.MIDDLE

	configuration
			.tooltip.formatter = "'<b>'+ this.series.name +'</b><br/>'+this.x +': '+ this.y +'°C'"

	val plotOptions = PlotOptionsLine()
	plotOptions.dataLabels.enabled = true
	configuration.setPlotOptions(plotOptions)

	val legend = configuration.legend
	legend.layout = LayoutDirection.VERTICAL
	legend.align = HorizontalAlign.RIGHT
	legend.verticalAlign = VerticalAlign.TOP
	legend.x = -10.0
	legend.y = 100.0

	val ls = ListSeries()
	ls.name = "Temp Heater"
	ls.setData(data.map { deviceData -> deviceData.heaterTemp })
	configuration.addSeries(ls)

	val ls2 = ListSeries()
	ls2.name = "Temp Room"
	ls2.setData(data.map { deviceData -> deviceData.roomTemp })
	configuration.addSeries(ls2)

	val ls3 = ListSeries()
	ls3.name = "Humidity Room"
	ls3.setData(data.map { deviceData -> deviceData.roomHum })
	configuration.addSeries(ls3)

	val ls4 = ListSeries()
	ls4.name = "Heater Power"
	ls4.setData(data.map { deviceData -> deviceData.heaterPower })
	configuration.addSeries(ls4)

	chart.drawChart()
	return chart
}
