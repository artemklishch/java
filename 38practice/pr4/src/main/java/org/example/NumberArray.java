package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberArray {
  public static int getMaxSubarraySum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int currentMax = nums[0];
    int globalMax = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currentMax = Math.max(nums[i], currentMax + nums[i]);
      if (currentMax > globalMax) {
        globalMax = currentMax;
      }
    }

    // Якщо глобальна максимальна сума менше нуля, повертаємо 0
    return Math.max(globalMax, 0);
  }
}
