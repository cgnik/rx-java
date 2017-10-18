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

    @Before
    public void setUp() {
        _repository = Mockito.mock(StandardDeviationRepository.class);
        _controller = new StandardDeviationController(_repository);
    }

    @Test
    public void testCalcStdDev() {
        List<BigDecimal> valuesl = Stream.of(9f, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4)
                .map(d -> BigDecimal.valueOf(d.doubleValue()))
                .collect(Collectors.toList());
        BigDecimal[] values = new BigDecimal[valuesl.size()];
        valuesl.toArray(values);
        BigDecimal expected = BigDecimal.valueOf(4f);
        BigDecimal answer = _controller.calculateStandardDeviation(values);
        assertThat(expected).isEqualTo(answer);
    }

}

