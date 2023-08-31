package bridge;

import bridge.constant.BridgeType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int START_INDEX = 0;
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return IntStream.range(START_INDEX, size)
                .mapToObj(i -> getBridgeDirection())
                .collect(Collectors.toList());
    }

    private String getBridgeDirection() {
        final int randomNumber = bridgeNumberGenerator.generate();
        return BridgeType.getDirectionByClassifier(randomNumber);
    }
}
