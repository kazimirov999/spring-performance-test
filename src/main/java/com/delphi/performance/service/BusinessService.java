package com.delphi.performance.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by kazimirov on 7/24/17.
 */
@Service
public class BusinessService {

    public BigInteger countFactorial(Long n) {

        return (1 > n) ? new BigInteger("1") : new BigInteger(String.valueOf((n))).multiply(countFactorial(n - 1));
    }
}
