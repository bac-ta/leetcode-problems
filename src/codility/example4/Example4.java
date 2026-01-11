package codility.example4;

public class Example4 {
    public int solution(int[] numbers) {
        int[] countFirst = new int[10];

        for (int num : numbers) {
            int firstNumber = getFirstDigit(num);
            countFirst[firstNumber]++;
        }

        int result = 0;

        for (int num : numbers) {
            int firstNumber = getFirstDigit(num);
            int lastNumber = firstNumber % 10;
            result += countFirst[lastNumber];

            if (firstNumber == lastNumber) {
                result--;
            }
        }
        return result;

    }

    private int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }
}
/**
 * # How to Explain This Solution (Technical Interview)
 * <p>
 * ## 🎯 Full Explanation Script (3-5 minutes)
 * <p>
 * ### **Version 1: Structured & Clear (Recommended)**
 * <p>
 * ---
 * <p>
 * **"Alright, let me walk you through my solution.**
 * <p>
 * **First, let me explain the problem:**
 * <p>
 * So we have an array of integers, and we need to find pairs of numbers where the last digit of the first number matches the first digit of the second number. The pairs are ordered, meaning (A, B) is different from (B, A).
 * <p>
 * **My approach has two main steps:**
 * <p>
 * **Step 1 - Count the frequency of first digits**
 * <p>
 * I create an array called `countFirst` of size 10, since digits range from 0 to 9. Then I iterate through all numbers and for each number, I extract its first digit and increment the corresponding count.
 * <p>
 * For example, if we have the number 123, the first digit is 1, so I do `countFirst[1]++`.
 * <p>
 * **Step 2 - Calculate valid pairs**
 * <p>
 * Now I iterate through the array again. For each number, I extract both its first and last digits.
 * <p>
 * Here's the key insight: the number of valid pairs where this number is the first element equals the count of numbers that start with this number's last digit.
 * <p>
 * For example, if the current number is 29, its last digit is 9. So I check `countFirst[9]` to see how many numbers start with 9. Let's say there's one number starting with 9, like 91. That means we found one valid pair: (29, 91).
 * <p>
 * **Edge case handling:**
 * <p>
 * There's one edge case - we need to avoid counting a number with itself. If a number's first digit equals its last digit, like 121, we would count it with itself, which is invalid. So when `firstDigit == lastDigit`, I subtract 1 from the result.
 * <p>
 * **Complexity analysis:**
 * <p>
 * Time complexity is O(N) because we iterate through the array twice, and each iteration is linear.
 * <p>
 * Space complexity is O(1) because we only use a fixed-size array of 10 elements, regardless of input size.
 * <p>
 * **That's my solution. Does this make sense?**"
 * <p>
 * ---
 * <p>
 * ## 🎯 Version 2: Think-Aloud Style (During Live Coding)
 * <p>
 * ---
 * <p>
 * **"Okay, so I need to find pairs where the last digit of one number matches the first digit of another.**
 * <p>
 * Let me think about the brute force first... I could use two nested loops to compare every pair, but that would be O(N²), which isn't ideal for large inputs.
 * <p>
 * **What's the key observation here?**
 * <p>
 * Each number only cares about two things: its first digit and its last digit. And digits only range from 0 to 9. That's a very small domain.
 * <p>
 * So instead of comparing numbers directly, I can compress the information by counting how many numbers start with each digit.
 * <p>
 * **Let me code this up...**
 * <p>
 * First, I'll create a helper method `getFirstDigit` that extracts the first digit by repeatedly dividing by 10.
 * <p>
 * Now, I'll create an array `countFirst` to store the frequency of each starting digit.
 * <p>
 * *(while coding)*
 * <p>
 * Okay, now I iterate through the array and count the first digits...
 * <p>
 * For the second part, I iterate again and for each number, I check how many numbers start with this number's last digit.
 * <p>
 * Oh wait, I need to handle the case where a number starts and ends with the same digit, otherwise I'd count it with itself, which is invalid. So I'll subtract 1 when `firstDigit == lastDigit`.
 * <p>
 * **Let me trace through an example to verify:**
 * <p>
 * If we have [12, 29, 91]:
 * - 12: last digit is 2, how many start with 2? → 29 starts with 2 → 1 pair
 * - 29: last digit is 9, how many start with 9? → 91 starts with 9 → 1 pair
 * - 91: last digit is 1, how many start with 1? → 12 starts with 1 → 1 pair
 * <p>
 * Total: 3 pairs ✓
 * <p>
 * **Looks good!**"
 * <p>
 * ---
 * <p>
 * ## 🎯 Version 3: Concise (If Asked for Quick Summary)
 * <p>
 * ---
 * <p>
 * **"My approach uses a frequency counting technique.**
 * <p>
 * I first count how many numbers start with each digit using a size-10 array. Then for each number, I check how many numbers have a first digit matching this number's last digit. The sum gives us all valid pairs.
 * <p>
 * The edge case is when a number's first and last digits are the same - we subtract 1 to avoid counting it with itself.
 * <p>
 * Time complexity is O(N), space is O(1)."
 * <p>
 * ---
 * <p>
 * ## 📝 Key Phrases to Use
 * <p>
 * ### **When explaining approach:**
 * - "My approach is to..."
 * - "The key insight here is..."
 * - "Instead of using brute force, I..."
 * - "Let me break this down into two steps..."
 * <p>
 * ### **When discussing complexity:**
 * - "This runs in linear time because..."
 * - "Space complexity is constant since..."
 * - "We iterate through the array twice, so it's O(N)"
 * <p>
 * ### **When handling edge cases:**
 * - "There's one edge case we need to handle..."
 * - "We need to avoid the case where..."
 * - "To handle this, I subtract 1 when..."
 * <p>
 * ### **When explaining code:**
 * - "First, I create a helper method to..."
 * - "Then I iterate through..."
 * - "For each number, I extract..."
 * - "The result is accumulated by..."
 * <p>
 * ### **When verifying:**
 * - "Let me trace through an example..."
 * - "If we have the array [12, 29, 91]..."
 * - "This gives us the correct result"
 * <p>
 * ### **If you don't understand a question:**
 * - "Sorry, could you clarify what you mean by...?"
 * - "Just to make sure I understand, you're asking about...?"
 * - "Let me rephrase the question to confirm..."
 * <p>
 * ---
 * <p>
 * ## 🎯 Common Follow-up Questions & Answers
 * <p>
 * ### Q: "What if the array is empty?"
 * **A:** "Good question. With an empty array, the result would be 0, which is correct since there are no pairs. The code handles this naturally because we wouldn't enter the loop."
 * <p>
 * ### Q: "What if numbers can be negative?"
 * **A:** "If negative numbers are allowed, we'd need to modify `getFirstDigit` to handle the negative sign. We could take the absolute value first, or we could treat the negative sign separately depending on the requirements."
 * <p>
 * ### Q: "Can you optimize space further?"
 * **A:** "The space is already O(1) since we're using a fixed-size array of 10 elements. We could avoid the array by using a HashMap, but that would actually be less efficient for this problem since digits have such a small domain."
 * <p>
 * ### Q: "What if we needed to return the actual pairs, not just the count?"
 * **A:** "In that case, I'd modify the approach. Instead of counting, I'd store lists of indices for each first digit. Then when iterating, I'd add all matching indices to a result list. The time complexity would remain O(N), but space would be O(N) to store the pairs."
 * <p>
 * ---
 * <p>
 * ## 💡 Tips for Delivery
 * <p>
 * ✅ **DO:**
 * - Speak clearly and at a moderate pace
 * - Pause briefly between sections
 * - Use your hands if helpful (even on video calls)
 * - Show enthusiasm but stay professional
 * - Ask "Does this make sense?" at the end
 * <p>
 * ❌ **DON'T:**
 * - Rush through the explanation
 * - Use filler words excessively ("um", "like", "you know")
 * - Apologize unnecessarily
 * - Read code line by line without context
 * - Assume the interviewer knows what you're thinking
 * <p>
 * ---
 * <p>
 * ## 🎯 Practice Plan
 * <p>
 * **Day 1-2:** Read Version 1 aloud 3 times
 * <p>
 * **Day 3-4:** Record yourself explaining (don't look at script)
 * <p>
 * **Day 5-6:** Listen to recording, improve weak parts
 * <p>
 * **Day 7:** Practice with a friend or ChatGPT voice mode
 * <p>
 * **Target:** Explain smoothly in 3-4 minutes without notes
 *
 *
 **/

