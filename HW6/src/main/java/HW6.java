import com.sun.istack.internal.NotNull;

public class HW6 {
/*
2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки.
Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ]
 */

private final static int DELIMITER = 4;

    public static int[] ExtractFromPacket(@NotNull int[] packet){
        for (int i = packet.length-1; i > 0; i--) {
            if (packet[i] == DELIMITER){
                int[] message = new int[packet.length - i - 1];
                for (int j = 0; j < packet.length - i - 1; j++) {
                    message[j] = packet[j+i+1];
                }
                return message;
            }
        } throw new RuntimeException("INPUT PACKET WITHOUT DELIMITER");
    }

/*
3. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
*/

    public static boolean Find14(@NotNull final int[] packet){
        if(Find(1,packet) & Find(4,packet)) return true;
        return false;
      }

    private static boolean Find (int number, int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i]==number) return true;
        }
        return false;
    }

}
