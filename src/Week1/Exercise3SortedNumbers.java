package Week1;

public class Exercise3SortedNumbers {
    public static void main (String[] args){
        int[] randomNumers = { 0, 9, 14, 25, 26, 29, 46, 59, 64, 72, 74, 78, 85, 91, 96, 100, 105, 117, 128, 137, 169,
                173, 174, 176, 193, 216, 217, 227, 234, 241, 242, 250, 263, 264, 290, 308, 321, 339, 359, 365, 371, 373,
                381, 397, 421, 427, 428, 432, 449, 460, 464, 475, 476, 495, 502, 504, 517, 526, 537, 547, 552, 554, 560,
                568, 570, 586, 613, 626, 635, 648, 668, 670, 671, 678, 682, 683, 691, 698, 700, 709, 725, 736, 747, 756,
                769, 772, 786, 791, 806, 813, 814, 835, 843, 854, 858, 868, 872, 874, 910, 918, 919, 922, 941, 973, 996,
                1003, 1006, 1008, 1019, 1035, 1037, 1050, 1059, 1089, 1090, 1099, 1113, 1118, 1123, 1138, 1140, 1147,
                1152, 1153, 1164, 1176, 1182, 1187, 1192, 1193, 1198, 1206, 1226, 1237, 1261, 1277, 1293, 1310, 1318,
                1326, 1328, 1341, 1348, 1357, 1359, 1362, 1372, 1377, 1394, 1406, 1408, 1418, 1427, 1430, 1440, 1462,
                1464, 1485, 1488, 1494, 1495, 1498, 1500, 1533, 1539, 1583, 1606, 1620, 1644, 1656, 1658, 1670, 1687,
                1692, 1694, 1700, 1727, 1730, 1751, 1754, 1762, 1782, 1805, 1806, 1810, 1821, 1824, 1832, 1835, 1846,
                1849, 1851, 1864, 1874, 1881, 1882, 1883, 1892, 1899, 1912, 1914, 1921, 1956, 1960, 1983, 2012, 2026,
                2029, 2045, 2062, 2068, 2078, 2083, 2093, 2097, 2100, 2108, 2131, 2136, 2157, 2164, 2171, 2175, 2178,
                2180, 2192, 2216, 2228, 2238, 2240, 2245, 2247, 2249, 2254, 2256, 2263, 2266, 2280, 2285, 2290, 2293,
                2331, 2335, 2337, 2345, 2349, 2351, 2356, 2365, 2372, 2400, 2418, 2431, 2437, 2444, 2451, 2452, 2460,
                2474, 2475, 2484, 2502, 2504, 2516, 2522, 2542, 2555, 2560, 2566, 2582, 2587, 2606, 2625, 2650, 2653,
                2658, 2669, 2699, 2709, 2715, 2716, 2718, 2733, 2735, 2738, 2760, 2764, 2769, 2772, 2782, 2784, 2785,
                2795, 2804, 2811, 2815, 2829, 2835, 2871, 2878, 2879, 2896, 2899, 2909, 2924, 2925, 2946, 2953, 2959,
                2991, 3031, 3037, 3045, 3048, 3068, 3077, 3088, 3091, 3097, 3111, 3115, 3123, 3127, 3135, 3152, 3159,
                3166, 3179, 3201, 3222, 3228, 3232, 3247, 3259, 3260, 3267, 3291, 3312, 3317, 3336, 3354, 3366, 3391,
                3405, 3414, 3443, 3447, 3451, 3472, 3483, 3484, 3488, 3502, 3512, 3513, 3514, 3518, 3522, 3560, 3567,
                3573, 3592, 3595, 3597, 3602, 3617, 3629, 3649, 3668, 3692, 3698, 3699, 3721, 3724, 3727, 3730, 3746,
                3758, 3786, 3794, 3797, 3817, 3830, 3844, 3846, 3884, 3891, 3908, 3919, 3931, 3936, 3961, 3963, 3965,
                3978, 3984, 3995, 4004, 4006, 4012, 4015, 4022, 4041, 4046, 4055, 4060, 4069, 4071, 4109, 4113, 4115,
                4123, 4146, 4156, 4165, 4173, 4174, 4178, 4192, 4197, 4226, 4227, 4234, 4271, 4273, 4283, 4289, 4291,
                4306, 4315, 4319, 4320, 4321, 4327, 4330, 4346, 4369, 4371, 4392, 4405, 4428, 4434, 4465, 4473, 4485,
                4509, 4518, 4541, 4550, 4554, 4559, 4572, 4583, 4593, 4600, 4612, 4615, 4636, 4647, 4662, 4663, 4679,
                4695, 4696, 4722, 4727, 4728, 4761, 4765, 4774, 4787, 4796, 4797, 4815, 4833, 4837, 4854, 4862, 4867,
                4874, 4876, 4880, 4881, 4882, 4885, 4902, 4907, 4914, 4919, 4927, 4943, 4965, 4975, 4977, 4983, 4985,
                4987, 4989, 4990, 4998 };

        System.out.println(randomNumers.length);
        System.out.println(findNumber(randomNumers));
        System.out.println("This is the largest number: "+findLargest(randomNumers));
        System.out.println("This is the smallest number: "+findSmallest(randomNumers));
    }
    private static int findNumber(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 2716) {
                System.out.println("It took "+i+" loops");
                return i; // Return the index where the number is found
            }
        }
        return -1; // Return -1 if the number is not found
    }

    private static int findLargest(int[] numbers) {
        System.out.println("It took "+numbers.length+" loops");
        return numbers[numbers.length - 1]; // Last element is the largest in a sorted array
    }

    private static int findSmallest(int[] numbers) {
        System.out.println("It took "+numbers.length+" loops");
        return numbers[0]; // First element is the smallest in a sorted array
    }
}
