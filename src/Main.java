public class Main {
    public static void main(String[] args) {
        final int n = 4;
        String[][] array = {{"3", "4", "5", "6"},
                {"1", "2", "3", "4"},
                {"4", "3", "2", "1"},
                {"0", "0", "0", "0"}};
        String[][] arrayFalse4na4 = {{"3", "4", "5"},
                {"1", "2", "3"},
                {"4", "3", "2"},
                {"0", "f", "0"}};
        String[][] arrayFalseParseInt = {{"3", "4", "5", "6"},
                {"1", "2", "3", "4"},
                {"4", "f", "2", "1"},
                {"0", "38", "0", "0"}};

        int resultFalse;
        try {

            resultFalse = arrayString4na4(arrayFalseParseInt);
            System.out.println(resultFalse);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Измените данные в матрице, чтобы ее данные можно было преобразовать в число");
            resultFalse = 0;
            System.out.println(resultFalse);

        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Введите матрицу размерностью 4 на 4");

        }

    }


    public static int arrayString4na4(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array[0].length == 4 && array[1].length == 4) {
            for (int i = 0; i < array[0].length; i++) {
                for (int j = 0; j < array[1].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                        throw new MyArrayDataException("Нельзя преобразовать текстовое значение в число");
                    }
                }

            }
        } else {
            throw new MyArraySizeException("Вы ввели матрицу не размера 4 на 4");
        }
        return sum;
    }
}