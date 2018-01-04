package com.yaojiafeng.springboot.controller;

import com.yaojiafeng.springboot.domain.City;
import com.yaojiafeng.springboot.excel.ExportExcel;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author yaojiafeng
 * @create 2018-01-03 下午3:40
 */
@RestController
@Slf4j
public class ExcelController implements IExcelController {

    @Override
    public void export(HttpServletResponse response, HttpServletRequest request) {
        try {
            City city = new City(1L, 1L, "1", "1");
            ((ExportExcel<City>) (obj, row) -> {
                row.createCell(0, Cell.CELL_TYPE_STRING).setCellValue(obj.getId());
                row.createCell(1, Cell.CELL_TYPE_STRING).setCellValue(obj.getProvinceId());
                row.createCell(2, Cell.CELL_TYPE_STRING).setCellValue(obj.getCityName());
                row.createCell(3, Cell.CELL_TYPE_STRING).setCellValue(obj.getDescription());
            }).exportExcel(request, response, Arrays.asList(city), new String[]{"ID", "ProvinceId", "CityName", "Description"}, "城市.xls");
        } catch (IOException e) {
            log.error("export statistics statement rule error", e);
        }
    }
}
