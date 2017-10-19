package com.zer0rez.rx.service;

import com.zer0rez.rx.domain.StandardDeviation;
import com.zer0rez.rx.repository.StandardDeviationRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class StandardDeviationController {

    private StandardDeviationRepository _repo;

    public StandardDeviationController(StandardDeviationRepository repo) {
        _repo = repo;
    }

    @RequestMapping(value = "/standardDeviation", method = RequestMethod.GET)
    public List<StandardDeviation> listStandardDeviations() {
        return _repo.findAll();
    }

    @RequestMapping(value = "/standardDeviation", method = RequestMethod.POST)
    public StandardDeviation saveStandardDeviation(@RequestBody StandardDeviation sd) {
        sd.setAnswer(calculateStandardDeviation(sd.getPoints()));
        sd.setCreated(new Date());
        return _repo.save(sd);
    }

    @RequestMapping(value = "/standardDeviation/{id}", method = RequestMethod.POST)
    public StandardDeviation getStandardDeviation(String id) {
        return _repo.findOne(id);
    }

    public BigDecimal calculateStandardDeviation(BigDecimal[] points) {
        BigDecimal mean = BigDecimal.valueOf(Stream.of(points).mapToDouble(d -> d.doubleValue()).average().getAsDouble());
        BigDecimal variance = BigDecimal.valueOf(Stream.of(points).mapToDouble(d -> mean.subtract(d).doubleValue()).map(d -> d * d).average().getAsDouble());
        return BigDecimal.valueOf(Math.sqrt(variance.doubleValue())).round(MathContext.DECIMAL32);
    }
}