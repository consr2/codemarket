package com.code.xss;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ExcelService {

	private String fileNm = "test";
	private String fileExtension = ".xlsx";
	
	public void createXSS(HttpServletResponse response) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("빈 시트지");
		
		// Sheet를 채우기 위한 데이터들을 Map에 저장
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"ID", "NAME", "PHONE_NUMBER"});
        data.put("2", new Object[]{"1", "cookie", "010-1111-1111"});
        data.put("3", new Object[]{"2", "sickBBang", "010-2222-2222"});
        data.put("4", new Object[]{"3", "workingAnt", "010-3333-3333"});
        data.put("5", new Object[]{"4", "wow", "010-4444-4444"});
		
        
        // data에서 keySet를 가져온다. 이 Set 값들을 조회하면서 데이터들을 sheet에 입력한다.
        Set<String> keyset = data.keySet();
        int rownum = 0;

        // 알아야할 점, TreeMap을 통해 생성된 keySet는 for를 조회시, 키값이 오름차순으로 조회된다.
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                cell.setCellValue((String)obj);
                sheet.autoSizeColumn(cellnum);//열 크기 자동 조절
            }
             
        }
        
        //엑셀 다운로드 시키기
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);

            byte[] excelBytes = outputStream.toByteArray();

            response.setContentType("application/vnd.ms-excel; charset=UTF-8;");
            response.setHeader("Content-disposition", "attachment; filename=" + fileNm + fileExtension);
            response.getOutputStream().write(excelBytes);//버퍼에 데이터 장전
            response.getOutputStream().flush();//버퍼의 데이터 발사
           
        } catch (IOException e) {
            e.printStackTrace();
        }
      
	}
}
