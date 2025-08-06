package algorithm_patterns.bitmask;

import java.util.Arrays;

public class LC691StickersToSpellWord {
    class Solution {
        public int minStickers(String[] stickers, String target) {
            int m = target.length(); // số lượng ký tự trong target

            // dp[mask] = số lượng sticker tối thiểu cần dùng để đạt được trạng thái 'mask'
            // mask là số nguyên có m bit, mỗi bit biểu diễn 1 ký tự trong target đã ghép hay chưa
            int[] dp = new int[1 << m]; // có 2^m trạng thái
            Arrays.fill(dp, Integer.MAX_VALUE); // khởi tạo tất cả trạng thái là vô hạn (chưa đạt được)
            dp[0] = 0; // base case: chưa ghép ký tự nào thì cần 0 sticker

            // Duyệt tất cả các trạng thái mask (từ 0 đến 2^m - 1)
            for (int mask = 0; mask < (1 << m); mask++) {
                if (dp[mask] == Integer.MAX_VALUE) continue; // nếu chưa đạt được mask này thì bỏ qua

                // Duyệt từng sticker để thử mở rộng trạng thái hiện tại
                for (String sticker : stickers) {
                    int nextMask = mask; // trạng thái mới sau khi dùng sticker

                    // Đếm sticker như một chuỗi ký tự
                    for (char c : sticker.toCharArray()) {
                        // Tìm ký tự này có thể giúp lấp được vị trí nào trong target chưa?
                        for (int i = 0; i < m; i++) {
                            // Nếu target[i] == c và vị trí đó chưa được ghép (bit i == 0)
                            if (target.charAt(i) == c && ((nextMask >> i) & 1) == 0) {
                                nextMask |= (1 << i); // bật bit i lên → đánh dấu đã ghép được ký tự đó
                                break; // mỗi ký tự sticker chỉ ghép 1 lần vào target
                            }
                        }
                    }

                    // Cập nhật dp cho trạng thái mới nếu dùng thêm 1 sticker là tốt hơn
                    dp[nextMask] = Math.min(dp[nextMask], dp[mask] + 1);
                }
            }

            // Kết quả là dp[fullMask] = dp[(1 << m) - 1] → tất cả ký tự đã được ghép xong
            return dp[(1 << m) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << m) - 1];
        }
    }

}
