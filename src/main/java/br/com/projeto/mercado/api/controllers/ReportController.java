package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.models.report.ExportType;
import br.com.projeto.mercado.service.impl.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping(path = "reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(value = "transactions/download")
    public ResponseEntity<Void> downloadTransactionReport(@RequestParam(value = "exportType") ExportType exportType,
                                                          HttpServletResponse response) throws IOException, JRException {
        reportService.downloadTransactionReport(exportType, response);
        return ResponseEntity.ok().build();
    }


}
