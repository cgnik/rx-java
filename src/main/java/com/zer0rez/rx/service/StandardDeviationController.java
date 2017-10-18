package com.zer0rez.rx.service;

import com.zer0rez.rx.domain.StandardDeviation;
import com.zer0rez.rx.repository.StandardDeviationRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

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
        return _repo.save(sd);
    }

    @RequestMapping(value = "/standardDeviation/{id}", method = RequestMethod.POST)
    public StandardDeviation getStandardDeviation(String id) {
        return _repo.findOne(id);
    }

    public BigDecimal calculateStandardDeviation(BigDecimal[] points) {
        return BigDecimal.valueOf(4f);
    }
}