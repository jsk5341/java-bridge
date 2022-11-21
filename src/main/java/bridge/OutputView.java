package bridge;

import java.util.ArrayList;
import java.util.List;
//TODO 리팩토링 하면서 다리 리스트 설계 파트 BridgeGame 으로 옮기기
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    String correct = " O ";
    String notSelected = "   ";
    String wrong = " X ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeAnswer, List<String> currentResult, Boolean userChoice, int stage) {
        List<String> finalResult = designBridgeMap(bridgeAnswer, currentResult, userChoice, stage);
        int size = finalResult.size();

        System.out.printf("[");
        for (int index = 0; index < size / 2; index++) {
            System.out.printf(finalResult.get(index));
            if(index<size/2-1){
                System.out.printf("|");
            }
        }
        System.out.println("]");


        System.out.printf("[");
        for (int index = size / 2; index < size; index++) {
            System.out.printf(finalResult.get(index));
            if(index<size-1){
                System.out.printf("|");
            }
        }
        System.out.println("]");
    }



    public List<String> designBridgeMap(List<String> bridgeAnswer, List<String> currentResult, Boolean userChoice, int stage) {
        if (userChoice) {
            currentResult = printMapCorrect(bridgeAnswer, currentResult, stage);
        }
        if (!userChoice) {
            currentResult = printMapWrong(bridgeAnswer, currentResult, stage);
        }
        return currentResult;
    }

    public List<String> printMapCorrect(List<String> bridgeAnswer, List<String> currentResult, int stage) {
        if (bridgeAnswer.get(stage).equals("U")) {
            currentResult = printMapUpsideCorrect(currentResult, stage);
        }
        if (bridgeAnswer.get(stage).equals("D")) {
            currentResult = printMapDownsideCorrect(currentResult, stage);
        }
        return currentResult;
    }

    public List<String> printMapWrong(List<String> bridgeAnswer, List<String> currentResult, int stage) {
        if (bridgeAnswer.get(stage).equals("U")) {
            currentResult = printMapUpsideWrong(currentResult, stage);
        }
        if (bridgeAnswer.get(stage).equals("D")) {
            currentResult = printMapDownsideWrong(currentResult, stage);
        }
        return currentResult;
    }

    public List<String> printMapUpsideCorrect(List<String> currentResult, int stage) {

        currentResult.add(notSelected);
        currentResult.add(stage, correct);

        return currentResult;
    }

    public List<String> printMapDownsideCorrect(List<String> currentResult, int stage) {
        currentResult.add(currentResult.size() - stage, notSelected);
        currentResult.add(correct);
        return currentResult;
    }

    public List<String> printMapUpsideWrong(List<String> currentResult, int stage) {
        currentResult.add(wrong);
        currentResult.add(stage, notSelected);

        return currentResult;
    }

    public List<String> printMapDownsideWrong(List<String> currentResult, int stage) {
        currentResult.add(currentResult.size() - stage, wrong);
        currentResult.add(notSelected);
        return currentResult;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridgeAnswer, List<String> currentResult, Boolean userChoice, int stage) {

        System.out.println("최종 게임 결과");

    }
}
