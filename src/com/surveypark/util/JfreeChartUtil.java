package com.surveypark.util;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.surveypark.model.Data;

public class JfreeChartUtil {

	/**
	 * 设置字体
	 * 
	 * @param chart
	 */
	public static void setPieAttribute(JFreeChart chart) {
		Font font = new Font("宋体", Font.ITALIC, 12);
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(font);
		plot.setCircular(true);
		plot.setLabelFont(font);
		plot.setLabelGap(0.02D);
		plot.setLabelGenerator((PieSectionLabelGenerator) new StandardPieSectionLabelGenerator(
				"{0} {2}", NumberFormat.getNumberInstance(), new DecimalFormat(
						"0.00%")));
		chart.getTitle().setFont(font);
		chart.getLegend().setItemFont(font);
	}

	/**
	 * 设置饼图数据
	 * 
	 * @return
	 */
	public static DefaultPieDataset getPieData(List<Data> dataList) {
		DefaultPieDataset data = new DefaultPieDataset();
		for (Data d : dataList) {
			data.setValue(d.getName(), d.getCount());
		}
		return data;
	}

	/**
	 * 设置字体
	 * 
	 * @param chart
	 */
	public static void setBarAttribute(JFreeChart chart) {
		CategoryPlot plot = chart.getCategoryPlot();// 获取图表区域对象
		CategoryAxis domainAxis = plot.getDomainAxis();
		// 水平底部列表
		domainAxis.setLabelFont(new Font("宋体", Font.BOLD, 14));
		// 水平底部标题
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
		// 垂直标题
		ValueAxis rangeAxis = plot.getRangeAxis();// 获取柱状
		rangeAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
		LegendTitle legend = chart.getLegend();
		legend.setItemFont(new Font("宋体", Font.BOLD, 12));   
	}

	/**
	 * 设置柱状数据
	 * 
	 * @return
	 */
	public static DefaultCategoryDataset getBarData(List<Data> dataList) {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		for (Data d : dataList) {
			data.setValue(d.getCount(),d.getName(),d.getOther());
		}
		return data;
	}
}
