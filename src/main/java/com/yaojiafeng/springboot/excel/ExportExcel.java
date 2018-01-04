package com.yaojiafeng.springboot.excel;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author yaojiafeng
 * @create 2018-01-03 下午4:52
 */
@FunctionalInterface
public interface ExportExcel<T> {

    /**
     * 将字节数组写出到servlet输出流
     *
     * @param request
     * @param response http回应对象，为excel回应的目的地
     * @param list     要导出到 excel的数据集合
     * @param titles   excel的标题 通常取第一行作为excel的标题
     */
    default void exportExcel(HttpServletRequest request, HttpServletResponse response, List<T> list, String[] titles, String filename) throws IOException {
        byte[] bytes = selectExcel(list, titles);
        response.setContentType("application/msexcel;charset=UTF-8");
        if (isIE(request)) {
            response.addHeader("Content-Disposition",
                    "attachment;filename=\"" + URLEncoder.encode(filename, "UTF-8") + "\"");
        } else {
            String e = new String(filename.getBytes("UTF-8"), "ISO8859-1");
            response.addHeader("Content-Disposition", "attachment;filename=" + e);
        }
        response.setContentLength(bytes.length);
        response.getOutputStream().write(bytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

    /**
     * 选择要导出的文件 导出的excel 属于office 2007格式的文件
     *
     * @param list   excel文件内容
     * @param titles excel 文件的标题
     * @return 已经生成excel文件的字节数组
     */
    default byte[] selectExcel(List<T> list, String[] titles) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        generateExcelTitle(titles, sheet);
        eachListAndCreateRow(list, sheet);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            workbook.write(out);
            return out.toByteArray();
        }
    }

    /**
     * 遍历集合，并创建单元格行
     *
     * @param list  数据集合
     * @param sheet 工作簿
     */
    default void eachListAndCreateRow(List<T> list, Sheet sheet) {
        if (CollectionUtils.isNotEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                T t = list.get(i);
                Row row = sheet.createRow(i + 1);
                generateExcelForAs(t, row);
            }
        }
    }

    /**
     * 生成excel文件的标题
     */
    default void generateExcelTitle(String[] titles, Sheet sheet) {
        if (ArrayUtils.isNotEmpty(titles)) {
            Row row = sheet.createRow(0);
            for (int i = 0; i < titles.length; i++) {
                row.createCell(i, Cell.CELL_TYPE_STRING).setCellValue(titles[i]);
            }
        }
    }

    /**
     * 创建excel内容文件
     *
     * @param t   组装excel 文件的内容
     * @param row 当前excel 工作行
     */
    void generateExcelForAs(T t, Row row);

    static Boolean isIE(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        return userAgent == null ? Boolean.FALSE : Boolean.valueOf(userAgent.indexOf("MSIE") != -1 || userAgent.indexOf("rv:11") != -1);
    }
}
