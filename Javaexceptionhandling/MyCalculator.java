

    class MyCalculator {
      long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n veya p negatif olmamalıdır.");
        } else if (n == 0 && p == 0) {
            throw new Exception("n ve p sıfır olmamalıdır.");
        } else {
            return (long) Math.pow(n, p);
        }
    }
    


    }