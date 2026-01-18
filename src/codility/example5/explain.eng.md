Step-by-step Explanation (English)

1. Understand the goal

We are given:

P: an array where each element represents the number of people currently sitting in each car

S: an array where each element represents the number of seats available in each car

Our goal is to minimize the number of cars used by moving people between cars, while making sure everyone has a seat.

2. Calculate the total number of people

First, I calculate the total number of people across all cars.

int totalPeople = 0;
for (int p : P) {
totalPeople += p;
}

This gives me the exact number of seats I need in total, regardless of how people are distributed initially.

3. Sort cars by seating capacity

Next, I sort the S array in ascending order.

Arrays.sort(S);

This allows me to use a greedy approach:
I will always take cars with the largest number of seats first, so that I can fit people into as few cars as possible.

4. Greedy accumulation of seats

I iterate from the car with the largest capacity to the smallest one.

int currentSeats = 0;
int carsUsed = 0;

for (int i = S.length - 1; i >= 0; i--) {
currentSeats += S[i];
carsUsed++;
if (currentSeats >= totalPeople) {
return carsUsed;
}
}

currentSeats keeps track of how many seats we have accumulated so far

carsUsed counts how many cars we are using

As soon as the total number of seats is greater than or equal to the total number of people, we can stop and return the
result

This works because taking larger cars first minimizes the number of cars needed.

5. Final result

If all cars are needed, the loop finishes and we return carsUsed.

return carsUsed;

Time & Space Complexity

Time complexity:

Sorting seats: O(N log N)

One loop through the array: O(N)

Overall: O(N log N)

Space complexity:

O(1) extra space (ignoring input arrays)

Interview tip (important) ⭐

When explaining this in an interview, always say this sentence:

“This is a greedy solution: by always choosing the cars with the largest seating capacity first, we minimize the number
of cars needed.”

Nếu bạn muốn, bước tiếp theo tôi có thể:

❓ hỏi bạn follow-up questions như interviewer Codility

🎤 luyện nói lại solution này trong 60 giây

🔥 giả lập Codility Q&A phản biện (edge cases, why greedy works)

Bạn muốn đi tiếp theo hướng nào?