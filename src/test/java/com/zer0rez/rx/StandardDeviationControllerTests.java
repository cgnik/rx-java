package com.zer0rez.rx;


import com.zer0rez.rx.repository.StandardDeviationRepository;
import com.zer0rez.rx.service.StandardDeviationController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StandardDeviationControllerTests {

    StandardDeviationController _controller;

    StandardDeviationRepository _repository;

    static final BigDecimal[] _values;

    static {
        List<BigDecimal> valuesl = Stream.of(32, 22, 12.3, 4.33, 8.121, 0.231)
                .map(d -> BigDecimal.valueOf(d.doubleValue()))
                .collect(Collectors.toList());
        _values = new BigDecimal[valuesl.size()];
        valuesl.toArray(_values);
    }

    @Before
    public void setUp() {
        _repository = Mockito.mock(StandardDeviationRepository.class);
        _controller = new StandardDeviationController(_repository);
    }

    @Test
    public void testCalcStdDev() {
        assertThat(_controller.calculateStandardDeviation(_values)).isEqualTo(BigDecimal.valueOf(10.83474));
    }
}

