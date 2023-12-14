package com.soa.canete.teen_soa_canete.util;

import com.soa.canete.teen_soa_canete.domain.model.Teen;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TeenReportGenerator {
    private final Scheduler jdbcScheduler = Schedulers.boundedElastic();

    public Mono<byte[]> exportToPdf(List<Teen> list) {
        return Mono.fromCallable(() -> generatePdf(list))
                .subscribeOn(jdbcScheduler);
    }

    private byte[] generatePdf(List<Teen> list) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReport(list));
    }

    private JasperPrint getReport(List<Teen> list) throws FileNotFoundException, JRException {
        Map<String, Object> params = new HashMap<>();
        params.put("teendata", new JRBeanCollectionDataSource(list));

        return JasperFillManager.fillReport(JasperCompileManager.compileReport(
                ResourceUtils.getFile("classpath:Adolescentes.jrxml")
                        .getAbsolutePath()), params, new JREmptyDataSource());
    }
}
