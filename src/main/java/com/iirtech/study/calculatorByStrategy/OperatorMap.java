package com.iirtech.study.calculatorByStrategy;

import com.iirtech.study.calculatorByStrategy.operator.imple.*;
import com.iirtech.study.calculatorByStrategy.operator.useEnum.RamdaEnum;

import java.util.HashMap;
import java.util.Map;

public class OperatorMap {

    Map<String, RamdaEnum> opMap = new HashMap<>();

    public OperatorMap() {
        MinusInfo minus = new MinusInfo();
        PlusInfo plus = new PlusInfo();
        MultiplyInfo multiply = new MultiplyInfo();
        DevideInfo devide = new DevideInfo();
        SquareInfo square = new SquareInfo();
        EtcInfo etc = new EtcInfo();

        opMap.put("-", RamdaEnum.MINUS);
        opMap.put("+", RamdaEnum.PLUS);
        opMap.put("*", RamdaEnum.MULTIPLY);
        opMap.put("/", RamdaEnum.DIVIDE);
        opMap.put("^", RamdaEnum.SQUARE);
        opMap.put("(", RamdaEnum.ETC1);
        opMap.put(")", RamdaEnum.ETC2);

    }

    public Map<String, RamdaEnum> getOpMap() {
        return this.opMap;
    }

}
