package com.adtec.daily.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * Created by guofan on 2018/3/36.
 */
public class TemplateParseUtil {

	public static boolean finishFlag = false;

	/**
	 * 解析模板生成Excel
	 *
	 * @param templateName
	 *            模板名称
	 * @param fileName
	 *            生成的Excel文件名
	 * @param data
	 *            数据参数
	 * @throws IOException
	 * @throws TemplateException
	 */
	private File parse(String templateName, String fileName, Map<String, Object> data)
			throws IOException, TemplateException {
		// 初始化工作
		FreeMarkerConfigurer freeMarkerConfigurer = SpringContextHolder.getBean("freeMarkerConfigurer");
		Configuration cfg = freeMarkerConfigurer.getConfiguration();
		// 全局数字格式
		cfg.setNumberFormat("0.00");
		// 加载模板
		Template template = cfg.getTemplate(templateName, "utf-8");
		File file = new File(fileName);
		Writer writer = null;
		try {
			// 填充数据至Excel
			writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
			template.process(data, writer);
			writer.flush();
		} finally {
			assert writer != null;
			writer.close();
		}

		return file;
	}

	/**
	 * 用freemarker解析生成excel
	 *
	 * @param data
	 * @param fileName
	 * @param templateFileName
	 * @throws IOException
	 */
	public File createExcel(Map<String, Object> data, String fileName, String templateFileName) throws IOException {

		File file = null;
		try {
			// 解析模版
			file = parse(templateFileName, fileName, data);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
		return file;
	}

	/**
	 * 用freemarker解析生成excel
	 *
	 * @param response
	 * @param data
	 * @param templateFileName
	 * @param fileName
	 * @throws IOException
	 */
	public void downloadExcel(HttpServletResponse response, Map<String, Object> data, String templateFileName, String fileName) throws IOException {

		InputStream inputStream = null;
		OutputStream out = null;
		File file = null;
		try {
			// 导出EXCEL
			file = createExcel(data, fileName, templateFileName);
			inputStream = new FileInputStream(file);
			String outfileName = new String(fileName.getBytes("GBK"), "ISO8859_1");
			response.setHeader("Content-disposition", "attachment; filename=" + outfileName + ".xls");
			response.setContentType("application/octet-stream; charset=utf-8");
			out = response.getOutputStream();
			byte[] buffer = new byte[1024]; // 缓冲区
			int bytesToRead;
			// 通过循环将读入的Excel文件的内容输出到浏览器中
			while ((bytesToRead = inputStream.read(buffer)) != -1) {
				out.write(buffer, 0, bytesToRead);
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (out != null) {
				out.close();
			}
			if (file != null) {
				file.delete();
			}
		}
	}
}
