package io.home.functional;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        Supplier<List<Integer>> getSampleData_Supplier = () -> List.of(1,2,3,4);

        List<Integer> integers = getSampleData_Supplier.get();
        System.out.println("\ngetSampleData_Supplier.get() = "+integers);
    }
}
