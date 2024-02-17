package Week1;


public class Exercise1RandomNumbers {
    public static void main(String[] args) {
        int[] randomNumbers = { 0, 3072, 2, 1026, 2050, 1027, 3077, 1031, 4103, 8, 2056, 2060, 13, 3086, 1048, 2074, 27,
                28, 4124, 3103, 2079, 4128, 2081, 3106, 35, 3113, 1065, 4137, 4138, 4139, 4140, 1068, 4142, 2095, 51,
                4151, 1081, 2107, 4161, 3138, 1090, 1091, 2115, 3140, 1093, 1095, 3144, 1098, 4172, 3149, 1102, 4177,
                4178, 82, 4182, 88, 93, 3168, 2146, 4195, 3173, 1128, 107, 1133, 1134, 2162, 1141, 117, 3190, 3191, 120,
                1145, 122, 124, 125, 1149, 126, 128, 2182, 2184, 4233, 4234, 3212, 141, 3214, 143, 148, 3220, 3223,
                2203, 1179, 2204, 3229, 158, 4261, 2216, 4267, 3244, 2221, 1198, 2222, 2223, 179, 3253, 2229, 2230, 183,
                1208, 186, 3259, 2236, 3262, 197, 2247, 2248, 202, 3275, 2252, 1228, 3277, 1235, 3283, 2260, 3285, 213,
                3286, 4311, 2264, 2268, 4322, 1253, 3303, 1256, 2282, 4333, 3310, 1265, 2289, 1266, 4344, 2300, 3326,
                2305, 261, 2313, 4362, 2315, 1297, 4370, 2322, 2323, 4376, 4379, 3356, 289, 2341, 2342, 1319, 1320, 300,
                4397, 304, 2353, 4406, 3384, 2360, 4411, 1339, 1344, 4417, 324, 3399, 328, 1359, 2384, 3411, 2389, 4438,
                342, 348, 2397, 351, 352, 1379, 2408, 1387, 364, 366, 1395, 2419, 372, 2421, 1397, 375, 376, 4472, 382,
                1407, 4479, 3458, 1413, 3462, 2439, 2441, 1418, 4491, 3467, 1422, 398, 3473, 2452, 406, 2457, 3483,
                4509, 1439, 3489, 3493, 1449, 2476, 4525, 431, 2479, 3505, 3506, 434, 2485, 1463, 439, 4539, 2491, 2493,
                447, 3520, 2500, 2503, 3528, 1481, 1482, 3532, 1488, 2514, 4563, 467, 2519, 2521, 2522, 4571, 2526,
                2530, 489, 3562, 492, 2541, 3567, 497, 1522, 4595, 3571, 4596, 4597, 1528, 504, 508, 3580, 509, 1535,
                2560, 4609, 2562, 3589, 517, 518, 1543, 2568, 524, 4621, 528, 1560, 1561, 3610, 1564, 2589, 3615, 544,
                2594, 548, 1579, 1580, 3628, 559, 3632, 2608, 1587, 2613, 3639, 4665, 4667, 1595, 1596, 3648, 4674,
                4676, 4677, 4679, 3655, 2632, 2636, 593, 4689, 2641, 595, 2643, 3669, 3670, 2648, 2649, 4698, 2651, 606,
                1632, 4706, 4707, 1643, 1645, 3695, 1647, 2672, 4723, 1651, 2676, 1653, 1654, 1656, 634, 4731, 3707,
                1662, 641, 2695, 2699, 1681, 3731, 4756, 660, 3734, 4759, 1687, 2714, 4765, 1694, 1695, 4770, 4772,
                4775, 3756, 1709, 3762, 693, 3767, 3771, 1723, 2751, 707, 2755, 708, 4805, 3782, 4806, 711, 4813, 1743,
                1744, 1745, 3796, 4823, 2776, 3800, 4826, 730, 3805, 1757, 3809, 739, 4836, 743, 1771, 1777, 3827, 3828,
                1782, 3830, 759, 761, 763, 2815, 2816, 1794, 2820, 772, 1796, 1797, 4871, 1800, 3852, 1807, 1814, 2840,
                3864, 1819, 795, 3870, 803, 3876, 2853, 806, 4904, 809, 4905, 812, 3886, 4912, 4913, 1841, 3891, 1845,
                2870, 825, 4922, 1851, 4925, 1855, 3904, 1857, 4932, 839, 840, 2891, 3917, 845, 2895, 848, 850, 3928,
                2906, 1886, 863, 2912, 3936, 4963, 2915, 1891, 1894, 2918, 876, 877, 2928, 3955, 1908, 1909, 3958, 3965,
                3966, 3972, 900, 3973, 4999, 2960, 915, 2969, 3994, 1948, 2979, 2982, 937, 1961, 2988, 945, 4021, 2997,
                4022, 3000, 955, 1979, 4029, 4042, 973, 3027, 3030, 3036, 2022, 4070, 4071, 3048, 2029, 4079, 4081,
                3060, 1013, 1020 };

        System.out.println(randomNumbers.length);
        // Test findNumber
        int findNum = findNumber(randomNumbers);
        System.out.println("Found number is: " + findNum);
        // Test findLargest
        int largest = findLargest(randomNumbers);
        System.out.println("Largest number is: " + largest);
        // Test findSmallest
        int smallest = findSmallest(randomNumbers);
        System.out.println("Smallest number is: " + smallest);
    }

    private static int findNumber(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 559) {
                System.out.println("It took "+i+" loops");
                return i; // Return the index where the number is found
            }
        }
        return -1; // Return -1 if the number is not found
    }


    private static int findLargest(int[] numbers) {
        int max = numbers[0]; // Assume first element is the largest initially

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i]; // Update max if current element is larger
            }
        }
        System.out.println("It took "+numbers.length+" loops");
        return max;
    }

    private static int findSmallest(int[] numbers) {

        int min = numbers[0]; // Assume first element is the smallest initially
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i]; // Update min if current element is smaller
            }
        }
        System.out.println("It took "+numbers.length+" loops");
        return min;
    }
}
